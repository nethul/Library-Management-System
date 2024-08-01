package edu.ijse.library_management_system.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.BookDao;
import edu.ijse.library_management_system.entity.BookEntity;

public class BookDaoImpl implements BookDao {

    @Override
    public boolean save(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?)", t.getBookId(), t.getCategory(), t.getBookName(), t.getAuthor());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE books SET category_id = ? , book_name = ? , author = ? WHERE book_id = ?", t.getCategory(), t.getBookName(), t.getAuthor(), t.getBookId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM books WHERE book_id = ?", id);
    }

    @Override
    public BookEntity get(String... args) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE book_id = ?", args[0]);
        while (rst.next()){
            BookEntity bookEntity = new BookEntity(rst.getString("book_id"), rst.getString("category_id"), rst.getString("book_name"), rst.getString("author"));
            return bookEntity;
        }
        return null;
        
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books");
        ArrayList<BookEntity> bookEntities = new ArrayList<>();
        while(rst.next()){
            BookEntity bookEntity = new BookEntity(rst.getString("book_id"), rst.getString("category_id"), rst.getString("book_name"), rst.getString("author"));
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }

}
