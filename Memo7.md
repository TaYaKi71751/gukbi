# JDBCTest.java
```
package com.the.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null; // 연결정보 객체 주소록에서 찾아서 전화걸기전 상태
		String sql = null; // sql 요청정보 대화
		Statement st = null; // 연결상태 통화중인 상태
		ResultSet rs = null; // 요청한 결과를 담음
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:";
			String user = "c##human";
			String pw = "human";
			conn = DriverManager.getConnection(url, user, pw);
			sql = "select * from human";
			st = conn.createStatement();
			rs = st.executeQuery(sql); // 요청 대화
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				LocalDateTime birthday = rs.getTimestamp("birthday").toLocalDateTime();
				System.out.println("name:" + rs.getString(1));
				System.out.println("age:" + rs.getInt(2));
				System.out.println("height:" + rs.getDouble(3));
				System.out.println("birth:" + rs.getTimestamp(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
                // 반드시 닫아주어야 한다.
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
```
- 주요 시간 클래스
```
1. LocalDate: 날짜만 표현 (예: 2025-01-19).
2. LocalTime: 시간만 표현 (예: 14:30:00).
3. LocalDateTime: 날짜와 시간을 함께 표현 (예: 2025-01-19T14:30:00).
4. ZonedDateTime: 날짜와 시간을 포함하고 시간대 정보를 추가로 포함 (예: 2025-01-19T14:30:00+09:00[Asia/Seoul]).
```
```
package com.the.ex;

import java.time.*;

public class JDBCDate {
	public static void main(String[] args) {
		// 현재 날짜
		LocalDate today = LocalDate.now();
		System.out.println("현재 날짜: " + today);
		// 현재 시간
		LocalTime nowTime = LocalTime.now();
		System.out.println("현재 시간: " + nowTime);
		// 현재 날짜와 시간
		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println("현재 날짜와 시간: " + nowDateTime);
		// 현재 날짜와 시간 (시간대 포함)
		ZonedDateTime zonedNow = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("현재 서울 시간: " + zonedNow);
	}
}
```
- 특정 날짜와 시간 생성
```
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
// 특정 날짜 생성
		LocalDate specificDate = LocalDate.of(2023, 12, 25);
		System.out.println("특정 날짜: " + specificDate);
// 특정 시간 생성
		LocalTime specificTime = LocalTime.of(14, 30, 15);
		System.out.println("특정 시간: " + specificTime);
// 특정 날짜와 시간 생성
		LocalDateTime specificDateTime = LocalDateTime.of(2023, 12, 25, 14, 30, 15);
		System.out.println("특정 날짜와 시간: " + specificDateTime);
	}
}
```
- 문자열로부터 시간 데이터 생성
```
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
// 문자열을 LocalDateTime으로 변환
		String dateTimeString = "2025-01-19T14:30:00";
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
		System.out.println("파싱된 날짜와 시간: " + dateTime);
// 사용자 정의 포맷으로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String customDateTimeString = "2025-01-19 14:30:00";
		LocalDateTime customDateTime = LocalDateTime.parse(customDateTimeString, formatter);
		System.out.println("사용자 정의 포맷 파싱: " + customDateTime);
	}
}
```
- 시간을 원하는 문자열로 출력하기
```
Java에서 LocalDateTime 데이터를 원하는 형식으로 출력하려면 DateTimeFormatter 클래스를 사용하면 됩니다.
```
- 기본적인 날짜 및 시간 포맷팅
```
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
// 현재 날짜 및 시간
		LocalDateTime now = LocalDateTime.now();
// 원하는 형식 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// 포맷 적용
		String formattedDateTime = now.format(formatter);
// 출력
		System.out.println("포맷된 날짜 시간: " + formattedDateTime);
	}
}
```
- 출력 예시
```
포맷된 날짜 시간: 2025-02-08 14:30:45
```
- 다양한 포맷 예제

