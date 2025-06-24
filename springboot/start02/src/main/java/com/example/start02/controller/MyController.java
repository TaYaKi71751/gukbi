package com.example.start02.controller;
import com.example.start02.dto.HumanDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//제어 속성
//        조건 제어 속성
//        th:if - if문에 해당하는 속성(else는 없음)
//        th:unless - if문의 반대에 해당하는 속성. 조건식을 th:if와 똑같이 작성하면 else문의 역할을 수행
//        th:switch, th:case - switch, case에 해당하는 속성//
@Controller
@Slf4j  //로그용 라이브러리
public class MyController {
    @GetMapping("/01model")
    public String model1(Model model){
        return "01model";
    }

    //ModelAndView사용하기
    @GetMapping("/02model")
    public ModelAndView model2(){
        log.info("02model");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("key","value=model2");
        modelAndView.setViewName("02model");
        return modelAndView;
    }

    //03model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("03model")
    public String model3(
            @RequestParam("name") String name,
            @RequestParam("age") long age, // `long` 타입으로 수정
            @RequestParam("height") double height, // 추가된 필드
            @RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
            LocalDateTime birthday,
            Model model) {
        log.info("03model");
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("height : " + height);
        System.out.println("birthday : " + birthday);

        return "03model";
    }



    //04model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("04model")
    public String model4(@ModelAttribute HumanDto humanDto, Model model) {
        log.info("04model");
        System.out.println("name : " + humanDto.getName());
        System.out.println("age : " + humanDto.getAge());
        System.out.println("height : " + humanDto.getHeight());
        System.out.println("birthday : " + humanDto.getBirthday());

        return "04model";
    }

    //05model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("05model")
    public String model5(@ModelAttribute HumanDto humanDto, Model model) {
        log.info("05model");


        // 기존 Map 생성 및 데이터 추가
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "홍길동");
        map.put("key2", "21");
        map.put("key3", "대전");

        // HumanDto 객체를 key4로 추가
        map.put("key4", humanDto);

        // Map을 Model에 추가
        model.addAttribute("mapdata", map);

        return "05model";
    }

    @GetMapping("/06model")
    public String model6(Model model){
        List<HumanDto> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            HumanDto dto=new HumanDto();
            dto.setName("이름"+i);
            dto.setAge(25+i);
            dto.setHeight(179+i);
            dto.setBirthday(LocalDateTime.of(1993,7,21,10,30).plusYears(i));
            list.add(dto);
        }
        model.addAttribute("list",list);
        return "06model";
    }

    /*
th:text="{$tagStr}"   문자열에 html이 포함되어 있으면 그대로 문자열 출력   innerText로 출력 [[${식별자}]]
th:utext="{$tagStr}"  문자열에 html이 포함되어 있으면 렌더링됨       innerHTML로 출력 [(${식별자})]

<script th:inline="javascript"> 자바스크립트  태그를 사용할 때 다음을 이용한다.

 */
    @GetMapping("/07model")
    public String model7(Model model){
        log.info("여러가지 문자열 출력");
        model.addAttribute("msgStr","success");
        model.addAttribute("tagStr","<h1>tag</h1>");
        return "07model";
    }
    @GetMapping("/08model")
    public String model8(Model model){
        log.info("다양한 제어문");
        model.addAttribute("name","홍길동");
        model.addAttribute("age",20);

        List<HumanDto> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            HumanDto dto=new HumanDto();
            dto.setName("이름"+i);
            dto.setAge(25+i);
            dto.setHeight(179+i);
            dto.setBirthday(LocalDateTime.of(1993,7,21,10,30).plusYears(i));
            list.add(dto);
        }
        model.addAttribute("list",list);
        return "08model";
    }

    @GetMapping("09model")
    public String model9(){
        return "09model";
    }

