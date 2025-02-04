package com.dyvr.librarysystem.Library.System.Controllers;

import com.dyvr.librarysystem.Library.System.model.Book;
import com.dyvr.librarysystem.Library.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/library/books")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/library/books/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getBook(@PathVariable int id){
        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Book exist with Id: " + id);
        }
    }

    @PostMapping("/library/addBook")
    @PreAuthorize("hasRole('ADMIN')")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/library/deleteBook/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable int id){

        boolean isDeleted = bookService.deleteBookById(id);

        if (isDeleted) {
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book found with ID: " + id);
        }
    }

}
