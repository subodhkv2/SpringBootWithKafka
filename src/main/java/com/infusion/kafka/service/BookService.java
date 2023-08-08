package com.infusion.kafka.service;

import com.infusion.kafka.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book saveBook(Book book);

}
