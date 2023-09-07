package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Book_details")
public class Book {
	@Id    //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY )    //will auto increment the value
	long id;
	@Column(nullable = false,unique = true)
	@NotEmpty(message = "Title cannot be empty")
	@Size(min = 3,message = "Title must be more than 3 chars")
	String title;
	String author;
	Boolean Published;
}
