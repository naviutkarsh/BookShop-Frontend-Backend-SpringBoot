package com.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @CrossOrigin
    @GetMapping("/books")
    List<BookResponse> list() {
        List<Book> books = bookService.fetchAll();
        return books.stream()
                .map(book -> book.toResponse())
                .collect(Collectors.toList());
    }
    @CrossOrigin
    @PostMapping("/books")
    ResponseEntity<BookResponse> create(@RequestBody CreateBookRequest bookRequest) {
        Book book = bookService.create(bookRequest);
        return new ResponseEntity<>(book.toResponse(), HttpStatus.CREATED);
    }
    @CrossOrigin
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.updateBook(book);
    }
    @CrossOrigin
    @DeleteMapping(value="/books",params = "id")
    public void deleteBook(@RequestParam Long id)
    {
        this.bookService.deleteBook(id);
    }

}
