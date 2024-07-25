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

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String password;

    @Column(unique = true)
    private String email;

    private String bookName;
    private Integer daysWithBook;

    public UserEntity(String name, String password, String email, String bookName, Integer daysWithBook) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.bookName = bookName;
        this.daysWithBook = daysWithBook;
    }
}
