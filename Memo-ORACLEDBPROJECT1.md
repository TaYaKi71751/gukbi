# Customers 테이블 (고객 테이블)
|Column|Data Type|Description|
|-|-|-|
|customer_id|number|고객 고유 ID (Primary Key)|
|first_name|varchar(100)|고객 성|
|last_name|varchar(100)|고객 이름|
|email|varchar(255)|이메일 주소|
|phone|varchar(20)|전화번호|
# Seats 테이블 (좌석 테이블)
|Column|Data Type|Description|
|-|-|-|
|table_id|number|테이블의 id (Primary Key)|
|customer_seats|number|테이블에 앉을 수 있는 좌석 수|
|status|varchar(20)|좌석의 상태 (예: '예약 가능','예약됨')|
# Reservations 테이블 (예약 테이블)
|Column|Data Type|Description|
|-|-|-|
|reservation_id|number|예약 고유 ID (Primary Key)|
|customer_id|number|고객 ID (Foreign Key)|
|table_id|number|테이블 ID (Foreign Key)|
|reservation_time|date|예약 시간|
|number_of_guests|number|예약 인원 수|