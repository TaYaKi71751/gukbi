package com.human.ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.human.dto.HumanDto;
import com.human.service.HumanService;

@RestController
@RequestMapping("/rest")
public class HumanController {
	@Autowired
	private HumanService rm; /* reply 비즈니스 로직 처리하려 주입 */

	// rest/all로 요청하면 모든 Human 테이블의 데이터를 리턴해주는 프로그램 구현
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<HumanDto>> selectAll() {
		ResponseEntity<ArrayList<HumanDto>> entity = null;

		try {
			entity = new ResponseEntity<>(rm.selectAll(), HttpStatus.OK); /* httpStatus 는 상태정보 */
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/all/{name}", method = RequestMethod.GET)
	public ResponseEntity<HumanDto> selectName(@PathVariable("name") String name) {
		ResponseEntity<HumanDto> entity = null;

		try {

			entity = new ResponseEntity<>(rm.selectName(name), HttpStatus.OK); /* httpStatus 는 상태정보 */

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody HumanDto dto) {

		ResponseEntity<String> entity = null;
		try {
			rm.insert(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{name}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("name") String name, @RequestBody HumanDto vo) {

		ResponseEntity<String> entity = null;
		try {
			vo.setName(name);
			rm.update(vo);

			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("name") String name) {

		ResponseEntity<String> entity = null;
		try {
			rm.delete(name);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}