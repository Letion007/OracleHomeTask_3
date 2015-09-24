package com.letion.entity;

public class Book {
    private String name;
    private String author;
    private String isbn;

    public Book() {

    }

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString () {
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "{");
        stringBuilder.append( "\"name\": \"" + getName() + "\", ");
        stringBuilder.append( "\"author\": \"" + getAuthor() + "\", ");
        stringBuilder.append("\"isbn\": \"" + getIsbn() + "\"");
        stringBuilder.append( "}");
        result = stringBuilder.toString();
        return result;
    }

}
