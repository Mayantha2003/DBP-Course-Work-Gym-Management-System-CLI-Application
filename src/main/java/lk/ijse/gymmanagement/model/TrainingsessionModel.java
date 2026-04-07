package lk.ijse.gymmanagement.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.gymmanagement.db.DBConnection;
import lk.ijse.gymmanagement.dto.TrainingsessionsDTO;
import lk.ijse.gymmanagement.util.CrudUtil;

public class TrainingsessionModel {

    public boolean assignTrainer(TrainingsessionsDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isAssigned = CrudUtil.execute(
                    "INSERT INTO training_sessions(member_id, tariner_id) VALUES(?,?)",
                    dto.getMemberId(),
                    dto.getTrainerId()
            );

            boolean isCountUpdated = CrudUtil.execute(
                    "UPDATE trainers SET max_trainee_count = max_trainee_count + 1 WHERE id = ?",
                    dto.getTrainerId()
            );

            if (isAssigned && isCountUpdated) {
                connection.commit();
                return true;
            }
            connection.rollback();
            return false;

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public boolean removeAssignment(int sessionId, int trainerId) throws SQLException, ClassNotFoundException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isDeleted = CrudUtil.execute("DELETE FROM training_sessions WHERE id = ?", sessionId);

            boolean isCountReduced = CrudUtil.execute(
                    "UPDATE trainers SET max_trainee_count = max_trainee_count - 1 WHERE id = ?",
                    trainerId
            );

            if (isDeleted && isCountReduced) {
                connection.commit();
                return true;
            }
            connection.rollback();
            return false;

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public List<String> viewTrainerLoad() throws SQLException {
        String sql = "SELECT s.id, m.name, t.name, s.assigned_date FROM training_sessions s "
                + "JOIN members m ON s.member_id = m.id "
                + "JOIN trainers t ON s.tariner_id = t.id";

        ResultSet rs = CrudUtil.execute(sql);
        List<String> list = new ArrayList<>();

        while (rs.next()) {
            list.add("ID: " + rs.getInt(1) + " | Member: " + rs.getString(2) + " -> Trainer: " + rs.getString(3) + " [" + rs.getTimestamp(4) + "]");
        }
        return list;
    }
}
