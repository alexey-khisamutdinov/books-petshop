package net.shamansoft.books.server.rest.dto;

import java.util.Optional;

public class Book {

    public Book(){};

    private String name;
    private String author;
    private String publisher;
    Integer year;

    public Book(String name, String author, String publisher, Integer year) {
        this.name = Optional.ofNullable(name).orElse("");
        this.author = Optional.ofNullable(author).orElse("");
        this.publisher = Optional.ofNullable(publisher).orElse("");
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean matchesQuery(String query) {
        String lcQuery = query.toLowerCase();
        return name.toLowerCase().contains(lcQuery) || author.toLowerCase().contains(lcQuery) || publisher.toLowerCase().contains(lcQuery);
    }
}
