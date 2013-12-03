package ch03.action;

import ch03.controller.BookManager;
import ch03.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class BookAction extends ActionSupport {

    private List bookList;
    private BookManager bookManager;
    //private Book book;

    public BookAction() {
        bookManager = new BookManager();
    }

    public List getBookList() {
        return bookList;
    }

    public void setBookList(List bookList) {
        this.bookList = bookList;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    /*  public Book getBook() {
     return book;
     }

     public void setBook(Book book) {
     this.book = book;
     }

     public String add() {
     bookManager.add(book);
     return "SUCCESS";
     }*/
    public String execute() {
        bookList = bookManager.list();
        return "SUCCESS";
    }
}