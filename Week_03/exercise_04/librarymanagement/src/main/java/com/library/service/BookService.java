package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        System.out.println("Constructor Injection: BookRepository injected");
        this.bookRepository = bookRepository;
    }

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter Injection: BookRepository injected");
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("Inside BookService: Adding book...");
        bookRepository.saveBook(bookName);
    }
}
