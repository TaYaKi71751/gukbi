package com.human.ex;

import java.util.ArrayList;

import com.human.dto.CustomerDto;
import com.human.model.Model;
import com.human.service.CustomerService;
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
		CustomerService customerService=new CustomerService();
		ViewInterface view=null;
		
		int input=0;
		
		while(input!=5) {
			Model model=new Model();
			
			view=new MainMenuView();
			view.execute(model);
			
			input=(int)model.getAttribute("input");
			switch(input) {
			case 1:
				ArrayList<CustomerDto> resultDtos= customerService.select();
				model=new Model();
				model.setAttribute("resultDtos", resultDtos);
				view=new SelectResultView();
				view.execute(model);
				break;
			
			case 2:
				model=new Model();
				
				view=new InsertInputView();
				view.execute(model);
			
				customerService.insert((CustomerDto)model.getAttribute("dto"));
				break;
			
			case 3:
				model=new Model();
				
				view=new UpdateInputView();
				view.execute(model);
				
				customerService.update((String)model.getAttribute("updatename"), (int)model.getAttribute("updateid"));
				break;
				
			case 4:
				model=new Model();
				
				view=new DeleteInputView();
				view.execute(model);
			
				customerService.delete((int)model.getAttribute("id"));
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
