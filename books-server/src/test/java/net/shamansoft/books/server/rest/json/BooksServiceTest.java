package net.shamansoft.books.server.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import net.shamansoft.books.server.rest.dto.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
class BooksServiceTest {

    @Inject
    BooksService booksService;

    @Test
    public void testEmptyFind() {
        assertThat(booksService.find(""), hasSize(5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"lost", "calaghan", "scholastic", "lost in "})
    public void testLostQuery(String query) {
        List<Book> actual = booksService.find(query);
        assertThat(actual, hasSize(3));

    }
}