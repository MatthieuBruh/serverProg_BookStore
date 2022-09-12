package fi.haagahelia.bookstore.web;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping(value = "/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("isbn") String bookISBN, Model model) {
        repository.deleteById(bookISBN);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBook(@RequestParam(name="isbn", required = false) String isbn, Model model) {
        if (repository.findById(isbn).isPresent()) {
            model.addAttribute("book", repository.findById(isbn));
            return "editbook";
        }
        return "redirect:../booklist";
    }
}
