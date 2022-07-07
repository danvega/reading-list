package dev.danvega.readinglist;

import dev.danvega.readinglist.model.Book;
import dev.danvega.readinglist.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository repository) {
		return args -> {
			List<Book> books = List.of(
			    new Book(null,"Reactive Spring", 484, "Josh Long"),
			    new Book(null, "Spring Boot Up  Running", 328, "Mark Heckler"),
			    new Book(null, "Hacking with Spring Boot 2.3", 392, "Greg Turnquist")
			);
			repository.saveAll(books);
		};
	}
}
