package edu.ijse.library_management_system.entity;


public class AdminEntity{
    private String userName;
    private String name;
    private String password;

    public AdminEntity(){};

    public AdminEntity(String userName, String name, String password){
        this.userName = userName;
        this.name = name;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}