package com.reservation.ex;

import java.util.ArrayList;

import com.reservation.dao.CustomerDao;
import com.reservation.dao.ReservationDao;
import com.reservation.dao.SeatDao;
import com.reservation.util.UserInput;

public class DbConnEx {
	CustomerDao customerDao = new CustomerDao();
	SeatDao seatDao = new SeatDao();
	ReservationDao reservationDao = new ReservationDao();
	
	public void menu() {
		boolean isPlay = true;
		while(isPlay) {
			System.out.println("===== 레스토랑 예약 프로그램 =====");
			System.out.println("1. 고객 등록");
			System.out.println("2. 고객 수정");
			System.out.println("3. 고객 삭제");
			System.out.println("4. 좌석 등록");
			System.out.println("5. 좌석 수정");
			System.out.println("6. 좌석 삭제");
			System.out.println("7. 예약 등록");
			System.out.println("8. 예약 수정");
			System.out.println("9. 예약 삭제");
			System.out.println("10. 고객 전체 조회");
			System.out.println("11. 좌석 전체 조회");
			System.out.println("12. 예약 전체 조회");
			System.out.println("0. 프로그램 종료");
			int input = UserInput.inputInt("메뉴");
			switch(input) {
			case 0: return;
			case 1: customerDao.addCustomer(); break;
			case 2: customerDao.updateCustomer(); break;
			case 3: customerDao.deleteCustomer(); break;
			case 4: seatDao.addSeat(); break;
			case 5: seatDao.updateSeat(); break;
			case 6: seatDao.deleteSeat(); break;
			case 7: 
				Long customerId = UserInput.inputLong("customer_id");
				Long tableId = UserInput.inputLong("table_id");
				reservationDao.addReservation(customerId, tableId);
				break;
			case 8:
				reservationDao.updateReservation();
				break;
			case 9:
				reservationDao.deleteReservation();
				break;
			case 10:
				customerDao.printCustomer();
				break;
			case 11:
				seatDao.printSeat();
				break;
			case 12:
				reservationDao.printReservation();
				break;
			default:
				System.out.println("잘못된 입력");
			}
		}
	}
	public static void main(String[] args) {
		new DbConnEx().menu();
	}
}
