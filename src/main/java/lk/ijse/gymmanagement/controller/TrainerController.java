package lk.ijse.gymmanagement.controller;

import java.util.List;
import lk.ijse.gymmanagement.dto.TrainerDTO;
import lk.ijse.gymmanagement.model.TrainerModel;

public class TrainerController {

    private TrainerModel trainerModel = new TrainerModel();

    public void addTrainer(TrainerDTO trainerDTO) {
        try {
            boolean isAdded = trainerModel.addTrainer(trainerDTO);
            if (isAdded) {
                System.out.println("Trainer Saved Successfully!");
            } else {
                System.out.println("Failed to Save Trainer!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTrainer(int id) {
        try {
            boolean isDeleted = trainerModel.removeTrainer(id);
            if (isDeleted) {
                System.out.println("Trainer Deleted Successfully!");
            } else {
                System.out.println("Trainer ID not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTrainer(TrainerDTO trainerDTO) {
        try {
            boolean isUpdated = trainerModel.updateTrainer(trainerDTO);
            if (isUpdated) {
                System.out.println("Trainer Updated Successfully!");
            } else {
                System.out.println("Update Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TrainerDTO> viewTrainers() {
        try {
            List<TrainerDTO> trainerList = trainerModel.viewTrainers();
            return trainerList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

