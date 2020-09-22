package com.uma.circuit_breaker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.uma.circuit_breaker.controller.BookController;
import com.uma.circuit_breaker.pojo.Book;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(BookController.class);

	private static String uri = "http://localhost:8083/newBooks";

	@HystrixCommand(fallbackMethod = "getDefaultData_Fallback")
	@Override
	public List<Book> getLatestestBooks() {
		System.out.println("--->>>>getLatestestBooks >>>>>");
		try{
		ResponseEntity<Book[]> result = restTemplate.getForEntity(uri, Book[].class);
		logger.debug("--->>>>>"+result);
		Book[] books = result.getBody();
		if (books != null) {
			for (Book book : books) {
				System.out.println("-->>" + book.toString());
			}
		}
		}
		catch(Exception ex) {
			logger.debug(ex.getMessage());
		}
		

		return null;
	}

	public List<Book> getDefaultData_Fallback() {

		logger.debug("{} Fallback method called >>>");
		return null;
	}

}
