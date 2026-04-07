package lk.ijse.gymmanagement.view;

import java.util.Scanner;

public class GymMenu {

    public void showMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("===============  Gym Managment System =============");
        System.out.println("");

        while (true) {
            System.out.println("1) Manage Member");
            System.out.println("2) Manage Trainers");
            System.out.println("3) Assign to Trainers");
            System.out.println("4) Exit");

            System.out.println("");
            System.out.print("Enter Your Option > ");
            int op = input.nextInt();

            switch (op) {
                case 1:
                    new MemberView().render();
                    break;
                case 2:
                    new TrainerView().render();
                    break;
                case 3:
                    new TrainingSessionView().render();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Please Choose a valid Option");
            }
        }
    }

}
