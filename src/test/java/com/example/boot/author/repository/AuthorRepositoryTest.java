package com.example.boot.author.repository;

import com.example.boot.author.entity.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        var author = new Author();
        author.setName("Spring");
        authorRepository.save(author);
    }

    @Test
    public void has_one_author() {
        assertEquals(1, authorRepository.findAll().size());
    }

    @AfterEach
    void tearDown() {
        authorRepository.deleteAll();
    }

}