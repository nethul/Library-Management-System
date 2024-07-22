package edu.ijse.library_management_system.dto;

import java.util.Date;

public class MemberDto {
    private String memberId;
    private String memberTitle;
    private String memberName;
    private String contactNumber;
    private Date memberSince;
    
    public MemberDto() {
    }

    public MemberDto(String memberId, String memberTitle, String memberName, String contactNumber, Date memberSince) {
        this.memberId = memberId;
        this.memberTitle = memberTitle;
        this.memberName = memberName;
        this.contactNumber = contactNumber;
        this.memberSince = memberSince;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberTitle() {
        return memberTitle;
    }

    public void setMemberTitle(String memberTitle) {
        this.memberTitle = memberTitle;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    @Override
    public String toString() {
        return "memberDto [memberId=" + memberId + ", memberTitle=" + memberTitle + ", memberName=" + memberName + ", contactNumber="
                + contactNumber + ", memberSince=" + memberSince + "]";
    }

    
    
    
    
}
