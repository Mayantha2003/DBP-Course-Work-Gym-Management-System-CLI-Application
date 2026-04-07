package lk.ijse.gymmanagement.view;

import java.util.List;
import java.util.Scanner;
import lk.ijse.gymmanagement.controller.MemberController;
import lk.ijse.gymmanagement.dto.MemberDTO;


public class MemberView {
    
    private GymMenu gymMenu = new GymMenu();
    private MemberController memberController = new MemberController();

    public void render() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("============= Manage Members =============");
            System.out.println("");
            System.out.println("1) Add Member");
            System.out.println("2) Remove Member");
            System.out.println("3) Update Member");
            System.out.println("4) View Members");
            System.out.println("5) Back to Main");

            System.out.println("");
            System.out.print("Enter Your Option > ");
            int op = input.nextInt();

            switch (op) {
                case 1:
                    addMember();
                    break;
                case 2:
                    removeMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    viewMembers();
                    break;
                case 5:
                    gymMenu.showMenu();
                    return; 
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }

    public void addMember() {
        System.out.println("===================== Add Member =====================");
        System.out.println("");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Member Name : ");
        String name = input.nextLine();
        
        //This MemberShip type is My Desicsion and select the things 
        System.out.print("Enter Membership Type (Gold/Silver/Regular) : ");
        String type = input.nextLine();

        MemberDTO memberDTO = new MemberDTO(name, type);

        memberController.addMember(memberDTO);
        System.out.println("Member added successfully!");
    }

    public void removeMember() {
        System.out.println("=================== Remove Member =================");
        System.out.println("");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Member Id : ");
        int id = input.nextInt();

        memberController.removeMember(id);
        System.out.println("Member removed!");
    }

    public void updateMember() {
        System.out.println("===================== Update Member ====================");
        System.out.println("");
        Scanner input = new Scanner(System.in);

        viewMembers();
        System.out.println("");

        System.out.print("Enter Member id to Update : ");
        int id = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter New Name : ");
        String name = input.nextLine();

        System.out.print("Enter New Membership Type : ");
        String type = input.nextLine();

        MemberDTO memberDTO = new MemberDTO(id, name, type);

        memberController.updateMember(memberDTO);
        System.out.println("Member updated successfully!");
    }

    public void viewMembers() {
        try {
            System.out.println("================= List of Members ===============");
            System.out.println("");

            List<MemberDTO> memberList = memberController.viewMembers();

            for (MemberDTO memberDTO : memberList) {
                System.out.println("Member Id : " + memberDTO.getId());
                System.out.println("Member Name : " + memberDTO.getName());
                System.out.println("Membership Type : " + memberDTO.getMembershipType());
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error loading members: " + e.getMessage());
        }
    }
}
