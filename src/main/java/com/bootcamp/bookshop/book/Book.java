package com.bootcamp.bookshop.book;

import com.bootcamp.bookshop.money.Money;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String authorName;
    private String imageUrl;
    @Embedded
    private Money price;

    public Book(String name, String authorName,String imageUrl, Money price) {
        this.name = name;
        this.authorName = authorName;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public BookResponse toResponse() {
        return BookResponse.builder()
                .id(id)
                .name(name)
                .authorName(authorName)
                .imageUrl(imageUrl)
                .price(price)
                .build();
    }
    public static Book create(CreateBookRequest bookRequest){
        return new Book( bookRequest.getName(), bookRequest.getAuthorName(),bookRequest.getImageUrl(), bookRequest.getPrice());
    }
}
