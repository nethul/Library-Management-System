package edu.ijse.library_management_system.entity;

import java.sql.Date;

public class OrderEntity {
    private String orderId;
    private String memberId;
    private Date dueDate;
    private Date borrowedDate;
    
    public OrderEntity() {
    }

    public OrderEntity(String orderId, String memberId, Date dueDate, Date borrowedDate) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.dueDate = dueDate;
        this.borrowedDate = borrowedDate;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Override
    public String toString() {
        return "OrderDto [orderId=" + orderId + ", memberId=" + memberId + ", dueDate=" + dueDate + "]";
    }

}
