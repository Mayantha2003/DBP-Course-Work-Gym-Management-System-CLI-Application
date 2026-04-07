package lk.ijse.gymmanagement.dto;

import java.security.Timestamp;


public class TrainingsessionsDTO {

    private int id;
    private int memberId;
    private int trainerId;
    private Timestamp assignedDate;

    public TrainingsessionsDTO() {
    }

    public TrainingsessionsDTO(int memberId, int trainerId, Timestamp assignedDate) {
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.assignedDate = assignedDate;
    }

    public TrainingsessionsDTO(int id, int memberId, int trainerId, Timestamp assignedDate) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.assignedDate = assignedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public Timestamp getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Timestamp assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Override
    public String toString() {
        return "TrainingsessionsDTO{" + "id=" + id + ", memberId=" + memberId + ", trainerId=" + trainerId + ", assignedDate=" + assignedDate + '}';
    }
    
    

}

