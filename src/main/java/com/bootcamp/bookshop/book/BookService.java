package com.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> fetchAll() {
        return bookRepository.findAllByOrderByNameAsc();
    }
    public Book create(CreateBookRequest bookRequest) {
        Book newBook = Book.create(bookRequest);
        return bookRepository.save(newBook);
    }
    public Book updateBook(Book book) {

        for(Book c:bookRepository.findAll())
            if (c.getId() == book.getId()) {
                c.setAuthorName(book.getAuthorName());
                c.setImageUrl(book.getImageUrl());
                c.setName(book.getName());
                c.setPrice(book.getPrice());
                bookRepository.save(c);
                return c;
            }
        return book;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
