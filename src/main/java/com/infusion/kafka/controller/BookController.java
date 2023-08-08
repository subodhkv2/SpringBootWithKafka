package com.infusion.kafka.controller;
import com.infusion.kafka.model.Book;
import com.infusion.kafka.service.BookProducer;
import com.infusion.kafka.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController{
    private final BookService bookService;
    private final BookProducer bookProducer;

   @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        bookProducer.sendBook(book);
        return ResponseEntity.ok("Book created and sent to Kafka");
    }
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        bookProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }


}

