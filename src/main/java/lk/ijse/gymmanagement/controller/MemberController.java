package lk.ijse.gymmanagement.controller;

import java.util.List;
import lk.ijse.gymmanagement.dto.MemberDTO;
import lk.ijse.gymmanagement.model.MemberModel;

public class MemberController {

    private MemberModel memberModel = new MemberModel();

    public void addMember(MemberDTO memberDTO) {
        try {
            boolean result = memberModel.addMember(memberDTO);

            if (result) {
                System.out.println("Member Registered Successfully!");
                return;
            } else {
                System.out.println("Failed to Register Member!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeMember(int id) {
        try {
            boolean result = memberModel.removeMember(id);

            if (result) {
                System.out.println("Member Record Deleted!");
                return;
            } else {
                System.out.println("Member ID not found or Delete Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMember(MemberDTO memberDTO) {
        try {
            boolean result = memberModel.updateMember(memberDTO);

            if (result) {
                System.out.println("Member Information Updated!");
                return;
            } else {
                System.out.println("Update Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberDTO> viewMembers() {
        try {
            List<MemberDTO> memberList = memberModel.viewMembers();
            return memberList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
