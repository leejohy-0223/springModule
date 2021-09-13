package com.community.community.havi;

import com.community.community.havi.domain.Book;
import com.community.community.havi.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookJpaTest {

    private final static String BOOT_TEST_TITLE = "Spring Boot Test Book";

    @Autowired
    private TestEntityManager tem;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void Book_저장_테스트() {
        Book book = Book.builder()
                .title(BOOT_TEST_TITLE)
                .publishedAt(LocalDateTime.now())
                .build();
        tem.persist(book);
        Assertions.assertThat(bookRepository.getById(book.getIdx())).isEqualTo(book);
    }

    @Test
    public void BookList_저장하고_검색_테스트() {
        Book book1 = Book.builder()
                .title(BOOT_TEST_TITLE+"1")
                .publishedAt(LocalDateTime.now())
                .build();
        tem.persist(book1);

        Book book2 = Book.builder()
                .title(BOOT_TEST_TITLE+"2")
                .publishedAt(LocalDateTime.now())
                .build();
        tem.persist(book2);

        Book book3 = Book.builder()
                .title(BOOT_TEST_TITLE+"3")
                .publishedAt(LocalDateTime.now())
                .build();
        tem.persist(book3);

        List<Book> bookList = bookRepository.findAll();
        Assertions.assertThat(bookList.size()).isEqualTo(3);
        Assertions.assertThat(bookList.contains(book1)).isEqualTo(true);
    }

    @Test
    public void BookList_저장하고_삭제_테스트() {
        Book book1 = Book.builder()
                .title(BOOT_TEST_TITLE+"1")
                .publishedAt(LocalDateTime.now())
                .build();
        tem.persist(book1);

        Book book2 = Book.builder()
                .title(BOOT_TEST_TITLE+"2")
                .publishedAt(LocalDateTime.now())
                .build();
        tem.persist(book2);

        bookRepository.deleteAll();
        Assertions.assertThat(bookRepository.count()).isEqualTo(0);
    }

}