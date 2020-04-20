package net.shamansoft.books.server.rest.json;

import net.shamansoft.books.server.rest.dto.Book;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private BooksService booksService;

    @GET
    public BooksResponse hello() {
        return new BooksResponse(booksService.getAllBooks());
    }


}