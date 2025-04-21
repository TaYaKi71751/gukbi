package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class UpdateInputView implements ViewInterface {
	@Override
	public void execute(Model model) {
		System.out.println("------------------------------------------");
		String updatename = UserInput.inputString("수정할 이름 입력");
		int updateid = UserInput.inputInt("수정할 id 입력");
		model.setAttribute("updateid", updateid);
		model.setAttribute("updatename", updatename);
	}
}
