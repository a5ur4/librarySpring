package com.a5ur4.library.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import com.a5ur4.library.entitys.BookEntity;
import com.a5ur4.library.dtos.BookDTO;
import com.a5ur4.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody BookDTO book) {
        this.bookService.createBook(book.title(), book.author(), book.genre(), book.description());
        return ResponseEntity.ok("Book created");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody BookDTO book) {
        this.bookService.deleteBook(book.id(), book.title());
        return ResponseEntity.ok("Book " + book.title() + " deleted");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody BookDTO book) {
        this.bookService.updateBook(book.id(), book.title(), book.author(), book.genre(), book.description());
        return ResponseEntity.ok("Book " + book.title() + " updated");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<BookEntity>> listAllBooks() {
        return ResponseEntity.ok(this.bookService.findAllBooks());
    }
}