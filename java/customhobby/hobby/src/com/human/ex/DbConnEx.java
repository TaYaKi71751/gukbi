package com.human.ex;

import java.util.ArrayList;

import com.human.dto.HobbyDto;
import com.human.model.Model;
import com.human.service.HobbyService;
import com.human.view.DeleteInputView;
import com.human.view.ErrorOutputView;
import com.human.view.ExitOutputView;
import com.human.view.InsertInputView;
import com.human.view.MainMenuView;
import com.human.view.SelectResultView;
import com.human.view.UpdateInputView;
import com.human.view.ViewInterface;

public class DbConnEx {

	public static void main(String[] args) throws Exception {
		HobbyService hobbyService=new HobbyService();
		ViewInterface view=null;
		
		int input=0;
		
		while(input!=5) {
			Model model=new Model();
			
			view=new MainMenuView();
			view.execute(model);
			
			input=(int)model.getAttribute("input");
			switch(input) {
			case 1:
				ArrayList<HobbyDto> resultDtos= hobbyService.select();
				model=new Model();
				model.setAttribute("resultDtos", resultDtos);
				view=new SelectResultView();
				view.execute(model);
				break;
			
			case 2:
				model=new Model();
				
				view=new InsertInputView();
				view.execute(model);
			
				hobbyService.insert((HobbyDto)model.getAttribute("dto"));
				break;
			
			case 3:
				model=new Model();
				
				view=new UpdateInputView();
				view.execute(model);
				
				hobbyService.update((String)model.getAttribute("upHobby"), (int)model.getAttribute("id"));
				break;
				
			case 4:
				model=new Model();
				
				view=new DeleteInputView();
				view.execute(model);
			
				hobbyService.delete((int)model.getAttribute("id"));
				break;
				
			case 5:
				model=new Model();
				
				view=new ExitOutputView();
				view.execute(model);
				
				input=(int)model.getAttribute("input");
				break;
				
			default:
				model=new Model();
					
				view=new ErrorOutputView();
				view.execute(model);
				break;
				
			}
	
		}

	}

}
