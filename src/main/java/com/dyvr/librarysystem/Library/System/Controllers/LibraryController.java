package com.dyvr.librarysystem.Library.System.Controllers;

import com.dyvr.librarysystem.Library.System.model.Book;
import com.dyvr.librarysystem.Library.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/library/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/library/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id){
        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Book exist with Id: " + id);
        }
    }

    @PostMapping("/library/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/library/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        return bookService.deleteBookById(id);
    }

}
