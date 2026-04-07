package lk.ijse.gymmanagement.view;

import java.util.List;
import java.util.Scanner;
import lk.ijse.gymmanagement.controller.TrainerController;
import lk.ijse.gymmanagement.dto.TrainerDTO;

public class TrainerView {

    private GymMenu gymMenu = new GymMenu();
    private TrainerController trainerController = new TrainerController();

    public void render() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("============= Manage Trainers =============");
            System.out.println("");
            System.out.println("1) Add Trainer");
            System.out.println("2) Remove Trainer");
            System.out.println("3) Update Trainer");
            System.out.println("4) View Trainers");
            System.out.println("5) Back to Main");

            System.out.println("");
            System.out.print("Enter Your Option > ");
            int op = input.nextInt();

            switch (op) {
                case 1:
                    addTrainer();
                    break;
                case 2:
                    removeTrainer();
                    break;
                case 3:
                    updateTrainer();
                    break;
                case 4:
                    viewTrainers();
                    break;
                case 5:
                    gymMenu.showMenu();
                    return;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }

    public void addTrainer() {
        System.out.println("===================== Add Trainer =====================");
        System.out.println("");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Trainer Name : ");
        String name = input.nextLine();

        System.out.print("Enter Max Trainee Count : ");
        int count = input.nextInt();

        TrainerDTO trainerDTO = new TrainerDTO(name, count);

        trainerController.addTrainer(trainerDTO);
    }

    public void removeTrainer() {
        System.out.println("=================== Remove Trainer =================");
        System.out.println("");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Trainer Id : ");
        int id = input.nextInt();

        trainerController.removeTrainer(id);
    }

    public void updateTrainer() {
        System.out.println("===================== Update Trainer ====================");
        System.out.println("");
        Scanner input = new Scanner(System.in);

        viewTrainers();
        System.out.println("");

        System.out.print("Enter Trainer id to Update : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter New Name : ");
        String name = input.nextLine();

        System.out.print("Enter New Max Trainee Count : ");
        int count = input.nextInt();

        TrainerDTO trainerDTO = new TrainerDTO(id, name, count);

        trainerController.updateTrainer(trainerDTO);
    }

    public void viewTrainers() {
        try {
            System.out.println("================= List of Trainers ===============");
            System.out.println("");

            List<TrainerDTO> trainerList = trainerController.viewTrainers();

            for (TrainerDTO trainerDTO : trainerList) {
                System.out.println("Trainer Id : " + trainerDTO.getId());
                System.out.println("Trainer Name : " + trainerDTO.getName());
                System.out.println("Max Trainee Count : " + trainerDTO.getMaxTraineeCount());
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error loading trainers: " + e.getMessage());
        }
    }
}
