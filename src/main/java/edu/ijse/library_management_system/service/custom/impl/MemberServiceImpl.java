package edu.ijse.library_management_system.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.MemberDao;
import edu.ijse.library_management_system.dto.MemberDto;
import edu.ijse.library_management_system.entity.MemberEntity;
import edu.ijse.library_management_system.service.custom.MemberService;

public class MemberServiceImpl implements MemberService {
    MemberDao memberDao =(MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);
    
    @Override
    public String saveMember(MemberDto memberDto) throws Exception {
       if (memberDao.save(getMemberEntity(memberDto)) == true) {
            return "Success";
       } else {
            return "Failed";
       }

    }

    @Override
    public String updateMember(MemberDto memberDto) throws Exception {
       return memberDao.update(getMemberEntity(memberDto)) == true ? "Success" : "Failed";
    }

    @Override
    public String deleteMember(String memberId) throws Exception {
        if (memberDao.delete(memberId) == true){
            return "Success";
        }else {
            return "Failed";
        }
    }

    @Override
    public MemberDto get(String memberId) throws Exception {
        return getMemberDto(memberDao.get(memberId));
        
    }

    @Override
    public ArrayList<MemberDto> getAllMembers() throws Exception {
        ArrayList<MemberEntity> memberEntities = memberDao.getAll();
        ArrayList<MemberDto> memberDtos = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntities) {
            MemberDto memberDto = getMemberDto(memberEntity);
            memberDtos.add(memberDto);
        }
        return memberDtos;
    }

    private MemberDto getMemberDto(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto(memberEntity.getmemberId(), memberEntity.getmemberTitle(), memberEntity.getmemberName(), memberEntity.getContactNumber(), memberEntity.getMemberSince());
        return memberDto;
    }

    private MemberEntity getMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity(memberDto.getMemberId(), memberDto.getMemberTitle(), memberDto.getMemberName(), memberDto.getContactNumber(), memberDto.getMemberSince());
        return memberEntity;
    }

}
