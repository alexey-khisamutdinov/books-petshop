package net.shamansoft.books.server.rest.json;

import net.shamansoft.books.server.rest.dto.Book;

import java.util.List;

public class BooksResponse {

    public BooksResponse(){}

    public BooksResponse(List<Book> books) {
        this(books, "");
    }

    public BooksResponse(List<Book> books, String query) {
        this.query = query;
        total = books.size();
        count = books.size();
        page = 0;
        this.books = books;
    }

    private String query;
    private List<Book> books;
    private long total;
    private int page;
    private int count;

    public List<Book> getBooks() {
        return books;
    }

    public long getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getCount() {
        return count;
    }

    public String getQuery() {
        return query;
    }
}