|패턴 문자열|설명|예제 출력|
|-|-|-|
|yyyy-MM-dd|연-월-일|2025-02-08|
|yyyy/MM/dd|연/월/일|2025/02/08|
|MM-dd-yyyy|월-일-연|02-08-2025|
|dd MMM yyyy|일 월 연|08 Feb 2025|
|E, MMM dd yyyy|요일, 월 일 연|Sat, Feb 08 2025|
|HH:mm:ss|시:분:초 (24시간제)|14:30:45|
|hh:mm a|시:분 AM/PM (12시간제)|02:30 PM|
- 커스텀 포맷으로 변환
```
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		String dateTimeStr = "2025-02-08 14:30:45";
// 기존 포맷
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// 새 포맷
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("E MMM dd, yyyy hh:mm a");
// 문자열을 LocalDateTime으로 변환 후 새로운 포맷 적용
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, inputFormatter);
		String formattedDate = dateTime.format(outputFormatter);
// 출력
		System.out.println("새로운 포맷: " + formattedDate);
	}
}
```
- 시간대(TimeZone) 포함 변환
```
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime seoulTime = now.atZone(ZoneId.of("Asia/Seoul"));
// 포맷 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
// 포맷 적용
		String formattedDateTime = seoulTime.format(formatter);
// 출력
		System.out.println("서울 시간대 포맷: " + formattedDateTime);
	}
}
```
- 날짜와 시간 정보 추출
```
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		int year = dateTime.getYear();
		int month = dateTime.getMonthValue(); // 월 (1~12)
		int day = dateTime.getDayOfMonth();
		int hour = dateTime.getHour();
		int minute = dateTime.getMinute();
		int second = dateTime.getSecond();
		System.out.println("년도: " + year);
		System.out.println("월: " + month);
		System.out.println("일: " + day);
		System.out.println("시: " + hour);
		System.out.println("분: " + minute);
		System.out.println("초: " + second);
	}
}
```
- 날짜와 시간 연산
```
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("현재 날짜와 시간: " + dateTime);
// 10일 뒤로 이동
		LocalDateTime plusDays = dateTime.plusDays(10);
		System.out.println("10일 뒤: " + plusDays);
// 3시간 전으로 이동
		LocalDateTime minusHours = dateTime.minusHours(3);
		System.out.println("3시간 전: " + minusHours);
// 2개월 뒤로 이동
		LocalDateTime plusMonths = dateTime.plusMonths(2);
		System.out.println("2개월 뒤: " + plusMonths);
	}
}
```
- 비교 및 검사
```
import java.time.LocalDateTime;

public class JDBCDate {
	public static void main(String[] args) {
		LocalDateTime dateTime1 = LocalDateTime.of(2025, 1, 19, 14, 30);
		LocalDateTime dateTime2 = LocalDateTime.of(2023, 12, 25, 10, 0);
// 비교
		boolean isEqual = dateTime1.isEqual(dateTime2);
		boolean isAfter = dateTime1.isAfter(dateTime2);
		boolean isBefore = dateTime1.isBefore(dateTime2);
		System.out.println("dateTime1이 dateTime2 동일한가?" + isEqual);
		System.out.println("dateTime1이 dateTime2 이후인가? " + isAfter);
		System.out.println("dateTime1이 dateTime2 이전인가? " + isBefore);
	}
}
```
# LocalDateTime과 다른 클래스 간 변환
- LocalDateTime → LocalDate / LocalTime
```
import java.time.*;

public class Main {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDate date = dateTime.toLocalDate();
		LocalTime time = dateTime.toLocalTime();
		System.out.println("날짜: " + date);
		System.out.println("시간: " + time);
	}
}
```
- LocalDateTime → ZonedDateTime
```
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("Asia/Seoul"));
		System.out.println("시간대 포함 날짜와 시간: " + zonedDateTime);
	}
}
```
- 년월일 시분초 차이구하는 프로그램
```
import java.time.*;

public class TimeDifferenceCalculator {
	public static void main(String[] args) {
// 두 개의 LocalDateTime 값 직접 설정
		LocalDateTime time1 = LocalDateTime.of(2024, 2, 5, 14, 30, 0);
// 2024년 2월 5일 14:30:00
		LocalDateTime time2 = LocalDateTime.of(2024, 3, 8, 16, 45, 30);
// 2024년 3월 8일 16:45:30
// 두 시간의 차이 계산
		printTimeDifference(time1, time2);
	}

// 두 시간의 차이 계산 및 출력 함수
	private static void printTimeDifference(LocalDateTime start, LocalDateTime end) {
		Period period = Period.between(start.toLocalDate(), end.toLocalDate()); // 날짜(년월일) 차이
		Duration duration = Duration.between(start, end); // 시간(시분초) 차이
		long totalHours = duration.toHours();
		long totalMinutes = duration.toMinutes();
		long totalSeconds = duration.toSeconds();
		long hours = duration.toHoursPart();
		long minutes = duration.toMinutesPart();
		long seconds = duration.toSecondsPart();
		System.out.println("날짜 차이: " + period.getYears() + "년 " + period.getMonths() + "개월 " + period.getDays() + "일");
		System.out.println("시간 차이: " + hours + "시간 " + minutes + "분" + seconds + "초");
		System.out.println("총 시간 차이: " + totalHours + "시간");
		System.out.println("총 분 차이: " + totalMinutes + "분");
		System.out.println("총 초 차이: " + totalSeconds + "초");
	}
}
```
- 년월일 시분초 차이구하는 프로그램
```
import java.time.*;

public class TimeDifferenceCalculator {
	public static void main(String[] args) {
// 두 개의 LocalDateTime 값 직접 설정
		LocalDateTime time1 = LocalDateTime.of(2024, 2, 5, 23, 59, 59);
		LocalDateTime time2 = LocalDateTime.of(2024, 2, 6, 0, 0, 0);
// 두 시간의 차이 계산
		printTimeDifference(time1, time2);
	}

// 두 시간의 차이 계산 및 출력 함수
	private static void printTimeDifference(LocalDateTime start, LocalDateTime end) {
		Period period = Period.between(start.toLocalDate(), end.toLocalDate()); // 날짜(년월일) 차이
		Duration duration = Duration.between(start, end); // 날짜(일) 및 시간(시분초) 차이
        long totalDays = duration.toDays();
		long totalHours = duration.toHours();
		long totalMinutes = duration.toMinutes();
		long totalSeconds = duration.toSeconds();
        long days = duration.toDaysPart();
		long hours = duration.toHoursPart();
		long minutes = duration.toMinutesPart();
		long seconds = duration.toSecondsPart();
		System.out.println("날짜 차이: " + period.getYears() + "년 " + period.getMonths() + "개월 " + days + "일");
        // 0년 0개월 0일
        // period.getDays() 를 사용하면 1일 로 나온다.
		System.out.println("시간 차이: " + hours + "시간 " + minutes + "분" + seconds + "초");
        // 0시간 0분 1초
        System.out.println("총 일 차이: " + totalDays + "일");
		System.out.println("총 시간 차이: " + totalHours + "시간");
		System.out.println("총 분 차이: " + totalMinutes + "분");
		System.out.println("총 초 차이: " + totalSeconds + "초");
	}
}
```
# DBConn.java
```
package com.the.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	private DBConn() {}
	private static Connection dbConn=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:";
				String id="c##human";
				String pw="human";
				dbConn=DriverManager.getConnection(url,id,pw);
				System.out.println("DBConnection....");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(dbConn!=null)dbConn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs=null;st=null;dbConn=null;
		}
		
	}
	public static int statementUpdate(String sql) {
        System.out.println(sql);
		int rValue=-1;
		if(dbConn!=null) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				//insert,delete,update
				rValue=st.executeUpdate(sql);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("not connected...");
		}
		return rValue;
	}
	public static ResultSet statementQuery(String sql) {
        System.out.println(sql);
		if(dbConn!=null) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				//insert,delete,update
				rs=st.executeQuery(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("not connected...");
		}
		return rs;
	}
}
```
# UserInput.java
```
package com.the.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(String st) {
        System.out.println(st + " 정수입력>>");
        return Integer.parseInt(sc.nextLine());        
    }

    public static double inputDouble(String st) {
        System.out.println(st + " 실수입력>>");
        return Double.parseDouble(sc.nextLine());        
    }

    public static String inputString(String st) {
        System.out.println(st + " 문자입력>>");
        return sc.nextLine();        
    }

    public static LocalDateTime inputDate(String st) {
        LocalDateTime rValue = null; // LocalDateTime 객체로 입력을 받음
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(st + " 날짜입력(yyyy/MM/dd HH:mm:ss)>>");
        String dtString = sc.nextLine();
        if(dtString.trim().equals("")){
            rValue = LocalDateTime.now();
        } else {
            rValue = LocalDateTime.parse(dtString.trim(), formatter);
        }
        return rValue;        
    }

    public static String dateToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return date.format(formatter);        
    }
}
```
# HumanDto.java
```
package com.the.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class HumanDto {
	private String name;
	private Integer age;
	private Double height;
	private LocalDateTime birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public LocalDateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	public HumanDto() {}
	public HumanDto(String name, Integer age, Double height, LocalDateTime birthday) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HumanDto other = (HumanDto) obj;
		return Objects.equals(age, other.age) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(height, other.height) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "HumanDto [name=" + name + ", age=" + age + ", height=" + height + ", birthday=" + birthday + "]";
	}
}
```
# HumanDao.java
```
package com.the.dao;

import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.the.dto.HumanDto;
import com.the.util.DBConn;

public class HumanDao {

	public void insert(HumanDto dto) {
		DBConn.getInstance();
		String sql = String.format("insert into human values('%s',%d,%f,to_date('%s','YYYY/MM/DD HH24:MI:ss'))",
				dto.getName(), dto.getAge(), dto.getHeight(),
				dto.getBirthday().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		DBConn.statementUpdate(sql);
		DBConn.dbClose();
	}

	public void update(int age, String name) {
		DBConn.getInstance();
		String sql = String.format("update human set age=%d where name='%s'", age, name);
		DBConn.statementUpdate(sql);
		DBConn.dbClose();
	}

	public void delete(String name) {
		DBConn.getInstance();
		String sql = String.format("delete human where name='%s'", name);
		DBConn.statementUpdate(sql);
		DBConn.dbClose();
	}

	public ArrayList<HumanDto> select() {
		DBConn.getInstance();
		ArrayList<HumanDto> result = new ArrayList<HumanDto>();
		String sql = "select * from human";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				result.add(new HumanDto(rs.getString("name"), rs.getInt("age"), rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.dbClose();
		}
		return result;
	}
}
```
# JBDCEx.java
```
package com.the.ex;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.the.util.*;
import com.the.dao.HumanDao;
import com.the.dto.*;

public class JDBCEx {
	public static void main(String[] args) {
		HumanDao hDao = new HumanDao();
		ArrayList<HumanDto> resultDtos = new ArrayList<HumanDto>();
        // insert
        System.out.println("Human데이터 입력");
        String name = UserInput.inputString("이름");
        int age = UserInput.inputInt("나이");
        double height = UserInput.inputDouble("키");
        LocalDateTime birthday = UserInput.inputDate("생일");
        HumanDto dto = new HumanDto(name, age, height, birthday);
		hDao.insert(dto);
        
        // update 이름을 이용해서 나이를 변경
        System.out.println("수정할 이름, 나이를 입력하세요.");
        name = UserInput.inputString("이름");
        age = UserInput.inputInt("나이");
        hDao.update(age, name);
        
        // delete
        System.out.println("삭제할 이름을 입력하세요.");
        name = UserInput.inputString("이름");
        hDao.delete(name);
        
        
        // select
        resultDtos = hDao.select();
		for(HumanDto item:resultDtos) {
			System.out.println(item);
		}
	}
}
```
