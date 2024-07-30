package edu.ijse.library_management_system.entity;

public class BookEntity {
    private String bookId;
    private String category;
    private String bookName;
    private String author;
    
    public BookEntity() {
    }

    public BookEntity(String bookId, String category, String bookName, String author) {
        this.bookId = bookId;
        this.category = category;
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookEntity [bookId=" + bookId + ", category=" + category + ", bookName=" + bookName + ", author="
                + author + "]";
    }

    

    
}
