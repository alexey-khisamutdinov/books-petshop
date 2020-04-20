package net.shamansoft.readinglist.rest.client;

import net.shamansoft.readinglist.rest.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BooksClient {

    private static final String URL = "http://localhost:8080/books";
    private final RestTemplate restTemplate;

//    @Autowired
    public BooksClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Book> findAll(){
        BooksResponse booksResponse = restTemplate.getForObject(URL, BooksResponse.class);
        return Optional.ofNullable(booksResponse).orElse(new BooksResponse()).getBooks();
    }
}
