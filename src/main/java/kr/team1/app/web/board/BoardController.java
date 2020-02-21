package kr.team1.app.web.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.team1.app.web.index.UserBean;




@Controller
@RequestMapping("/")
public class BoardController {

	@Autowired private BoardService boardService;
	
	private int getBoardno ;

    @RequestMapping(value = "board", method = RequestMethod.GET)
    public String board(HttpSession session) {

        return "board";
    }
   
//	@RequestMapping(value = "board",method = RequestMethod.GET)
//	public @ResponseBody Map<String, Object> getPag(PaggingBean pb) {
//		System.out.println(pb);
//		return boardService.getPag(pb);
//	}
    
    @RequestMapping(value = "board/{no}", method = RequestMethod.GET)
    public String board2(@PathVariable("no") String pathNo ) {
    	try {
			int no = Integer.parseInt(pathNo) ;
//			System.out.println(no);
			 return "boardinfo";
		} catch (Exception e) {
//			e.printStackTrace();
			 return "redirect:/board";
		}
       
    }
    
    @RequestMapping(value = "boardinfosub/{no}", method = RequestMethod.POST)
	public String page22(Model model, @PathVariable("no") String pathNo ) {
    	try {
			int no = Integer.parseInt(pathNo) ;
//			System.out.println(no);
			
			Map<String, Object> resultMap =  boardService.getBoardList4(no);
//			System.out.println(resultMap);	
			if(resultMap.get("result4") != null)
			{
			model.addAttribute("result", resultMap);
			} else {
			return "page/blank";	
			}
		
			return "page/boardinfosub";
    	} catch (Exception e) {
//			e.printStackTrace();
			return "page/blank";
		}   		
		
    }
//    @RequestMapping(value = "board3", method = RequestMethod.GET)
//    public String board3(HttpSession session) {
//
//        return "board3";
//    }
    @RequestMapping(value = "board/up", method = RequestMethod.GET)
    public String board4(HttpSession session) {
    	UserBean ub = (UserBean) session.getAttribute("UserInfo");
    	if (ub != null) {
    		int role = Integer.parseInt(ub.getRole());
//        	System.out.println("role = " + role);
        	if (role > 1) {
                return "boardup";
        	}
        	return "redirect:/security/denied";
    	} else {
    		return "redirect:/logindiv";
    	}
    }

//	@RequestMapping(value = "joinSuccess", method = RequestMethod.GET)
//	public String joinSuccess(HttpSession session) {
//		return "joinSuccess";
//		}
	
    @RequestMapping(value = "boardsub1", method = RequestMethod.POST)
	public String page1(Model model) {
		model.addAttribute("result", boardService.getBoardList());
		return "page/boardsub1";
    }
    
    @RequestMapping(value = "boardsub2", method = RequestMethod.POST)
	public String page2(Model model) {
   		model.addAttribute("result", boardService.getBoardList2());
		return "page/boardsub2";
    }
    
    @RequestMapping(value = "boardsub3", method = RequestMethod.POST)
	public String page3() {
		return "page/boardsub3";
    }	
//	@RequestMapping(value = "board22", method = RequestMethod.POST)
//	public String page22(HttpSession session, int no) {
//		return "page/board22";}
	
    
    
//    @RequestMapping(value = "board4", method = RequestMethod.POST)
//	public String page4(Model model) {
//   		model.addAttribute("result", boardService.getBoardList4());
//		return "page/board4";
//    }
    @RequestMapping(value = "board/up2", method = RequestMethod.GET)
    public String boardup2(HttpSession session) {

        return "boardup2";
    }
    @RequestMapping(value = "getBoardData2", method = RequestMethod.POST)
 	public @ResponseBody Map<String, Object>  getBoardData(){
//    	System.out.println("ddd"+boardService.getBoardData(getBoardno));
		return boardService.getBoardData(getBoardno)	;
    }

    //넘기는 용도
    @RequestMapping(value ="getBoardData", method = RequestMethod.POST)
    public String getBoardData(@RequestBody Map <String, Integer> paraMap, HttpSession session) {
//    	System.out.println("DD"+paraMap);
    	getBoardno = paraMap.get("no");
    	session.setAttribute("no", getBoardno);
    	return "boardup2";
//    	return boardService.;
    }
    
    @RequestMapping(value = "getData", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getData() {
		return boardService.getData();
    }
	@RequestMapping(value = "setBoard", method = RequestMethod.POST)
	public @ResponseBody int setBoard(@RequestParam HashMap<String, String> map){
		return boardService.setBoard(map);
	}
		
	@RequestMapping(value = "upBoard", method = RequestMethod.POST)
	public @ResponseBody int upBoard(@RequestParam HashMap<String, String> map){
		System.out.println(map);
		return boardService.upBoard(map);

	}@RequestMapping(value = "delBoard", method = RequestMethod.POST)
	public @ResponseBody int delBoard(@RequestParam("no") int no) {
		return boardService.delBoard(no);
	}

//}
    @PostMapping("/board/{type:.+}/{position:.+}")
	public @ResponseBody Map<String, Object> getBoardList3(@PathVariable("type") String type, @PathVariable("position") int position, HttpSession sqlsession,  HttpServletRequest req) {
		return boardService.getBoardList3(type, position, sqlsession, req);
	}

}
