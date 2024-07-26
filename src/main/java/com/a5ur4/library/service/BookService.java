package com.a5ur4.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5ur4.library.entitys.BookEntity;
import com.a5ur4.library.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    
    public void createBook(String title, String author, String genre, String description) {
        BookEntity newBook = new BookEntity(title, author, genre, description, false, null);
        this.repository.save(newBook);
    }

    public void deleteBook(Integer id, String title) {
        if (!this.repository.existsById(id) || !this.repository.findBookByTitle(title).isPresent()) {
            throw new RuntimeException("Book not found");
        }
        this.repository.deleteById(id);
    }

    public void updateBook(Integer id, String title, String author, String genre, String description) {
        BookEntity book = this.repository.findBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        this.repository.save(book);
    }

    public void findBookByName(String title) {
        this.repository.findBookByTitle(title).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<BookEntity> findAllBooks() {
        return this.repository.findAll();
    }
}
