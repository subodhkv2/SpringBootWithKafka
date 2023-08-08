package com.infusion.kafka.service;
import com.infusion.kafka.model.Book;
import com.infusion.kafka.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