//
//    @GetMapping("/")
//    public String hello(Model model) {
//        return "01start";
//    }
//
//    @GetMapping("model1")
//    public String intro(Model model){
//        log.info("model1");
//        model.addAttribute("key","value=02model1");
//        return "02model";
//    }
//
//    @GetMapping("model2")
//    public ModelAndView intro() {
//        log.info("model2");
//        // ModelAndView 객체 생성
//        ModelAndView modelAndView = new ModelAndView();
//        // 모델에 데이터 추가
//        modelAndView.addObject("key", "value=model2");
//        // 뷰 이름 설정
//        modelAndView.setViewName("02model");
//        return modelAndView;
//    }
//
//    @GetMapping("model3")
//    public String thymeleafOutput(Model model) {
//
////        Map 데이터
////        java 코드에서 Map을 사용하여 데이터를 전송
////        map.put("data1", data);
////        model.addAttribute("식별자", map);
////        <p th:text="${식별자.data1}"></p>
//
//        // map 데이터 (묶음 데이터)
//        Map<String, String> rmap = new HashMap<>();
//        rmap.put("key1", "홍길동");
//        rmap.put("key2", "21");
//        rmap.put("key3", "대전");
//
//        model.addAttribute("mapdata", rmap);
//
//        // HumanDto 데이터
//        HumanDto humanDto = new HumanDto();
//        humanDto.setName("아무개");
//        humanDto.setAge(30L);  // long 타입
//        humanDto.setHeight(180.5);
//        humanDto.setBirthday(LocalDateTime.of(1993, 7, 21, 10, 30));
//
//        model.addAttribute("humanDto", humanDto);
//
//        // javascript 출력용 데이터
//        model.addAttribute("message", "success");
//
////        데이터 출력
////        innerText로 출력
////        th:text : html 시작태그 내에 사용
////                [[${식별자}]] : 시작태그와 종료태그 사이에서 사용
////        innerHTML로 출력
////        th:utext - html 시작태그 내에 사용
////                [(${식별자})] : 시작태그와 종료태그 사이에서 사용
//
//        // tag 데이터
//        model.addAttribute("titleStr", "<h1>제목</h1>");
//        return "03model"; // t_output이라는 이름의 뷰를 반환
//    }
//
//    @GetMapping("model4")
//    public String thymeleafControl(Model model) {
//        model.addAttribute("title", "이 문자열은 제목");
//        model.addAttribute("age", 20);
//
//        List<HumanDto> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            HumanDto dto = new HumanDto();
//            dto.setName("이름" + i);
//            dto.setAge(25 + i);
//            dto.setHeight(170 + i);
//            dto.setBirthday(LocalDateTime.of(1993, 7, 21, 10, 30).plusYears(i)); // 예제용 생일 설정
//            list.add(dto);
//        }
//        model.addAttribute("list", list);
//
//        return "04model"; // t_control이라는 이름의 뷰를 반환
//    }
////http://localhost:8080/model5?name=홍길동&age=30&height=175.5&birthday=1993-07-21T10:30
//    @GetMapping("model5")
//    public String noneDtoSend(@RequestParam("name") String name,
//                              @RequestParam("age") long age, // `long` 타입으로 수정
//                              @RequestParam("height") double height, // 추가된 필드
//                              @RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//                                  LocalDateTime birthday,
//                              Model model) {
//
//
//
//        model.addAttribute("birthday", birthday);
//        System.out.println("name : " + name);
//        System.out.println("age : " + age);
//        System.out.println("height : " + height);
//        System.out.println("birthday : " + birthday);
//
//        model.addAttribute("result", "none dto send OK");
//        return "05model";
//    }
//    //http://localhost:8080/model6?name=홍길동&age=30&height=175.5&birthday=1993-07-21T10:30
//
//    @GetMapping("model6")
//    public String dtoSend(@ModelAttribute HumanDto humanDto, Model model) {
//        System.out.println("name : " + humanDto.getName());
//        System.out.println("age : " + humanDto.getAge());
//        System.out.println("height : " + humanDto.getHeight());
//        System.out.println("birthday : " + humanDto.getBirthday());
//
//        model.addAttribute("result", "dto send OK");
//        return "06model";
//    }
//
//    @GetMapping("control7")
//    public String thymeleafContro(Model model) {
//        // 데이터를 모델에 추가
//        model.addAttribute("str", "control1");
//        model.addAttribute("age", 20);
//
//        List<HumanDto> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            HumanDto human = new HumanDto();
//            human.setName("이름" + i);
//            human.setAge(25 + i);
//            human.setHeight(170.0 + i); // height 추가
//            human.setBirthday(LocalDateTime.of(1993, 7, 21, 10, 30).plusYears(i)); // 생일 설정
//            list.add(human);
//        }
//
//        // 리스트 데이터를 모델에 추가
//        model.addAttribute("list", list);
//
//        // 뷰 이름 반환
//        return "07control";
//    }

//    표현식 기호
//    ${식별자} : 일반적인 글자 데이터 출력(SpringEL)
//    @{link} : a 태그의 href 속성이나 form 태그의 action 속성에서 uri 처리
//*{field} : server에서 dto 객체 형태로 전송할 때, dto 객체의 필드를 출력
//    먼저 상위 요소에서 th:object로 객체를 지정
//    자바스크립트에서의 출력(html의 content에 직접 출력할 때도 사용)
//            [[${식별자}]]


    //사용자 입력을 받아 처리하는 프로그램을 구현해 보자.
}