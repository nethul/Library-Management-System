package edu.ijse.library_management_system.service.custom;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.MemberDto;
import edu.ijse.library_management_system.service.SuperService;

public interface MemberService extends SuperService  {
    String saveMember(MemberDto memberDto) throws Exception;
    String updateMember(MemberDto memberDto) throws Exception;
    String deleteMember(String memberId) throws Exception;
    MemberDto get(String memberId) throws Exception;
    ArrayList<MemberDto> getAllMembers() throws Exception;
}
