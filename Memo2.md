- 부모 클래스 에 자식 클래스를 넣을 수 있다.
- 자식 클래스 에 부모 클래스를 넣을 수 없다.
```
package com.the.ex;

class Animal {
    public void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("고양이가 생선을 먹습니다.");
    }
}
public class Main{
    public static void main(String[] args){
        Animal a1 = new Cat(); // 가능
        Cat a2 = new Animal(); // 불가능 Type mismatch: cannot convert from Animal to Cat
        a1.makeSound(); // 가능
        a1.eat(); // 불가능 The method eat() is undefined for the type Animal
        ((Cat)a1).eat(); // 가능
		System.out.println(a1.getClass()); // class com.the.ex.Cat
        System.out.println(a1 instanceof Animal); // true
        System.out.println(a1 instanceof Cat); // true
        System.out.println(a1.getClass() == Animal.class); // false
        System.out.println(a1.getClass() == Cat.class); // true
    }
}
```
