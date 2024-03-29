package com.example.boot.book.entity;

import com.example.boot.author.entity.Author;
import com.example.boot.common.converter.TrimAttributeConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(generator = "book_id_generator")
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Convert(converter = TrimAttributeConverter.class)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
