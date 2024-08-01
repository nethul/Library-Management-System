package edu.ijse.library_management_system.dto;

public class OrderDetailDto {
    private String orderId;
    private String bookId;
    
    public OrderDetailDto() {
    }

    public OrderDetailDto(String orderId, String bookId) {
        this.orderId = orderId;
        this.bookId = bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "OrderDetailDto [orderId=" + orderId + ", bookId=" + bookId + "]";
    }

    
    
}
