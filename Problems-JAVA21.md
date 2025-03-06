[pdf](./pdf/JAVA240812simple148.pdf)
# 연습문제
1. 이전에 만든 Tree클래스에 나무의 주인 정보를 저장하는 Owner클래스를 만들어 
Tree클래스에 추가해 보고 메인 메소드가 포함되어 있는 TreeEx 클래스의 메인 메소드에서 데이터를 입력받아 출력해보자. 
```
힌트) Car,Tire클래스와 Tree,Owner클래스의 관계가 같으니 참고해서 만들어 보자. 
Owner클래스 필드 - 이름, 나이, 연락처
```
```java
class Owner {
    String name = "홍길동";
    int age = 23;
    String contact = "010-1234-5678";
}
class Tree {
    String name = "";
    int price = 0;
    int growthDuration = 0;
    int exp = 0;
    int currentTrees = 0;
    int maximumTrees = 0;
    Owner owner = new Owner();
}
class TreeEx {
    public static void main(String[] args){
        Tree tree = new Tree();
        System.out.println(
            "나무 이름:" + tree.name + "\n" + 
            "나무 가격:" + tree.price + "\n" + 
            "키우는데 걸리는 시간:" + tree.growthDuration + "\n" +
            "경험치:" + tree.exp + "\n" +
            "현재 심은 나무수:" + tree.currentTrees + "\n" +
            "최대 심을 수 있는 나무수:" + tree.maximumTrees + "\n" +
            "주인 이름:" + tree.owner.name + "\n" +
            "주인 나이:" + tree.owner.age + "\n" +
            "주인 연락처:" + tree.owner.contact + "\n"
        );
    }
}
```
