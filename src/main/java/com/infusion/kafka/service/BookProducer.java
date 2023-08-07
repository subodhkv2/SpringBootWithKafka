package com.infusion.kafka.service;
import com.infusion.kafka.constant.AppConstant;
import com.infusion.kafka.model.Book;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class BookProducer {

    private final KafkaTemplate<String, Book> kafkaTemplate;
    public void sendBook(Book book) {
        kafkaTemplate.send(AppConstant.TOPIC_1, book);
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(BookProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate1;

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate1.send(AppConstant.TOPIC_2, message);
    }

}
