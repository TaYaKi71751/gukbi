- 부모 클래스 에 자식 클래스를 넣을 수 있다.
- 자식 클래스 에 부모 클래스를 넣을 수 없다.
```
class Animal {}
class Cat extends Animal{}
public class Main{
    public static void main(String[] args){
        Animal a1 = new Cat(); // 가능
        Cat a2 = new Animal(); // 불가능 Type mismatch: cannot convert from Animal to Cat
    }
}
```
