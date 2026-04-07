package lk.ijse.gymmanagement.dto;

public class TrainerDTO {

    private int id;
    private String name;
    private int maxTraineeCount;

    public TrainerDTO() {
    }

    public TrainerDTO(String name, int maxTraineeCount) {
        this.name = name;
        this.maxTraineeCount = maxTraineeCount;
    }

    public TrainerDTO(int id, String name, int maxTraineeCount) {
        this.id = id;
        this.name = name;
        this.maxTraineeCount = maxTraineeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTraineeCount() {
        return maxTraineeCount;
    }

    public void setMaxTraineeCount(int maxTraineeCount) {
        this.maxTraineeCount = maxTraineeCount;
    }

    @Override
    public String toString() {
        return "TrainnerDTO{" + "id=" + id + ", name=" + name + ", maxTraineeCount=" + maxTraineeCount + '}';
    }
    
    

}
