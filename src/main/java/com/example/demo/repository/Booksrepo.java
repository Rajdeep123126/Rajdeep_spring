package com.example.demo.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;


@Repository
public class Booksrepo {
	List<Book> books = new ArrayList<>();
	
	public Booksrepo() {
		books.add(new Book(1,"Swaraj","Pune",true));
		books.add(new Book(2,"Ram","Pune",true));
		books.add(new Book(3,"Mandar","Pune",true));		
	}
	public List<Book> findAll(){
		return books;
	}
	public Book findById(long id)
	{
		Optional<Book> b=books.stream().filter((b1)->b1.getId()==id).findAny();
			return b.orElseThrow(()->new RuntimeException("Book Not Found"));
	}
	
	public Book addBook(Book book)
	{
		books.add(book);
		return book;
	}
	public Book updateBook (long id, Book book)
	{
		Book book1 = findById(id);
		book1.setAuthor(book.getAuthor());
		book1.setTitle(book.getTitle());
		book1.setPublished(book.getPublished());
		return book;
	}
	public void deletebook (long id)
	{
		Book book1 = findById(id);
		books.remove(book1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
