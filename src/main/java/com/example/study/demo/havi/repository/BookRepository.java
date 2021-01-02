package com.example.study.demo.havi.repository;

import com.example.study.demo.havi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
