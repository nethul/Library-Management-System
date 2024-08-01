package edu.ijse.library_management_system.tm;

import java.sql.Date;

public class OrderTM {
    private String orderId;
    private String memberId;
    private String bookId;
    private Date borrowedDate;
    private Date dueDate;
    
    public OrderTM() {
    }

    public OrderTM(String orderId, String memberId, String bookId, Date borrowedDate, Date dueDate) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "OrderTM [orderId=" + orderId + ", memberId=" + memberId + ", bookId=" + bookId + ", borrowedDate="
                + borrowedDate + ", dueDate=" + dueDate + "]";
    }

    
    
}
