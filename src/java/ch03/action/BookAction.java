package ch03.action;

import ch03.controller.BookManager;
import ch03.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

    private List<Book> bookList;
    private BookManager bookManager;

    public BookAction() {
        bookManager = new BookManager();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(final List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public void setBookManager(final BookManager bookManager) {
        this.bookManager = bookManager;
    }

	@Override
    public String execute() {
        bookList = bookManager.list();
        return "SUCCESS";
    }
}