package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private List<Book> favoriteBooks;

    public String fullName() {
        return name + " " + surname;
    }

    public int booksCount() {
        return favoriteBooks == null ? 0 : favoriteBooks.size();
    }
}