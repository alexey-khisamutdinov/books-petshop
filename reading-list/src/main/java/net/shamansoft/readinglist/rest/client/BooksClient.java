package net.shamansoft.readinglist.rest.client;

import net.shamansoft.readinglist.rest.dto.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class BooksClient {

    @Value("${books.srv.baseUrl}")
    private String baseUrl;

    private static final String PATH = "/books";

    private final RestTemplate restTemplate;

//    @Autowired
    public BooksClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Book> findAll(){
        BooksResponse booksResponse = restTemplate.getForObject(baseUrl + PATH, BooksResponse.class);
        return Optional.ofNullable(booksResponse).orElse(new BooksResponse()).getBooks();
    }

    public List<Book> find(List<String> query) throws UnsupportedEncodingException {
        String queryLine = URLEncoder.encode(String.join(" ", query), StandardCharsets.UTF_8.toString());
        BooksResponse booksResponse = restTemplate.getForObject(baseUrl + PATH + "?query=" + queryLine, BooksResponse.class);
        return Optional.ofNullable(booksResponse).orElse(new BooksResponse()).getBooks();
    }
}
