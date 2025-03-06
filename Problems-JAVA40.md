다음을 이용해서 관리형 프로그램을 작성해 보자.

//관리클래스
```java
class Human {
    private long id;
    private int age;
    private String name;
    private double height;
}
```

//메뉴   
```java
    System.out.println("\n=== Human 관리 시스템 ===");
    System.out.println("1. 추가");
    System.out.println("2. 목록 조회");
    System.out.println("3. ID로 개별 조회");
    System.out.println("4. ID로 삭제");
    System.out.println("5. 이름으로 조회");
    System.out.println("6. 이름으로 삭제");
    System.out.println("7. 종료");
    System.out.print("메뉴를 선택하세요: ");
```
//실행시
```
=== Human 관리 시스템 ===
1. 추가
2. 목록 조회
3. ID로 개별 조회
4. ID로 삭제
5. 이름으로 조회
6. 이름으로 삭제
7. 종료

메뉴를 선택하세요: 1
이름: 홍길동
나이: 30
키: 175.5
Human 추가 완료: Human{id=1, age=30, name='홍길동', height=175.5}
메뉴를 선택하세요: 2
=== 전체 목록 ===
Human{id=1, age=30, name='홍길동', height=175.5}
```

```java
class Human {
    private long id;
    private int age;
    private String name;
    private double height;

    public Human(){}
    public Human(int id, int age, String name, double height){
        this.id = id;
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public String toString(){
        return "Human{id=" + id + ", age=" + age + ", name=" + name + ", height=" + height + "}";
    }

    public static void printMenu(){
        System.out.println("=== Human 관리 시스템 ===");
        System.out.println("1. 추가");
        System.out.println("2. 목록 조회");
        System.out.println("3. ID로 개별 조회");
        System.out.println("4. ID로 삭제");
        System.out.println("5. 이름으로 조회");
        System.out.println("6. 이름으로 삭제");
        System.out.println("7. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    public static Human create(long id){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("이름: ");
        String name = sc.nextLine().trim();
        System.out.print("나이: ");
        int age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("키: ");
        double height = Double.parseDouble(sc.nextLine().trim());
        sc.close();
        return new Human(id,name,age,height);
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
}

public class Main{
    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.ArrayList<Human> humans = new java.util.ArrayList<Human>();
        int input = 0;
        while(input != 7) {
            Human.printMenu();
            input = Integer.parseInt(sc.nextLine().trim());
            switch(input){
                case 1:
                    humans.add(Human.create(humans.size() + 1));
                    break;
                case 2:
                    System.out.println("=== 전체 목록 ===");
                    for(Human h : humans){
                        System.out.println(h);
                    }
                    break;
                case 3:
                    System.out.print("id를 입력하여 주세요.");
                    long id = Long.parseLong(sc.nextLine().trim());
                    for(Human h : humans){
                        if(id == h.id){
                            System.out.println(h);
                        }
                    }
                    break;
                case 4:
                    System.out.print("삭제할 id를 입력하여 주세요.");
                    long id = Long.parseLong(sc.nextLine().trim());
                    for(int i = 0;i < humans.size();i++){
                        if(humans.get(i).id == id){
                            humans.remove(i);
                            i--;
                        }
                    }
                    break;
                case 5:
                    System.out.print("조회할 이름을 입력하여 주세요.");
                    String name = sc.nextLine().trim();
                    for(Human h : humans){
                        if(h.name.equals(name)){
                            System.out.println(h);
                        }
                    }
                    break;
                case 6:
                    System.out.print("삭제할 이름을 입력하여 주세요.");
                    String name = sc.nextLine().trim();
                    for(int i = 0;i < humans.size();i++){
                        if(humans.get(i).name.equals(name)){
                            humans.remove(i);
                            i--;
                        }
                    }
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못 입력 하셨습니다.");
            }
        }
        sc.close();
    }
}
```
