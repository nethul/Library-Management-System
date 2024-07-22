package edu.ijse.library_management_system.controller;

import java.sql.Date;
import java.util.ArrayList;

import edu.ijse.library_management_system.dto.MemberDto;
import edu.ijse.library_management_system.service.ServiceFactory;
import edu.ijse.library_management_system.service.custom.MemberService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MemberController {
    MemberService memberService =(MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    @FXML
    public void initialize(){
        System.out.println("Initializing");
        colId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("memberTitle"));
        colName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colMemberSince.setCellValueFactory(new PropertyValueFactory<>("memberSince"));

        try {
            loadTable();
            //System.out.println("loading table");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private void loadTable() throws Exception {
        System.out.println("loading table");
       
        ObservableList<MemberDto> observableArrayList = FXCollections.observableArrayList();
        ArrayList<MemberDto> memberDtos = memberService.getAllMembers();
        //System.out.println(memberDtos);
        for (MemberDto memberDto : memberDtos) {
            observableArrayList.add(memberDto);
        }
        //System.out.println(observableArrayList);
        tblMember.setItems(observableArrayList);
        
    }
    
    @FXML
    private TableColumn<MemberDto, String> colContact;

    @FXML
    private TableColumn<MemberDto, String> colId;

    @FXML
    private TableColumn<MemberDto, Date> colMemberSince;

    @FXML
    private TableColumn<MemberDto, String> colName;

    @FXML
    private TableColumn<MemberDto, String> colTitle;


    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MemberDto> tblMember;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMemberSince;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumber;

    @FXML
    private TextField txtTitle;

    

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        try {
            MemberDto memberDto = new MemberDto(txtId.getText(), txtTitle.getText(), txtName.getText(), txtNumber.getText(), Date.valueOf(txtMemberSince.getText()));
            memberService.saveMember(memberDto);
            clearForm();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved");
            alert.setHeaderText("Member saved Successfully");
            alert.showAndWait();
            loadTable();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Member save failed");
            alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
        }
        
        
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    private void clearForm(){
        txtId.clear();
        txtTitle.clear();
        txtName.clear();
        txtNumber.clear();
        txtMemberSince.clear();
    }


}
