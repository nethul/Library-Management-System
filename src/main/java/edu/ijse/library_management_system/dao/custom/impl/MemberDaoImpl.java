package edu.ijse.library_management_system.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.MemberDao;
import edu.ijse.library_management_system.entity.MemberEntity;

public class MemberDaoImpl implements MemberDao {

    @Override
    public boolean save(MemberEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO members VALUES (?,?,?,?,?)", t.getmemberId(), t.getmemberTitle(), t.getmemberName(), t.getContactNumber(), t.getMemberSince());
    }

    @Override
    public boolean update(MemberEntity t) {
        return false;
    }

    @Override
    public boolean delete(String... id) {
        return false;
    }

    @Override
    public MemberEntity get(String... args) throws Exception {
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM members");
        ArrayList<MemberEntity> memberEntities = new ArrayList<>();
        while(rst.next()){
            MemberEntity entity = new MemberEntity(rst.getString("member_id"), rst.getString("member_title"), rst.getString("member_name"), rst.getString("contact_number"), rst.getDate("member_since"));
            memberEntities.add(entity);
        }
        return memberEntities;
    }

}
