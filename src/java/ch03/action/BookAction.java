package ch03.action;


import ch03.controller.BookManager;
import ch03.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class BookAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<Book> bookList;
    private BookManager bookManager;
    private Book book;
    private int id;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() {
        bookList = bookManager.list();
        return "SUCCESS";
    }

    public String add() {
        bookManager.add(book);
        return "SUCCESS";
    }

    public String index() {
        bookList = bookManager.list();
        return "SUCCESS";
    }

    public String delete() {
        bookManager.delete(getId());
        bookList = bookManager.list();
        return "SUCCESS";
    }

    public String edit() {
        if (book != null) {
            book.setId(getId());
            bookManager.update(book);
        } else {
            book = bookManager.find(getId());
        }
        return "SUCCESS";
    }

    public String where() {
        bookList = bookManager.where();
        return "SUCCESS";
    }

    public String limit() {
        bookList = bookManager.limit();
        return "SUCCESS";
    }

    public String sumMaxMin() {
        book = bookManager.sumMaxMin();
        return "SUCCESS";
    }
}