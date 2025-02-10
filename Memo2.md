# extends
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
# Abstract
- 추상(abstract) 클래스는 new 로 오브젝트 생성이 불가 하다.
- 추상(abstract) 메소드는 선언 구현부가 없다.
- 추상클래스,메소드는 앞에 abstract를 붙인다.
- 추상메소드는 구현부가 없는 메소드다.
- 추상클래스는 추상 메소드를 포함한 클래스이다.
- 추상 클래스는 자체클래스를 생성할 수 없다.
- 부모 클래스를 생성하고 싶으면 자식을 통해서 추상 메소드를 재정의 한 다음 실행한다.

# Interface
```
interface Product {
    public void getPrice();
}
class TV implements Product {
    @Override
    public void getPrice(){
        System.out.println("TV가격5십만뤈");
    }
}
class Computer implements Product {
    @Override
    public void getPrice(){
        System.out.println("컴퓨터가격6십만원");
    }
}
```
- Interface 의 용도 및 역할
> - 설계용
> - 다중상속
> - 다형성
- Interface 란 추상 메소드로만 이루어진 클래스 라고 볼 수 있다.
- Interface 는 상속시 `implements` 사용
- Interface 의 모든 메소드를 반드시 재정의 해야 자식 객체로 생성 할 수 있다.

# Difference of abstract and interface (Use of ChatGPT)
Java에서 **추상 클래스 (Abstract Class)**와 **인터페이스 (Interface)**는 모두 추상화(abstraction)를 달성하기 위해 사용되지만, 몇 가지 중요한 차이점이 있습니다:

### 1. **목적 (Purpose)**:
   - **추상 클래스**: 기본 구현을 제공하면서, 일부 메서드는 서브클래스가 구현하도록 강제할 때 사용됩니다.
   - **인터페이스**: 구현 없이 메서드 서명만 정의하여 특정 기능을 클래스가 구현하도록 강제할 때 사용됩니다.

### 2. **메서드 구현 (Method Implementation)**:
   - **추상 클래스**: 추상 메서드(구현 없이 선언된 메서드)와 구체적인 메서드(몸체가 있는 메서드)를 모두 가질 수 있습니다.
   - **인터페이스**: 기본적으로 모든 메서드는 추상 메서드입니다. Java 8부터는 `default` 메서드(구현이 있는 메서드)와 `static` 메서드도 허용됩니다.

### 3. **다중 상속 (Multiple Inheritance)**:
   - **추상 클래스**: 하나의 추상 클래스만 상속할 수 있습니다. (단일 상속)
   - **인터페이스**: 여러 개의 인터페이스를 구현할 수 있습니다. (다중 상속)

### 4. **생성자 (Constructors)**:
   - **추상 클래스**: 생성자를 가질 수 있습니다.
   - **인터페이스**: 생성자를 가질 수 없습니다.

### 5. **필드 (Fields)**:
   - **추상 클래스**: 인스턴스 변수와 상수를 가질 수 있습니다.
   - **인터페이스**: 필드는 `public static final` 상수만 가질 수 있으며, 인스턴스 변수는 가질 수 없습니다.

### 6. **접근 제한자 (Access Modifiers)**:
   - **추상 클래스**: 다양한 접근 제한자(public, private, protected)를 사용할 수 있습니다.
   - **인터페이스**: 모든 메서드는 기본적으로 `public`이며, 필드는 `public static final`로 정의됩니다.

### 7. **사용 사례 (Use Case)**:
   - **추상 클래스**: 공통적인 기능을 제공하면서 일부 메서드는 서브클래스에서 구현할 때 사용합니다. 단일 상속을 통해 구조화합니다.
   - **인터페이스**: 다양한 클래스에서 공통된 기능을 구현하도록 할 때 사용합니다. 다중 상속을 통해 기능을 공유합니다.

### 예시:

#### 추상 클래스:
```java
abstract class Animal {
    abstract void sound();
    
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}
```

#### 인터페이스:
```java
interface Animal {
    void sound();
    
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}
```

### 요약:
- **추상 클래스**: 기본 구현을 제공하며 일부는 서브클래스에서 구현하도록 강제합니다.
- **인터페이스**: 구현 없이 메서드 서명만 정의하고, 클래스를 다중 상속할 수 있도록 합니다. (Java 8 이후 `default` 메서드를 사용할 수 있습니다.)
