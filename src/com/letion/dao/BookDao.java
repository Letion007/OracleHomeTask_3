package com.letion.dao;

import com.letion.entity.Book;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public interface BookDao {

    public List<Book> getBooksByAuthor(String author);
    public List<Book> getAllBooks() throws IOException;
    public List<Book> getBook (String isbn);
    public boolean addBook (String name, String author, String isbn);
    public boolean deleteBookByIsbn (String isbn);
}
