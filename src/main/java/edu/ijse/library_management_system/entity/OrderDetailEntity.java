package edu.ijse.library_management_system.entity;

public class OrderDetailEntity {
    private String orderId;
    private String bookId;
    
    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String orderId, String bookId) {
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
