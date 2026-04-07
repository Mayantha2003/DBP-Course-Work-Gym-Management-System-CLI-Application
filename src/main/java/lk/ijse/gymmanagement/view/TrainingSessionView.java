package lk.ijse.gymmanagement.view;

import java.util.List;
import java.util.Scanner;
import lk.ijse.gymmanagement.controller.TrainingsessionContoller;
import lk.ijse.gymmanagement.dto.TrainingsessionsDTO;

public class TrainingSessionView {

    private TrainingsessionContoller controller = new TrainingsessionContoller();
    private GymMenu gymMenu = new GymMenu();

    public void render() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n============= Training Session Management =============");
            System.out.println("1) Assign Trainer to Member");
            System.out.println("2) Remove Assignment");
            System.out.println("3) View Trainer Load (All Assignments)");
            System.out.println("4) Back to Main Menu");

            System.out.print("\nEnter Your Option > ");
            int op = input.nextInt();

            switch (op) {
                case 1:
                    assignTrainer();
                    break;
                case 2:
                    removeAssignment();
                    break;
                case 3:
                    viewTrainerLoad();
                    break;
                case 4:
                    gymMenu.showMenu();
                    return;
                default:
                    System.out.println("Invalid Option! Please try again.");
            }
        }
    }

    private void assignTrainer() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Assign New Session ---");

        System.out.print("Enter Member ID : ");
        int memberId = input.nextInt();

        System.out.print("Enter Trainer ID : ");
        int trainerId = input.nextInt();

        TrainingsessionsDTO dto = new TrainingsessionsDTO();
        dto.setMemberId(memberId);
        dto.setTrainerId(trainerId);

        controller.assignTrainer(dto);
    }

    private void removeAssignment() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Remove Session Assignment ---");

        viewTrainerLoad();

        System.out.print("\nEnter Session ID to Remove : ");
        int sessionId = input.nextInt();

        System.out.print("Enter the Trainer's ID (to decrement count) : ");
        int trainerId = input.nextInt();

        controller.removeAssignment(sessionId, trainerId);
    }

    private void viewTrainerLoad() {
        
        System.out.println("\n--- Current Trainer Load & Assignments ---");
        List<String> loadList = controller.viewTrainerLoad();

        if (loadList == null || loadList.isEmpty()) {
            System.out.println("No active assignments found.");
        } else {
            for (String loadDetail : loadList) {
                System.out.println(loadDetail);
            }
        }
    }
}
