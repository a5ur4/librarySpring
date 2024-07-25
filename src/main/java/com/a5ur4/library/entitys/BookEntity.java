package com.a5ur4.library.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "book")
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String title;

    private String author;
    private String genre;
    private String description;
    private Boolean isUsing;
    private Integer bookOwnerId;

    public BookEntity(String title, String author, String genre, String description, Boolean isUsing, Integer bookOwnerId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.isUsing = isUsing;
        this.bookOwnerId = bookOwnerId;
    }
}