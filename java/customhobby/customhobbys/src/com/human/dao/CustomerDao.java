package com.human.dao;

import com.human.dto.CustomerDto;
import com.human.dto.HobbyDto;
import com.human.util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class CustomerDao {
    public ArrayList<CustomerDto> getCustomersWithHobbies() {
        ArrayList<CustomerDto> customers = new ArrayList<>();
        
        String sql = "SELECT c.id, c.name, c.height, c.birthday, h.hobby " +
                     "FROM Customer c " +
                     "LEFT JOIN Hobby h ON c.id = h.id " +
                     "ORDER BY c.id";

        ResultSet rs = DBConn.statementQuery(sql);
        try {
            CustomerDto currentCustomer = null;
            int currentId = -1;

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double height = rs.getDouble("height");
                LocalDateTime birthday = rs.getTimestamp("birthday")
                                           .toInstant()
                                           .atZone(ZoneId.systemDefault())
                                           .toLocalDateTime();
                String hobby = rs.getString("hobby");

                if (currentCustomer == null || currentId != id) {
                    currentCustomer = new CustomerDto(id, name, height, birthday, new ArrayList<>());
                    customers.add(currentCustomer);
                    currentId = id;
                }
                
                if (hobby != null) {
                    currentCustomer.getHobbys().add(new HobbyDto(id, hobby));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          
        }
        return customers;
    }
}
