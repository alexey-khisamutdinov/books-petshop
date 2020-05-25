package net.shamansoft.readinglist;

import net.shamansoft.readinglist.rest.client.BooksClient;
import net.shamansoft.readinglist.rest.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.util.List;

@SpringBootApplication
public class ReadingListApplication implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(ReadingListApplication.class);
	private final HelloService helloService;
	private final BooksClient booksClient;

	public ReadingListApplication(HelloService helloService,
								  BooksClient booksClient){
		this.helloService = helloService;
		this.booksClient = booksClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(helloService.sayHello(args.getOptionValues("name")));
		List<String> query = args.getOptionValues("query");
		if(query != null){
			List<Book> bookList = booksClient.find(query);
			if (bookList.isEmpty()) {
				System.out.println(String.format("No books with the search query '%s' are found", query));
			} else {
				System.out.println("Look what I've found:");
				bookList.forEach(book -> System.out.println((book.toString())));
			}
		}
		Console console = System.console();
		if (console == null) {
			System.out.println("No console: non-interactive mode!");
			return;
		}
		System.out.println("How do you feel?");
		String iFeel = console.readLine();
		System.out.println(iFeel.contains("good") ? "I'm glad to hear this!" : "Sorry to hear this.");
	}
}
