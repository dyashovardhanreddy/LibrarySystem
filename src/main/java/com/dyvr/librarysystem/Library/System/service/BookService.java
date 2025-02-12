package com.dyvr.librarysystem.Library.System.service;

import com.dyvr.librarysystem.Library.System.dao.BookRepository;
import com.dyvr.librarysystem.Library.System.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBookById(int id){
        return bookRepository.findById(id);

    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
       return bookRepository.save(book);
    }

    public Boolean deleteBookById(int id){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
