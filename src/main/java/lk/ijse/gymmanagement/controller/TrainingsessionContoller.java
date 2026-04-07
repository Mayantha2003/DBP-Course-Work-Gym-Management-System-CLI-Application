package lk.ijse.gymmanagement.controller;

import java.util.List;
import lk.ijse.gymmanagement.dto.TrainingsessionsDTO;
import lk.ijse.gymmanagement.model.TrainingsessionModel;

public class TrainingsessionContoller {

    private TrainingsessionModel sessionModel = new TrainingsessionModel();

    public void assignTrainer(TrainingsessionsDTO dto) {
        try {
            boolean result = sessionModel.assignTrainer(dto);
            if (result) {
                System.out.println("Trainer Assigned to Member Successfully!");
            } else {
                System.out.println("Failed to Assign Trainer! (Transaction Rollbacked)");
            }
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            System.out.println("\n[ERROR] Assignment Failed: Member ID or Trainer ID does not exist!");
        } catch (Exception e) {
            System.out.println("Error while assigning: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void removeAssignment(int sessionId, int trainerId) {
        try {
            boolean result = sessionModel.removeAssignment(sessionId, trainerId);
            if (result) {
                System.out.println("Assignment Removed Successfully!");
            } else {
                System.out.println("Failed to Remove Assignment!");
            }
        } catch (Exception e) {
            System.out.println("Error while removing: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<String> viewTrainerLoad() {
        try {
            return sessionModel.viewTrainerLoad();
        } catch (Exception e) {
            System.out.println("Error loading Trainer Load: " + e.getMessage());
            return null;
        }
    }
}
