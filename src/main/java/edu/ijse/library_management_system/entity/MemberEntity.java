package edu.ijse.library_management_system.entity;

import java.util.Date;

public class MemberEntity {
    private String memberId;
    private String memberTitle;
    private String memberName;
    private String contactNumber;
    private Date memberSince;
    
    public MemberEntity() {
    }

    public MemberEntity(String memberId, String memberTitle, String memberName, String contactNumber, Date memberSince) {
        this.memberId = memberId;
        this.memberTitle = memberTitle;
        this.memberName = memberName;
        this.contactNumber = contactNumber;
        this.memberSince = memberSince;
    }

    public String getmemberId() {
        return memberId;
    }

    public void setmemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getmemberTitle() {
        return memberTitle;
    }

    public void setmemberTitle(String memberTitle) {
        this.memberTitle = memberTitle;
    }

    public String getmemberName() {
        return memberName;
    }

    public void setmemberName(String memberName) {
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

    
    
}
