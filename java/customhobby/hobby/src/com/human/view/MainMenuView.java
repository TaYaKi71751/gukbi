package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class MainMenuView implements ViewInterface {
	public void execute(Model model) {
		String strMainMenu = "~ Hobby 입력 프로그램 ~";
		strMainMenu += "| 1.Select | 2.Insert | 3.Update | 4.Delete | 5.Exit |";
		//strMainMenu += "번호를 입력하세요. : ";
		model.setAttribute("input",UserInput.inputInt(strMainMenu));
	}
}
