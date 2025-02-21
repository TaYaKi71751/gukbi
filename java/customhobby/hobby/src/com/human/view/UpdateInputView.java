package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class UpdateInputView implements ViewInterface {
	@Override
	public void execute(Model model) {
		System.out.println("------------------------------------------");
		int id = UserInput.inputInt("수정할 id 입력");
		String upHobby = UserInput.inputString("수정할 Hobby 입력");
		model.setAttribute("id", id);
		model.setAttribute("upHobby", upHobby);
	}
}
