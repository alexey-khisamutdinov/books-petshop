package net.shamansoft.books.server.rest.json;

import net.shamansoft.books.server.rest.dto.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BooksService {

    public List<Book> getAllBooks(){
        return List.of(
                new Book("Karlson", "Astrid Lindgren", "Malysh", 1980),
                new Book("Незнайка и его друзья", "Н.Носов", "Учпедгиз", 1968)
                );
    }
}
