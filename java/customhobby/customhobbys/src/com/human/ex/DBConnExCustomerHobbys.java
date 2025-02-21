package com.human.ex;

import com.human.dao.CustomerDao;
import com.human.dto.CustomerDto;
import com.human.dto.HobbyDto;

import java.util.ArrayList;

public class DBConnExCustomerHobbys {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        ArrayList<CustomerDto> customers = customerDao.getCustomersWithHobbies();

        for (CustomerDto customer : customers) {
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Height: " + customer.getHeight());
            System.out.println("Birthday: " + customer.getBirthday());
            System.out.println("Hobbies: ");
            for (HobbyDto hobby : customer.getHobbys()) {
                System.out.println("  - " + hobby.getHobby());
            }
            System.out.println("-------------------------");
        }
    }
}
