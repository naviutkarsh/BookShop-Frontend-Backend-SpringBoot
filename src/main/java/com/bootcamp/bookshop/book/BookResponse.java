package com.bootcamp.bookshop.book;

import com.bootcamp.bookshop.money.Money;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String imageUrl;
    private String authorName;
    private Money price;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.authorName = book.getAuthorName();
        this.imageUrl = book.getImageUrl();
        this.price = book.getPrice();
    }
}

