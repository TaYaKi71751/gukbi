[pdf](../../pdf/JAVA240812simple254.pdf)
# 다음 문제를 풀어보자.
1. 50명의 학생의 출석 사항을 처리하는 프로그램을 만들어 보자. 
```
출석자는 true이고결석자는 false 데이터를 가진다.
boolean student[]=new boolean[50]; 배열을 사용해서 아래와 같은 메뉴를 가진 프로그램을 만들어 보자.
```
```
메뉴:
1.전체 출석사항 2.결석자 추가 3.출석자 추가 6.프로그램 종료
```
설명
```
1.전체 출석사항
배열에 true가 들어 있으면 출석, false가 들어 있으면 결석이다.
인덱스 + 1 를 학생 번호라 할때 모든 학생별 상황을 다음과 같이 출력 한다.
"1번 학생의 출석 사항은 출석입니다."
"2번 학생의 출석 사항은 결석입니다."
2.결석자 추가
결석한 학생의 번호를 입력 받아 입력 받은 숫자에 해당하는 배열의 인덱스에 false를 넣으면 된다.
3.출석자 추가
출석한 학생의 번호를 입력 받아 입력 받은 숫자에 해당하는 배열의 인덱스에 true를 넣으면 된다.
4.프로그램 종료
진행중인 프로그램을 종료시키면 된다.
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
boolean student[] = new boolean[50];
int input = 0;
for(int i = 0;i < student.length;i++){
    student[i] = false;
}
while(input != 6){
    System.out.println("1.전체 출석사항");
    System.out.println("2.결석자 추가");
    System.out.println("3.출석자 추가");
    System.out.println("6.프로그램 종료");
    try {
        input = Integer.parseInt(sc.nextLine());
    } catch(Exception e){
        System.out.println("잘못 입력 하였습니다.");
        continue;
    }
    switch(input){
        case 1:
            for(int i = 0;i < student.length;i++){
                System.out.println(i + 1 + " " + (student[i] ? "출석" : "결석"));
            }
            break;
        case 2:
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            student[i - 1] = false;
            input = 0;
            break;
        case 3:
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            student[i - 1] = true;
            input = 0;
            break;
        case 6:
            System.out.println("프로그램 종료");
            return;
        default:
            System.out.println("잘못 입력 하였습니다.");
    }
}
```
2. 은행 프로그램을 순서도와 프로그래밍 언어로 만들어 보자.
```
은행 프로그램의 메뉴는 다음과 같다. ‘전체메뉴: 1.입금 2.출금 3.조회 0.종료’
account 변수에 처음에 0으로 세팅하고 입금 출금을 통에 원하는 액수를 더하거나 빼준다.
결국 account 변수에 있는 숫자가 은행계좌에 남은 돈이 된다.
입금 메뉴를 통해 입금 액을 받아 account 변수에 추가 할 수 있다.
출금 메뉴를 통해 출금 액을 account 변수에서 뺄 수 있다.
조회 메뉴를 통해 account에 입금 액이 얼마나 남아 있나 확인 할 수 있다.
조심해야 할 부분은 운영중 account의 값이 유지될수 있도록 적절한 위치에 선언해야
운영중에 값 손실이 생기지 않는다.
```
실행화면
```
메뉴: 1.입금 2.출금 3.조회 0.종료
3
현재 잔액은 0원 입니다.
메뉴: 1.입금 2.출금 3.조회 0.종료
1
입금액을 입력하세요.
100000
메뉴: 1.입금 2.출금 3.조회 0.종료
2
출금액을 입력하세요
35000
메뉴: 1.입금 2.출금 3.조회 0.종료
3
현재 잔액은 65000원 입니다.
메뉴: 1.입금 2.출금 3.조회 0.종료
0
종료합니다.
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
int account = 0;
int input = -1;
while(input != 0){
    System.out.println("메뉴: ");
    System.out.println("1.입금");
    System.out.println("2.출금");
    System.out.println("3.조회");
    System.out.println("0.종료");
    try {
        input = Integer.parseInt(sc.nextLine());
    } catch(Exception e){
        System.out.println("잘못 입력 하였습니다.");
        continue;
    }
    switch(input){
        case 1:
            System.out.println("입금액을 입력하세요.");
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            if(input < 0){
                account += input;
            } else {
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            break;
        case 2:
            System.out.println("출금액을 입력하세요.");
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            if(input < 0){
                account -= input;
            } else {
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            break;
        case 3:
            System.out.println("현재 잔액은 " + account + "원 입니다.");
            break;
        case 0:
            System.out.println("프로그램 종료");
            break;
        default:
            System.out.println("잘못 입력 하였습니다.");
            break;
    }
}
```
3. 금액을 입력받아 천원, 오백원, 백원, 오십원, 십원 짜리 잔돈으로 거슬러주는 프로그램과 순서도을 구현해 보자. 
```
예제 금액을 1000으로 나눈 몫은 돈을 거슬러 주었을때
천원짜리 개수 이고 1000으로 나눈 나머지는 천원짜리로 환산하고 남은 잔돈이다. 10원 이하는 입력받지 않는다. 
최종 결과물은 다음과 같이 될 것이다. 
5820원을 잔돈으로 바꾸면 천원짜리 5개, 오백원짜리 1개, 백원짜리 3개, 오십원짜리 0개,십원짜리 2개
선언할 변수:change1000,change500,change100,change50,change10,moneyInput
출력값:p(“천원짜리 “+change1000+”개, 오백원짜리 “+change500+”개, 백원짜리”+
change100+”개, 오십원짜리 “+change50+”개, 십원짜리 “+change10개)
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
int moneyInput = Integer.parseInt(sc.nextLine());
int change1000 = moneyInput / 1000;
int change500 = (moneyInput % 1000) / 500;
int change100 = ((moneyInput % 1000) % 500) / 100;
int change50 = (((moneyInput % 1000) % 500) % 100) / 50;
int change10 = ((((moneyInput % 1000) % 500) % 100) % 50) / 100;

System.out.print("천원짜리" + change1000 + "개,");
System.out.print("오백원짜리" + change500 + "개,");
System.out.print("백원짜리" + change100 + "개,");
System.out.print("오십원짜리" + change50 + "개,");
System.out.println("십원짜리" + change10 + "개");
```
4. 실존하는 자판기와 동일하게 만들어 보자. 
```
문자열 변수를 처리하려면 int 가 아닌 String 자료형을 사용해서 선언해야 한다.
String 사용방법은 다음과 같다.
String str=“”; str=str+“사이다”; str=str+“콜라”;
System.out.println(str);
String 변수 str를 출력하면 사이다콜라가 출력된다.
```
```
메뉴:
남은돈 0원.
1.사이다 700 2.콜라 500 3.환타 350 4.100투입 5.500투입 6.반환
음료반환구에 사이다 콜라 가 있음
메뉴를 보여주고 사용자가 선택을 하면 선택 사항을 반영하여 선택후 항상 메뉴를 보여
준다.
시나리오 :
천원짜리 세장 넣고 사이다1개 콜라2개 환타1개 를 구매한다.
최종 출력값:
사이다 콜라 콜라 환타 천원짜리 0개 오백원짜리 1개 백원짜리 4개 오십원 1개
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
int money = 0;
int input = 0;
String drinks = "";

while(input != 7){
    System.out.println("남은돈" + money + "원");
    System.out.println("1.사이다 700");
    System.out.println("2.콜라 500");
    System.out.println("3.환타 350");
    System.out.println("4.100투입");
    System.out.println("5.500투입");
    System.out.println("6.반환");
    System.out.println("7.종료");
    try {
        input = Integer.parseInt(sc.nextLine());
    } catch(Exception e){
        System.out.println("잘못 입력 하였습니다.");
        continue;
    }
    switch(input){
        case 1:
            if(money >= 700){
                money -= 700;
                drinks += "사이다 ";
                System.out.println("사이다를 구매했습니다.");
            } else {
                System.out.println("투입한 금액이 부족합니다.");
            }
            break;
        case 2:
            if(money >= 500){
                money -= 500;
                drinks += "콜라 ";
                System.out.println("콜라를 구매했습니다.");
            } else {
                System.out.println("투입한 금액이 부족합니다.");
            }
            break;
        case 3:
            if(money >= 350){
                money -= 350;
                drinks += "환타 ";
                System.out.println("환타를 구매했습니다.");
            } else {
                System.out.println("투입한 금액이 부족합니다.");
            }
            break;
        case 4:
            money += 100;
            System.out.println("100원 투입");
            break;
        case 5:
            money += 500;
            System.out.println("500원 투입");
            break;
        case 6:
            System.out.print(drinks);
            int change1000 = money / 1000;
            int change500 = (money % 1000) / 500;
            int change100 = ((money % 1000) % 500) / 100;
            int change50 = (((money % 1000) % 500) % 100) / 50;
            int change10 = ((((money % 1000) % 500) % 100) % 50) / 10;
            money = 0;
            System.out.println("천원짜리" + change1000 + "개");
            System.out.println("오백원짜리" + change500 + "개");
            System.out.println("백원짜리" + change100 + "개");
            System.out.println("오십원짜리" + change50 + "개");
            System.out.println("십원짜리" + change10 + "개");
            break;
        case 7:
            System.out.println("자판기를 종료합니다.");
        default:
            System.out.println("잘못 입력 하였습니다.");
            break;
    }
}
```
5. 369게임 해답지를 만들어 보자.
```
1부터 순서대로 숫자를 출력 하다가 숫자에 3,6,9중에 하나라도 들어가면 박수를 치면 된다.
1,2,짝,4,5,짝,7,8,짝,10,11,12,짝,14.....
그런데 만약 33, 36같이 두개가 들어가면 박수를 두번 친다.
27,28,짝(29),짝(30),짝(31),짝(32),짝짝(33)
1000이하의 정답지를 출력하는 프로그램을 만들어 보자.
```
```java
for(int i = 1;i <= 1000;i++){
    boolean hundred = (i / 100) % 3 == 0 && (i % 1000) / 100 > 0;
    boolean ten = ((i % 100) / 10) % 3 == 0 && (i % 100) / 10 > 0;
    boolean one = (i % 10) % 3 == 0 && i % 10 > 0;
    if(hundred){
        System.out.print("짝");
    }
    if(ten){
        System.out.print("짝");
    }
    if(one){
        System.out.print("짝");
    }
    if(hundred || ten || one){
        System.out.print("(" + i + "),");
    } else {
        System.out.print(i + ",");
    }
}
```
6. 랜덤하게 덧셈, 뺄셈, 곱셈, 나눗셈 문제를 내서 사용자가 맞추는 프로그램을 구현해 보자. 
레벨이 4단계로 되어 있어 처음에는 더하기 문제만 나오다가 레벨이 업되면 뺄셈,곱셈,나눗셈을 차례대로 추가하여 문제가 나오도록 해보자. 
2자리 이하 정수 계산만 하자.
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
while(true){
    Random r = new Random();
    int sign_a = r.nextInt(2);
    int sign_b = r.nextInt(2);
    int input = 0;
    int a = r.nextInt(100);
    int b = r.nextInt(100);
    int result = 0;
    int op = r.nextInt(4);
    int level = 0;
    String ops = "";
    switch(op){
        case 2:
            ops = "*";
            result = ((sign_a == 0 ? -1 : 1) * a) * ((sign_b == 0 ? -1 : 1) * b);
            if(level > 100){
                break;
            }
        case 0:
            ops = "+";
            result = ((sign_a == 0 ? -1 : 1) * a) + ((sign_b == 0 ? -1 : 1) * b);
            break;
        case 3:
            ops = "/";
            result = ((sign_a == 0 ? -1 : 1) * a) / ((sign_b == 0 ? -1 : 1) * b);
            if(level > 100){
                break;
            }
        case 1:
            ops = "-";
            result = ((sign_a == 0 ? -1 : 1) * a) - ((sign_b == 0 ? -1 : 1) * b);
            break;
    }
    System.out.println(a + ops + b);
    input = Integer.parseInt(sc.nextLine());
    if(input == result){
        System.out.println("맞았습니다.");
        level++;
    } else {
        System.out.println("틀렸습니다.");
        level--;
    }
}
```
![image](../../images/image33.png)
7. 상위 표를 이용해서 요금 계산하는 프로그램을 구현해보자. 
```
“1.대인 2.청소년 3.소인/경로 4.종료” 와 같은 메인 메뉴에서 구매하는 형태로 만들어 보자.
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
int input = 0;
while(input != 4){
    System.out.println("1.대인 2.청소년 3.소인/경로 4.종료");
    input = Integer.parseInt(sc.nextLine());
    switch(input){
        case 1:
            System.out.println("이용권을 선택하여 주십시오.");
            System.out.println("1.주간권(1일권) 2.오후권(오후3시~) 3.윈터야간권 4.2일권 5.뒤로가기");
            input = Integer.parseInt(sc.nextLine());
            switch(input){
                case 1:
                    System.out.println("46000원");
                    break;
                case 2:
                    System.out.println("38000원");
                    break
                case 3:
                    System.out.println("20000원");
                    break;
                case 4:
                    System.out.println("74000원");
                    break;
            }
            break;
        case 2:
            System.out.println("이용권을 선택하여 주십시오.");
            System.out.println("1.주간권(1일권) 2.오후권(오후3시~) 3.윈터야간권 4.2일권 5.뒤로가기");
            input = Integer.parseInt(sc.nextLine());
            switch(input){
                case 1:
                    System.out.println("39000원");
                    break;
                case 2:
                    System.out.println("32000원");
                    break
                case 3:
                    System.out.println("17000원");
                    break;
                case 4:
                    System.out.println("62000원");
                    break;
            }
            break;
        case 3:
            System.out.println("이용권을 선택하여 주십시오.");
            System.out.println("1.주간권(1일권) 2.오후권(오후3시~) 3.윈터야간권 4.2일권 5.뒤로가기");
            input = Integer.parseInt(sc.nextLine());
            switch(input){
                case 1:
                    System.out.println("36000원");
                    break;
                case 2:
                    System.out.println("29000원");
                    break
                case 3:
                    System.out.println("16000원");
                    break;
                case 4:
                    System.out.println("58000원");
                    break;
            }
            break;
    }
}
```
8. 컴퓨터가 임의로 정한 하나의 숫자를 맞추는 프로그램을 만들어 보자. 
```
사용자가 입력한 숫자가 임의의 숫자랑 같지 않다면 사용자가 숫자를 맞출 수 있도록 큰지 작은지 힌트를 줘서 사용자가 맞출수 있도록 해준다. 
정답을 맞추면 정답을 맞췄다는 메시지와 함께 총 몇회 도전끝에 맞췄는지 출력해 보자.
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
int answer = Math.random(100);
int count = 0;
int input = -1;
while(answer != input){
    input = Integer.parseInt(sc.nextLine());
    if(input == answer){
        System.out.println(count + 1 + "번 도전 하여 맞췄습니다.");
    }
    if(input > answer){
        System.out.println(input + "보다 작습니다.");
    }
    if(input > answer){
        System.out.println(input + "보다 큽니다.");
    }
}
```
9. 문제1에서 구현한 은행 프로그램을 배열을 이용해서 100명의 사용자 계정을 관리하는 프로그램으로 업그레이드 해보자.
```
메뉴 변경 : “메뉴: 1.입금 2.출금 3.조회 0.종료”
와 같은 기존 메뉴에서 다음과 같은 메뉴로 변경해서 구현해 보자. 
“메뉴: 1.입금 2.출금 3.조회 4.0부터99사이의 숫자를 입력받아 작업계정 선택 5. 전체 계정 출력 0.종료”
계정저장 : 한명만 저장하던 int account = 0;에서 100명을 저장 할 수 있는 배열 형태로 변경한다. 
double account[] = new double[100];
현재 작업중인 계정 인덱스 저장을 위해서 int nowUserIndex=0; 를 선언한다. 
작업할 사용자 인덱스로 사용된다.
```
```java
java.util.Scanner sc = new java.util.Scanner(System.in);
int account[] = new int[100];
int currentIndex = -1;
for(int i = 0;i < 100;i++){
    account[i] = 0;
}
int input = -1;
while(input != 0){
    System.out.println("메뉴: 1.입금 2.출금 3.조회 4.(0~99)작업계정 선택 5. 전체 계정 출력 0.종료");
    try {
        input = Integer.parseInt(sc.nextLine());
    } catch(Exception e){
        System.out.println("잘못 입력 하였습니다.");
        continue;
    }
    switch(input){
        case 1:
            if(currentIndex < 0 || currentIndex > 99){
                System.out.println("잘못된 작업계정");
                continue;
            }
            System.out.println("입금액을 입력하세요.");
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            if(input < 0){
                account += input;
            } else {
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            input = -1;
            break;
        case 2:
            if(currentIndex < 0 || currentIndex > 99){
                System.out.println("잘못된 작업계정");
                continue;
            }
            System.out.println("출금액을 입력하세요.");
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            if(input < 0){
                account -= input;
            } else {
                System.out.println("잘못 입력 하였습니다.");
                continue;
            }
            input = -1;
            break;
        case 3:
            if(currentIndex < 0 || currentIndex > 99){
                System.out.println("잘못된 작업계정");
                continue;
            }
            System.out.println("현재 잔액은 " + account[currentIndex] + "원 입니다.");
            break;
        case 4:
            System.out.println("작업 계정을 입력해주세요");
            currentIndex = Integer.parseInt(sc.nextLine());
            if(currentIndex < 0 || currentIndex > 99){
                System.out.println("잘못된 작업계정");
                continue;
            }
            break;
        case 5:
            for(int i = 0;i < account.length;i++){
                System.out.println(i + "번 계정: " + account[i] + "원");
            }
        case 0:
            System.out.println("프로그램 종료");
            break;
        default:
            System.out.println("잘못 입력 하였습니다.");
            break;
    }
}
```
