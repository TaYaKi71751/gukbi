package com.human.view;

import com.human.dto.HobbyDto;
import com.human.model.Model;
import com.human.util.UserInput;

public class InsertInputView implements ViewInterface {
	@Override
	public void execute(Model model) {
		System.out.println("------------------------------------------");
		System.out.println("생성할 Hobby 데이터 입력");
		HobbyDto dto=new HobbyDto();
		dto.setId(UserInput.inputInt("id 입력"));
		dto.setHobby(UserInput.inputString("hobby 입력"));
		
		model.setAttribute("dto", dto);
	}
}
