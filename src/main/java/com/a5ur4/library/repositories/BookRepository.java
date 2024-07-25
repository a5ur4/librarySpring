package com.a5ur4.library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a5ur4.library.entitys.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    Optional<BookEntity> findBookByTitle(String title);
    
    Optional<BookEntity> findBookById(Integer id);
}
