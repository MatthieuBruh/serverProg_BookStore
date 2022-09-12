package fi.haagahelia.bookstore;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return args -> {
            Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "0-7475-3269-9", 8.99); // 1997
            Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, "0-7475-3849-2", 8.99);  // 1998
            Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, "0-7475-4215-5", 8.99); // 1999
            repository.save(book1);
            repository.save(book2);
            repository.save(book3);
        };
    }

}
