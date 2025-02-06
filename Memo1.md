- `Object` class는 기본적으로 모든 클래스의 최상위 클래스이다.
- `@Override` 는 상속된 메소드를 재정의 할 때 사용된다.
- `toString` 메소드는 문자열로 변환할 때 사용된다.
- `equals` 메소드는 같은지 확인할 때 사용된다.
- `Object` 에서 `equals` 메소드는 주소를 비교한다.
- `String` 에서 `equals` 메소드는 문자열 값을 비교한다.
```
String str1 = "홍길동";
String str2 = "홍길동";
String str3 = new String("홍길동");
String str4 = new String("홍길동");

System.out.println(str1 == str2);       //true
System.out.println(str1 == str3);       //false
System.out.println(str3 == str4);       //false

System.out.println(str1.equals(str2));  //true
System.out.println(str1.equals(str3));  //true
System.out.println(str3.equals(str4));  //true
```

- `ArrayList<Integer> arrList = new ArrayList<Integer>();` 으로 정수형 데이터를 저장할 ArrayList를 생성 할 수 있다.
- `arrList.add(2,9);` 2번 인덱스에 9를 삽입
- `arrList.set(3,10);` 3번 인덱스에 데이터를 10으로 변경
- `arrList.remove(2);` 2번 인덱스를 삭제
- `arrList.indexOf(9);` 9가 있는 인덱스를 찾음
- `Iterator<Integer> iterator = arrList.iterator();`
