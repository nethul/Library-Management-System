package edu.ijse.library_management_system.controller;


import java.sql.Connection;
import java.sql.Date;

import edu.ijse.library_management_system.db.DBConnection;
import edu.ijse.library_management_system.dto.MemberDto;
import edu.ijse.library_management_system.dto.OrderDetailDto;
import edu.ijse.library_management_system.dto.OrderDto;
import edu.ijse.library_management_system.dto.OrderTMDto;
import edu.ijse.library_management_system.service.ServiceFactory;
import edu.ijse.library_management_system.service.custom.BookService;
import edu.ijse.library_management_system.service.custom.MemberService;
import edu.ijse.library_management_system.service.custom.OrderDetailService;
import edu.ijse.library_management_system.service.custom.OrderService;
import edu.ijse.library_management_system.service.custom.OrderTMService;
import edu.ijse.library_management_system.tm.OrderTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderController {

    OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    OrderDetailService orderDetailService = (OrderDetailService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER_DETAIL);
    MemberService memberService = (MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    String[] booksArr = new String[2];
    BookService bookService = (BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    OrderTMService orderTMService =(OrderTMService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDERTM);
    
    @FXML
    private TableColumn<OrderTM, String> colBookId;

    @FXML
    private TableColumn<OrderTM, Date> colBorrowedDate;

    @FXML
    private TableColumn<OrderTM, Date> colDueDate;

    @FXML
    private TableColumn<OrderTM, String> colMemberId;

    @FXML
    private TableColumn<OrderTM, String> colOrderId;

    @FXML
    private Label lblBooks1;

    @FXML
    private Label lblBooks2;

    @FXML
    private Label lblMember;

    @FXML
    private TableView<OrderTMDto> tblOrders;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtOrderId;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        try {
            if (booksArr[0] == null){
                 if (txtBookId.getText() != null) {
                    booksArr[0] = txtBookId.getText();
                    lblBooks1.setText(bookService.get(txtBookId.getText()).toString());
                };
                
            }else if (booksArr[1] == null) {
                 if (txtBookId.getText() != null) {
                    booksArr[1] = txtBookId.getText();
                    lblBooks2.setText(bookService.get(txtBookId.getText()).toString());
                 };
                
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Only two books can be borrowed at a time");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) {
        try {
            LocalDate localDate = LocalDate.now();
            
            if (booksArr[0] == null & booksArr[1] == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please select the books you want to borrow");
                alert.showAndWait();
            }else if (booksArr[1] == null){
                OrderDto orderDto = new OrderDto(txtOrderId.getText(), txtMemberId.getText(),Date.valueOf(localDate.plusDays(7)),Date.valueOf(localDate));
                orderService.saveOrder(orderDto);
                OrderDetailDto orderDetailDto = new OrderDetailDto(txtOrderId.getText(), booksArr[0]);
                orderDetailService.saveOrderDetail(orderDetailDto);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Order Placed Successfully");
                alert.setContentText("Borrowed Book should be returned before " + orderDto.getDueDate());
                alert.showAndWait();
                loadTable();
                clearForm();
                lblBooks1.setText(null);
                lblMember.setText(null);
                booksArr[0] = null;
            }else{
                OrderDto orderDto = new OrderDto(txtOrderId.getText(), txtMemberId.getText(),Date.valueOf(localDate.plusDays(7)),Date.valueOf(localDate));
                orderService.saveOrder(orderDto);
                OrderDetailDto orderDetailDto1 = new OrderDetailDto(txtOrderId.getText(), booksArr[0]);
                orderDetailService.saveOrderDetail(orderDetailDto1);
                OrderDetailDto orderDetailDto2 = new OrderDetailDto(txtOrderId.getText(), booksArr[1]);
                orderDetailService.saveOrderDetail(orderDetailDto2);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Order Placed Successfully");
                alert.setContentText("Borrowed Books should be returned before " + orderDto.getDueDate());
                alert.showAndWait();
                loadTable();

                lblMember.setText(null);
                booksArr[0] = null;
                lblBooks1.setText(null);;
                booksArr[1] = null;
                lblBooks2.setText(null);;
                
            }

           
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    // @FXML
    // void btnDeleteOnAction(ActionEvent event) {

    // }

    @FXML
    void btnReturOrderOnAction(ActionEvent event) {
        try {
            LocalDate today = LocalDate.now();
            OrderTMDto selectedItem = tblOrders.getSelectionModel().getSelectedItem();
           
            
            if (selectedItem.getDueDate().after(Date.valueOf(today))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thank You");
                alert.setHeaderText("No fine will be charged");
                alert.setContentText("Thank you for returning the books on time");
                alert.showAndWait();
                returnOrder(selectedItem);
                
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fine");
                alert.setHeaderText("Returning is made past due date");
                alert.setContentText("Total of " + today.compareTo(selectedItem.getDueDate().toLocalDate()) * 50 + " LKR will be charged" );
                alert.showAndWait();
                returnOrder(selectedItem);
                
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    // @FXML
    // void btnUpdateOnAction(ActionEvent event) {

    // }

    private void returnOrder(OrderTMDto orderTMDto) throws Exception {
            orderDetailService.deleteOrderDetail(orderTMDto.getOrderId());
            orderService.deleteOrder(orderTMDto.getOrderId());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Return Success");
                //alert.setContentText("Total of " + today.compareTo(selectedItem.getDueDate().toLocalDate()) * 50 + " LKR will be charged" );
                alert.showAndWait();
                loadTable();
                
        // Connection connection = DBConnection.getInstance().getConnection();
        // connection.setAutoCommit(true);
        // if(orderDetailService.deleteOrderDetail(orderTMDto.getOrderId()).equals("Success")){
        //     if(orderService.deleteOrder(orderTMDto.getOrderId()).equals("Success")){
        //         connection.commit();
        //         connection.close();
        //         loadTable();
        //         System.out.println("Over");
        //     }else {
        //         connection.rollback();
        //     }
        // }else{
        //     connection.rollback();
        // }
        
    }

    @FXML
    void btnSearchMemberOnAction(ActionEvent event) {
        try {
            MemberDto memberDto = memberService.get(txtMemberId.getText());
            lblMember.setText(memberDto.getMemberTitle() + "." + memberDto.getMemberName());
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Member Search Failed");
            alert.showAndWait();
        }
    }

    public void initialize(){
        try {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colBorrowedDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
    
        loadTable();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


    private void loadTable() throws Exception {
            ArrayList<OrderTMDto> orderTMs = orderTMService.getAll();
            ObservableList<OrderTMDto> observableArrayList = FXCollections.observableArrayList();
            observableArrayList.addAll(orderTMs);
            tblOrders.setItems(observableArrayList);
            // ArrayList<OrderDto> orderDtos = orderService.getAll();
            // ArrayList<OrderDetailDto> orderDetailDtos = orderDetailService.getAll();
            // ObservableList<OrderTM> observableArrayList = FXCollections.observableArrayList();
            // ArrayList<OrderTM> orderTMs = new ArrayList<>();
            // for (OrderDto orderDto : orderDtos) {
            //     OrderTM orderTM = new OrderTM(orderDto.getOrderId(), orderDto.getMemberId(), null, orderDto.getBorrowedDate(), orderDto.getDueDate());
            //     orderTMs.add(orderTM);
            // }
            // for (int i = 0; i < orderTMs.size(); i++) {
            //     orderTMs.get(i).setBookId(orderDetailDtos.get(i).getBookId());
            // }
            // observableArrayList.addAll(orderTMs);
            // tblOrders.setItems(observableArrayList);
           

          
          
        
        
    }


    private void clearForm(){
        txtOrderId.clear();
        txtMemberId.clear();
        txtBookId.clear();
    }

    @FXML
    void tblObjectSelectedOnAction(MouseEvent event) throws Exception {
      OrderTMDto selectedItem = tblOrders.getSelectionModel().getSelectedItem();
        txtOrderId.setText(selectedItem.getOrderId());
        txtMemberId.setText(selectedItem.getMemberId());
        lblMember.setText(memberService.get(selectedItem.getMemberId()).getMemberName());
    
    }
}
