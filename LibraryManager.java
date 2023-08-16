package com.spring.basics.funwithspring;

import java.util.HashMap;
import java.util.Map;

public class LibraryManager {
	
	int booksCount = 0;
	
	//Each book will be having a unique identifier (a number) 
	//Map with the books unique identifier and count of books 
	Map<Integer, Integer> booksStack = new HashMap<>();
	
	//Map to track the book name and the books unique identifier
	Map<String, Integer> booksIndex = new HashMap<>();
 
	//To add a book
	public void addBook(Book bookName) {
		if(booksIndex.containsKey(bookName)) {
			int bookNumber = booksIndex.get(bookName.Title);
			booksStack.put(bookNumber, booksStack.get(bookNumber) + 1);
		}
		else {
			booksIndex.put(bookName.Title, ++booksCount);
		}

	}
	
	//To view existing books
	public void viewBooks() {
		for (Map.Entry<String,Integer> element : booksIndex.entrySet()) {
			System.out.println(element.getKey());
		}
	}
	
	//To Update a Book
	
	//To Delete a Book
	public boolean deleteBook(Book bookName) {
		if(!booksIndex.containsKey(bookName.Title)) {
			return false;
		}
		else {
			int bookNumber = booksIndex.get(bookName.Title);
			int x = booksStack.get(bookNumber);
			if(x > 1) 
				booksStack.put(bookNumber, --x);
			else {
				booksStack.remove(bookNumber);
				booksIndex.remove(bookName.Title);
			}	
			return true;
		}
	}
		
}
