package net.shamansoft.books.server.rest.json;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private BooksService booksService;

    @GET
    public BooksResponse search(@DefaultValue(value = "")@QueryParam String query) {
        return new BooksResponse(booksService.find(query));
    }

}