package net.shamansoft.books.server.rest.json;

import net.shamansoft.books.server.rest.dto.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BooksService {

    private final List<Book> books;

    public BooksService() {
        books = List.of(
                new Book("Karlson", "Astrid Lindgren", "Malysh", 1980),
                new Book("Незнайка и его друзья", "Н.Носов", "Учпедгиз", 1968),
                new Book("Lost in Rome", "Calaghan", "scholastic", 2018),
                new Book("Lost in Paris", "Calaghan", "scholastic", 2017),
                new Book("Lost in Holliwood", "Calaghan", "scholastic", 2019)
        );
    }

    public List<Book> find(String query) {
        return books.stream().filter(book -> book.matchesQuery(query)).collect(Collectors.toList());
    }
}
