package com.responsebody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.responsebody.domain.Book;
import com.responsebody.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping(value = "bookJSON", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Book> getBooksJSON() {
		return bookService.getAllBooks();
	}

	@GetMapping(value = "bookXML", produces = { MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Book> getBooksXML() {
		return bookService.getAllBooks();
	}
}