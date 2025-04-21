package com.the.ex;

import com.the.dao.CustomerDao;
import com.the.dao.HobbyDao;
import com.the.dto.CustomerDto;
import com.the.dto.CustomerHobbyDto;
import com.the.dto.HobbyDto;
import com.the.util.UserInput;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CustomHobbyEx2 {
    private static CustomerDao customerDao = new CustomerDao();
    private static HobbyDao hobbyDao = new HobbyDao();
	public static com.the.dao.CustomerHobbyDao customerHobbyDao=new com.the.dao.CustomerHobbyDao();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== 고객 및 취미 등록 시스템 =====");
            System.out.println("1. 고객 및 취미 추가");
            System.out.println("2. 고객 및 취미 검색");
            System.out.println("3. 고객 및 취미 삭제");
            System.out.println("0. 종료");
            
            int choice = UserInput.inputInt("메뉴 선택");
            switch (choice) {
                case 1: addCustomerWithHobby(); break;
                case 2: selectCustomerWithHobby(); break;
                case 3: deleteCustomerWithHobby(); break;
                case 0: System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }

    private static void deleteCustomerWithHobby() {
		
    	Long customerId = UserInput.inputLong("삭제할 ID");
    	customerHobbyDao.deleteCustomerHobbys(customerId);
    	System.out.println("선택한 고객과 하비가 삭제되었습니다.");
		
	}

	private static void selectCustomerWithHobby() {
    	ArrayList<CustomerHobbyDto> dtos=customerHobbyDao.selectCustomerHobbys();
    	for(CustomerHobbyDto dto:dtos) {
    		System.out.println(dto);
    	}
		
	}

	private static void addCustomerWithHobby() {
        String name = UserInput.inputString("이름");
        int age = UserInput.inputInt("나이");
        double height = UserInput.inputDouble("키");
        LocalDateTime birthday = UserInput.inputLocalDateTime("생년월일");
        CustomerDto customer = new CustomerDto(null, name, age, height, birthday);
        customerDao.insert(customer);
        System.out.println("고객이 추가되었습니다.");
        
        // 방금 저장된 고객아이디 읽어오기
        Long customerMaxId=customerHobbyDao.getCustomerMaxId();
        customer.setId(customerMaxId);
        
        long customerId = customer.getId();
       // ArrayList<String> hobbies = new ArrayList<>();
        
        while (true) {
            String hobby = UserInput.inputString("추가할 취미 (종료하려면 엔터)");
            if (hobby.equals("")) break;
         //   hobbies.add(hobby);
            hobbyDao.insert(new HobbyDto(null, customerId, hobby));
        }
        
//        for (String hobby : hobbies) {
//            hobbyDao.insert(new HobbyDto(null, customerId, hobby));
//        }
        
        System.out.println("취미가 추가되었습니다.");
    }
}
