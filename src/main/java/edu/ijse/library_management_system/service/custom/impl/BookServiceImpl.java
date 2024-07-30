package edu.ijse.library_management_system.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.BookDao;
import edu.ijse.library_management_system.dao.custom.CategoryDao;
import edu.ijse.library_management_system.dto.BookDto;
import edu.ijse.library_management_system.entity.BookEntity;
import edu.ijse.library_management_system.service.custom.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao =(BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    CategoryDao categoryDao = (CategoryDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORY);    @Override
    public String addBook(BookDto bookDto) throws Exception {
        return bookDao.save(getBookEntity(bookDto)) == true ? "Success" : "Failed";
    }

    @Override
    public String updateBook(BookDto bookDto) throws Exception {
        return bookDao.update(getBookEntity(bookDto)) == true ? "Success" : "Failed";
    }

    @Override
    public String deleteBook(String bookId) throws Exception {
       return bookDao.delete(bookId) == true ? "Success" : "Failed";
    }

    @Override
    public BookDto get(String bookId) {
        return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookDto> bookDtos = new ArrayList<>(); 
        ArrayList<BookEntity> bookEntities = bookDao.getAll();
        for (BookEntity bookEntity : bookEntities) {
            bookDtos.add(getBookDto(bookEntity));
        }
        return bookDtos;
        
    }

    private BookDto getBookDto(BookEntity bookEntity) throws Exception{
        BookDto bookDto = new BookDto(bookEntity.getBookId(), bookEntity.getCategory(),bookEntity.getBookName(), bookEntity.getAuthor());
        return bookDto;
    }

    private BookEntity getBookEntity(BookDto bookDto){
        BookEntity bookEntity = new BookEntity(bookDto.getBookId(), bookDto.getCategory(), bookDto.getBookName(), bookDto.getAuthor());
        return bookEntity;
    }

}
