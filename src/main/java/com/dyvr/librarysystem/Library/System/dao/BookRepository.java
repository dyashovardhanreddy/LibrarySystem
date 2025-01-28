package com.dyvr.librarysystem.Library.System.dao;

import com.dyvr.librarysystem.Library.System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
