package com.uma.circuit_breaker.service;

import java.util.List;

import com.uma.circuit_breaker.pojo.Book;

public interface BookService {
	public List<Book> getLatestestBooks();
}
