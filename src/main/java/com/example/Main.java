package com.example;

import com.example.model.Book;
import com.example.model.Visitor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception
    {
        // 1. Читаем файл books.json с помощью Gson
        Gson gson = new Gson();
        FileReader reader = new FileReader("books.json");
        List<Visitor> visitors = gson.fromJson(reader, new TypeToken<List<Visitor>>(){}.getType());


        System.out.println("\n Задание 1");
        for (Visitor v : visitors)
        {
            System.out.println(v.getName() + " " + v.getSurname());
        }
        System.out.println("Всего посетителей: " + visitors.size());


        System.out.println("\n Задание 2");
        List<Book> uniqueBooks = new ArrayList<>();
        for (Visitor v : visitors)
        {
            for (Book b : v.getFavoriteBooks())
            {
                if (!uniqueBooks.contains(b))
                {
                    uniqueBooks.add(b);
                }
            }
        }
        for (Book b : uniqueBooks)
        {
            System.out.println(b.getName() + " — " + b.getAuthor());
        }
        System.out.println("Уникальных книг: " + uniqueBooks.size());


        System.out.println("\n Задание 5");
        int maxBooks = 0;
        for (Visitor v : visitors)
        {
            int currentCount = v.getFavoriteBooks().size();
            if (currentCount > maxBooks)
            {
                maxBooks = currentCount;
            }
        }
        System.out.println("Максимальное число книг в избранном: " + maxBooks);
    }
}