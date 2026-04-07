package lk.ijse.gymmanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.gymmanagement.dto.MemberDTO;
import lk.ijse.gymmanagement.util.CrudUtil;

public class MemberModel {

    public boolean addMember(MemberDTO memberDTO) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO members(name, membership_type) VALUES (?,?)",
                memberDTO.getName(),
                memberDTO.getMembershipType()
        );
    }

    public boolean removeMember(int id) throws SQLException {
        return CrudUtil.execute("DELETE FROM members WHERE id = ?", id);
    }

    public boolean updateMember(MemberDTO memberDTO) throws SQLException {
        return CrudUtil.execute(
                "UPDATE members SET name = ?, membership_type = ? WHERE id = ?",
                memberDTO.getName(),
                memberDTO.getMembershipType(),
                memberDTO.getId()
        );
    }

    public List<MemberDTO> viewMembers() throws SQLException {
        ResultSet results = CrudUtil.execute("SELECT * FROM members");

        List<MemberDTO> memberList = new ArrayList<>();

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String type = results.getString("membership_type");

            MemberDTO memberDTO = new MemberDTO(id, name, type);
            memberList.add(memberDTO);
        }
        return memberList;
    }

}
