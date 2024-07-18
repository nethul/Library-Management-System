package edu.ijse.library_management_system.service.custom.impl;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.AdminDao;
import edu.ijse.library_management_system.dto.AdminDto;
import edu.ijse.library_management_system.service.custom.AdminService;
import edu.ijse.library_management_system.entity.AdminEntity;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = (AdminDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ADMIN);

    @Override
    public String saveAdmin(AdminDto adminDto) throws Exception {
        AdminEntity adminEntity = getAdminEntity(adminDto);
        return adminDao.save(adminEntity) ? "Success" : "Fail";
    }
    
    @Override
    public AdminDto get(String username, String password) throws Exception{
        return getAdminDto(adminDao.get(username, password));
    }
    
    private AdminEntity getAdminEntity(AdminDto adminDto){
        AdminEntity adminEntity = new AdminEntity(adminDto.getUsername(), adminDto.getName(), adminDto.getPassword());
        return adminEntity;
    }

    private AdminDto getAdminDto(AdminEntity adminEntity){
        AdminDto adminDto= new AdminDto(adminEntity.getUserName(), adminEntity.getName(), adminEntity.getPassword());
        return adminDto;
    }


   
}
