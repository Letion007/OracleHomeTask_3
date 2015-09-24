package com.letion.dao;

import com.letion.entity.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImp implements BookDao{
    List <Book> listBooks = new LinkedList<Book>();

    public BookDaoImp() {

        listBooks.add(new Book("Sherlock", "Mike Collins", "9-1111-2222"));
        listBooks.add(new Book("War and Peace", "L.Tolstoy", "9-1112-3333"));
        listBooks.add(new Book("Philo of Java", "B.Eckel", "9-3434-5555"));
        listBooks.add(new Book("Alphabet", "RADUGA", "7-1113-4444"));
        listBooks.add(new Book("Clear code", "Martin", "9--2323-1212"));
        listBooks.add(new Book("Philo C++", "B.Eckel", "9-8989-5555"));
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new LinkedList<>();
        Iterator<Book> iterator = listBooks.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (author.equals(book.getAuthor())) {
               result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> getAllBooks() {
        return listBooks;
    }

    @Override
    public List<Book> getBook(String isbn) {
        List<Book> result = new LinkedList<>();
        Iterator<Book> iterator = listBooks.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (isbn.equals(book.getIsbn())) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public boolean addBook(String name, String author, String isbn) {
        Book newBook = new Book(name, author, isbn);
        return listBooks.add(newBook);
    }

    @Override
    public boolean deleteBookByIsbn(String isbn) {
        if(isbn != "" & isbn != null) {
            Iterator<Book> iterator = listBooks.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (isbn.equals(book.getIsbn())) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

}
