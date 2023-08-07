package com.infusion.kafka.service;
import com.infusion.kafka.model.Book;
import com.infusion.kafka.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookConsumer {
    @Autowired
    private BookRepository bookRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookConsumer.class);
    @KafkaListener(topics = "order-A", groupId = "order-group")
    public void consume(Book book) {
        bookRepository.save(book);
    }

    @KafkaListener(topics = "order-A", groupId = "order-group")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }


}
