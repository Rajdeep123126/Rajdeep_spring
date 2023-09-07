package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.repository.BookDBRepo;
import com.example.demo.repository.Booksrepo;

@Service
public class Booksservice {
	@Autowired
	BookDBRepo studentRepo;
	
	public List<Book> findAll(Pageable pageable){
		return studentRepo.findAll(pageable).toList();
	}
	public Book findById(long id)
	{
		Optional<Book> b = studentRepo.findById(id);
		return b.orElseThrow(()->new BookNotFoundException("Book Not Found id: "  ));
	}
	public Book addBook(Book b)
	{
		return studentRepo.save(b);
	}
	public Book updateBook(long id, Book b)
	{
		Book b1 = findById(id);
		b1.setAuthor(b.getAuthor());
		b1.setTitle(b.getTitle());
		b1.setPublished(b.getPublished());
		studentRepo.save(b1);
		return b1;
	}
	public void deleteBook(long id)
	{
		Book b = findById(id);
		studentRepo.delete(b);
	}
	
}
