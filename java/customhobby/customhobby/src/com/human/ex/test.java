package com.human.ex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.human.dao.CustomerDao;
import com.human.dao.CustomerHobbyDao;
import com.human.dao.HobbyDao;
import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;
import com.human.dto.HobbyDto;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        CustomerDao customerDao = new CustomerDao();
        HobbyDao hobbyDao = new HobbyDao();
        CustomerHobbyDao customerHobbyDao = new CustomerHobbyDao();

        while (true) {
            System.out.println("1. 고객 추가");
            System.out.println("2. 고객 목록 조회");
            System.out.println("3. 고객 ID로 조회");
            System.out.println("4. 고객 수정 (이름 변경)");
            System.out.println("5. 고객 삭제");
            System.out.println("6. 취미 추가");
            System.out.println("7. 전체 고객과 취미 조회");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    System.out.print("키: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine(); // 버퍼 클리어
                    LocalDateTime birthday = LocalDateTime.now();
                    CustomerDto customer = new CustomerDto(0, name, height, birthday);
                    customerDao.insert(customer);
                    System.out.println("고객 추가 완료!");
                    break;
                case 2:
                    ArrayList<CustomerDto> customers = customerDao.selectAll();
                    for (CustomerDto c : customers) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("조회할 ID 입력: ");
                    int id = scanner.nextInt();
                    CustomerDto selectedCustomer = customerDao.selectId(id);
                    System.out.println(selectedCustomer);
                    break;
                case 4:
                    System.out.print("수정할 고객 ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("새 이름: ");
                    String newName = scanner.nextLine();
                    customerDao.update(updateId, newName);
                    System.out.println("수정 완료!");
                    break;
                case 5:
                    System.out.print("삭제할 고객 ID: ");
                    int deleteId = scanner.nextInt();
                    customerDao.delete(deleteId);
                    System.out.println("삭제 완료!");
                    break;
                case 6:
                    System.out.print("취미 추가할 고객 ID: ");
                    int hobbyId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("취미: ");
                    String hobby = scanner.nextLine();
                    HobbyDto hobbyDto = new HobbyDto(hobbyId, hobby);
                    hobbyDao.insert(hobbyDto);
                    System.out.println("취미 추가 완료!");
                    break;
                case 7:
                    ArrayList<CustomerHobbyDto> customerHobbies = customerHobbyDao.selectAllCustomerAndHobby();
                    for (CustomerHobbyDto ch : customerHobbies) {
                        System.out.println(ch);
                    }
                    break;
                case 0:
                    System.out.println("프로그램 종료!");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력!");
            }
        }
	}

}
