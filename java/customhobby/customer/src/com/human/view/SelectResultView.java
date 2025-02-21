package com.human.view;

import java.util.ArrayList;

import com.human.dto.CustomerDto;
import com.human.model.Model;

public class SelectResultView implements ViewInterface {
	@Override
	public void execute(Model model) {
		System.out.println("------------------------------------------");
		for (CustomerDto dto : (ArrayList<CustomerDto>)model.getAttribute("resultDtos")) {
			
			System.out.println(dto);
		}
	}
}
