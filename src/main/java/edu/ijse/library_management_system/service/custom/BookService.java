package edu.ijse.library_management_system.service.custom;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.BookDto;
import edu.ijse.library_management_system.service.SuperService;

public interface BookService extends SuperService {
    String addBook(BookDto bookDto) throws Exception;
    String updateBook(BookDto bookDto) throws Exception;
    String deleteBook(String bookId) throws Exception;
    BookDto get(String bookId);
    ArrayList<BookDto> getAll() throws Exception;
}
