package com.letion.controller;

import com.letion.dao.BookDaoImp;
import com.letion.entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "LibraryController", urlPatterns = "/library")
public class LibraryController extends HttpServlet {

    BookDaoImp library = new BookDaoImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeSelect = request.getParameter("typeSelect");
        response.setContentType("text/html");
        if (typeSelect!=null && typeSelect != "") {
            doSelect(typeSelect, request, response);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
//            response.getWriter().write("defaultAnswer");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeSelect = request.getParameter("typeSelect");
        response.setContentType("text/html");
        if (typeSelect!=null && typeSelect != "") {
            doSelect(typeSelect, request, response);
        } else {
            response.getWriter().write("defaultAnswer");
        }
    }

    protected void doSelect (String typeSelect, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (typeSelect.equals("allbooks")) {
            response.getWriter().write(generateJSONDataFromListBooks(library.getAllBooks()));
        }
        if (typeSelect.equals("byAuthor")) {
            String author = request.getParameter("author");
            response.getWriter().write(generateJSONDataFromListBooks(library.getBooksByAuthor(author)));
        }
        if (typeSelect.equals("byIsbn")) {
            String isbn = request.getParameter("isbn");
            response.getWriter().write(generateJSONDataFromListBooks(library.getBook(isbn)));
        }
        if (typeSelect.equals("addNewBook")) {
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            if (name != "" && author != "" && isbn != "") {
                response.getWriter().write(generateJSONOperation(library.addBook(name, author, isbn)));
            }
        }
        if (typeSelect.equals("deleteBook")) {
            String isbn = request.getParameter("isbn");
            if (isbn != "") {
                response.getWriter().write(generateJSONOperation(library.deleteBookByIsbn(isbn)));
            }
        }
    }

    public String generateJSONDataFromListBooks (List<Book> listBooks) {
        String result = "";
        result += "{\"books\":{";
        result += "\"name\":\"AllBooks\",";
        result += "\"listBooks\":[";
        Iterator<Book> iterator = listBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
                result += book.toString() +", ";
        }
        result += "]}}";
        return result;
    }
    public String generateJSONOperation (boolean resultOperation) {
        String result = "";
        result += "{\"books\":{";
        result += "\"name\":\"resultOperation = " + resultOperation + "\"";
        result += "}}";
        return result;
    }
}
