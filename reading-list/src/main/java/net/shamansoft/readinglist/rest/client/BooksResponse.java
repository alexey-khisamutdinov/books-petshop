package net.shamansoft.readinglist.rest.client;

import net.shamansoft.readinglist.rest.dto.Book;

import java.util.List;

public class BooksResponse {

    public BooksResponse(){}

    private List<Book> books;
    private long total;
    private int page;
    private int count;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
