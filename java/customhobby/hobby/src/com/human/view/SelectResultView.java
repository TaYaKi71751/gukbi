package com.human.view;

import java.util.ArrayList;

import com.human.dto.HobbyDto;
import com.human.model.Model;

public class SelectResultView implements ViewInterface {
	@Override
	public void execute(Model model) {
		System.out.println("------------------------------------------");
		for (HobbyDto dto : (ArrayList<HobbyDto>)model.getAttribute("resultDtos")) {
			
			System.out.println(dto);
		}
	}
}
