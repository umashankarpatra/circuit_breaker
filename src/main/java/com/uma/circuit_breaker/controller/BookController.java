package com.uma.circuit_breaker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uma.circuit_breaker.pojo.Book;
import com.uma.circuit_breaker.service.BookService;

@RestController
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getLatestBook() {
		logger.info("{} Get latest Book >>>> ");
		System.out.println(bookService.getLatestestBooks());
		return bookService.getLatestestBooks();

	}
}
