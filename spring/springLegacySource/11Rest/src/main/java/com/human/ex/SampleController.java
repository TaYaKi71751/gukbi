package com.human.ex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.human.dto.HumanDto;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	  @RequestMapping("/hello")
	  public String sayHello() {
	    return "Hello World ";
	  }
	  
	  @RequestMapping("/humanDto")
	  public HumanDto sendHumanDto() {
		  HumanDto dto=new HumanDto();
		  
		  dto.setName("홍길동");
		  dto.setAge(18);
		  dto.setHeight(159.4);
		  dto.setBirthday(LocalDateTime.now());
		  
		  return dto;		  
	  }
	  @RequestMapping("/sendList")
	  public List<HumanDto> sendList() {
		  List<HumanDto> list = new ArrayList<HumanDto>();
		  for( int i=0;i<5;i++) {
			  HumanDto dto=new HumanDto();
			  dto.setName("홍길동"+i);
			  dto.setAge(18+i);
			  dto.setHeight(159.4);
			  dto.setBirthday(null);
			  list.add(dto);			  
		  }
		  return list;
	  }

	  
	  @RequestMapping("/sendMap")
	  public Map<Integer, HumanDto> sendMap() {

	    Map<Integer, HumanDto> map = new HashMap<Integer, HumanDto>();

	    for (int i = 0; i < 10; i++) {
	    	  HumanDto dto=new HumanDto();
			  dto.setName("홍길동"+i);
			  dto.setAge(18+i);
			  dto.setHeight(159.4);
			  dto.setBirthday(null);
			  map.put(i, dto);
	    }
	    return map;
	  }

	  @RequestMapping("/sendErrorAuth")
	  public ResponseEntity<Void> sendListAuth() {
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }	  
	  
	  @RequestMapping("/sendErrorNot")
	  public ResponseEntity<List<HumanDto>> sendListNot() {
		  List<HumanDto> list = new ArrayList<>();
		  for( int i=0;i<5;i++) {
			  HumanDto dto=new HumanDto();
			  dto.setName("홍길동"+i);
			  dto.setAge(18+i);
			  dto.setHeight(159.4);
			  dto.setBirthday(null);
			  list.add(dto);			  
		  }

	    return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	  }

	  
	  
}



