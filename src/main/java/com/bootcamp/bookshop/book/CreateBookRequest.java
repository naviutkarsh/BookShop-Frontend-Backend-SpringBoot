package com.bootcamp.bookshop.book;

import com.bootcamp.bookshop.money.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class CreateBookRequest {
    private final String name;
    private final String imageUrl;
    private final String authorName;
    private final Money price;
}
