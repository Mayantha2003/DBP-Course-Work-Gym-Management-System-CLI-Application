package lk.ijse.gymmanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.gymmanagement.dto.TrainerDTO;
import lk.ijse.gymmanagement.util.CrudUtil;


public class TrainerModel {

    public boolean addTrainer(TrainerDTO trainerDTO) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO trainers(name, max_trainee_count) VALUES (?,?)",
                trainerDTO.getName(),
                trainerDTO.getMaxTraineeCount()
        );
    }

    public boolean removeTrainer(int id) throws SQLException {
        return CrudUtil.execute("DELETE FROM trainers WHERE id = ?", id);
    }

    public boolean updateTrainer(TrainerDTO trainerDTO) throws SQLException {
        return CrudUtil.execute(
                "UPDATE trainers SET name = ?, max_trainee_count = ? WHERE id = ?",
                trainerDTO.getName(),
                trainerDTO.getMaxTraineeCount(),
                trainerDTO.getId()
        );
    }

    public List<TrainerDTO> viewTrainers() throws SQLException {
        ResultSet results = CrudUtil.execute("SELECT * FROM trainers");
        List<TrainerDTO> trainerList = new ArrayList<>();

        while (results.next()) {
            trainerList.add(new TrainerDTO(
                    results.getInt("id"),
                    results.getString("name"),
                    results.getInt("max_trainee_count")
            ));
        }
        return trainerList;
    }
}
