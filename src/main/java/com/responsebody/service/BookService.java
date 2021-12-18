package com.responsebody.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.responsebody.domain.Book;

@Service
public class BookService {
	public List<Book> getAllBooks() {
		// Perform database operation
		Book book1 = new Book(101, "Java Tutorials", "Jose");
		Book book2 = new Book(102, "Spring Tutorials", "Maria");
		Book book3 = new Book(103, "React Tutorials", "John");
		return Arrays.asList(book1, book2, book3);
	}	
}