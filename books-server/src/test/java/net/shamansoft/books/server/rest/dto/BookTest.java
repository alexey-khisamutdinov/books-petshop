package net.shamansoft.books.server.rest.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {

    private Book theBook;

    @BeforeEach
    void setUp() {
        theBook = new Book("TheName", "AwesomeAuthor", "puBlisher", 1999);
    }

    @ParameterizedTest
    @ValueSource(strings = { "name", "thename", "THENAME", "TheName", "AwesomeAuthor", "author", "publisher"})
    void matchesQuery(String query) {
        assertTrue(theBook.matchesQuery(query));
    }

    @ParameterizedTest
    @ValueSource(strings = {"KDKDIDKD", "  ", " TheName", "the name", "authorAwesome", "thepublisher"})
    void notMatchesQuery(String query) {
        assertFalse(theBook.matchesQuery(query));
    }
}