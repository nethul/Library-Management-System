package edu.ijse.library_management_system.service.custom;

import edu.ijse.library_management_system.dto.AdminDto;
import edu.ijse.library_management_system.service.SuperService;

public interface AdminService extends SuperService  {
    public String saveAdmin(AdminDto adminDto) throws Exception;
    public AdminDto get(String username, String password) throws Exception;
}
