package net.shamansoft.books.server.rest.json;

import net.shamansoft.books.server.rest.dto.Book;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    Logger log = LoggerFactory.getLogger(BookResource.class);

    @Inject
    private BooksService booksService;

    @GET
    public BooksResponse search(@DefaultValue(value = "")@QueryParam String query) {
        log.info(String.format("Received a query '%s'", query) );
        List<Book> books = booksService.find(query);
        log.info(String.format("Books found: %d", books.size()));
        return new BooksResponse(books);
    }

}