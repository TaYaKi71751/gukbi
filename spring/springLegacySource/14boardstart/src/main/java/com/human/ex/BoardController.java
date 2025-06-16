package com.human.ex;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.human.dto.BoardDto;
import com.human.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService service;

  //���Ϲ��ڿ��� ������ ��û �ֻ簡 view��ΰ� �ȴ�.
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registerGET(BoardDto board, Model model) throws Exception {

    logger.info("register get ...........");
  }

  // @RequestMapping(value = "/register", method = RequestMethod.POST)
  // public String registPOST(BoardVO board, Model model) throws Exception {
  //
  // logger.info("regist post ...........");
  // logger.info(board.toString());
  //
  // service.regist(board);
  //
  // model.addAttribute("result", "success");
  //
  // //return "/board/success";
  // return "redirect:/board/listAll";
  // }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registPOST(BoardDto board, Model model,RedirectAttributes rttr) throws Exception {

    logger.info("regist post ...........");
    logger.info(board.toString());

    service.regist(board);
    
   rttr.addFlashAttribute("msg", "success");
    
   return "redirect:/board/listAll";
    
  }

  @RequestMapping(value = "/listAll", method = RequestMethod.GET)
  public void listAll(@RequestParam(value="bGroupKind", required = false)String bGrouopKind,Model model) throws Exception {
	
    logger.info(bGrouopKind);
    if(bGrouopKind==null) {
    	model.addAttribute("list", service.listAll());
    }else {
    	model.addAttribute("list", service.listMenu(bGrouopKind));
    }
    	model.addAttribute("category",service.menuKind());
  }

  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public void read(@RequestParam("bId") int bId, Model model) throws Exception {
	    logger.info("read......................"+bId);
    model.addAttribute(service.read(bId));//클래스가 BoardDto가 리턴되어서 key이름은 boardDto
    BoardDto board = service.read(bId);
    service.bHitUpdate(bId);
  }
//  @RequestMapping(value = "/bHitUpdate", method = RequestMethod.GET)
//  public void bHitUpdate(BoardDto dto, Model model) throws Exception {
//	    logger.info("bHitUpdate.................");
//    service.bHitUpdate(dto);
//    System.out.println(dto);
//  }
  @RequestMapping(value = "/bLike", method = RequestMethod.GET)
  public String bLike(@RequestParam("bId") int bId, Model model) throws Exception {
	    logger.info("bLike......................"+bId);
    service.bLike(bId);
    return "forward:/board/listAll";
  }
  @RequestMapping(value = "/bHitUpdate", method = RequestMethod.GET)
  public String bHitUpdate(@RequestParam("bId") int bId, RedirectAttributes rttr) throws Exception {
      service.bHitUpdate(bId);
      rttr.addFlashAttribute("msg", "success");
      return "redirect:/board/listAll";
  }
  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  public String remove(@RequestParam("bId") int bId, RedirectAttributes rttr) throws Exception {
    service.remove(bId);
    rttr.addFlashAttribute("msg", "success");
    return "redirect:/board/listAll";
  }

  @RequestMapping(value = "/modify", method = RequestMethod.GET)
  public void modifyGET(int bId, Model model) throws Exception {

    model.addAttribute(service.read(bId));
  }
  
  @RequestMapping(value = "/modify", method = RequestMethod.POST)
  public String modifyPOST(BoardDto board, RedirectAttributes rttr) throws Exception {

    logger.info("mod post............");

    service.modify(board);
    rttr.addFlashAttribute("msg", "success");

    return "redirect:/board/listAll";
  }
 
 
}
