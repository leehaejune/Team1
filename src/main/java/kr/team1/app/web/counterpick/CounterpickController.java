package kr.team1.app.web.counterpick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class CounterpickController {
	
	@Autowired
	private CounterpickService counterpickService;
	
	@RequestMapping(value = "/counterpick", method = RequestMethod.GET)
	public String counterpick_get() {
//		System.out.println("counterpick");
		return "counterpick";
	}
	
	@RequestMapping(value = "/getData_cp", method = RequestMethod.POST)
	public String getData_cp(Model model) { 
		model.addAttribute("result",counterpickService.getData_cp());
		return "counterpick123/counterpick";
    }
//	@RequestMapping(value = "/getVoteData")
//	public String getVoteData(@RequestAttribute HttpServletRequest req, Model model) { 
//		String heroname = (String) req.getAttribute("heroname");
//		System.out.println("model");
//		System.out.println(heroname);
//		model.addAttribute("result1",counterpickService.getVoteData(heroname));
//		System.out.println(model);
//		return "/counterpick";
//    }
	//기존
	@RequestMapping(value = "/getVoteData")
	public String getVoteData(@RequestParam("heroname") String heroname, Model model) { 
		System.out.println("model");
		System.out.println(model);
		model.addAttribute("result1",counterpickService.getVoteData(heroname));
		System.out.println(model);
		return "counterpick123/counterpick1";
    }
//	1
//	@RequestMapping(value = "/getVote", method = RequestMethod.POST)
//	public String getName(Model model) { 
//		model.addAttribute("result",counterpickService.getData());
//		System.out.println(model);
//		return "counterpick/counterpick1";
//    }	
	
	@RequestMapping(value = "/getName", method = RequestMethod.POST)
	@ResponseBody
	public List<CounterpickHeroBean> getName(@RequestParam("no") String no) { 
//		no.addAttribute("result",counterpickService.getData());
		return counterpickService.getHeroname(no);
    }
	
	@RequestMapping(value = "/getImg", method = RequestMethod.POST)
	@ResponseBody
	public List<CounterpickHeroBean> getImg(@RequestParam("heroname") String heroname) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("heroname");
		System.out.println(heroname);
		return counterpickService.getHeroimg1(heroname);
    }
	
	@RequestMapping(value = "/getVote", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getVote(@RequestParam("no1") String no1, @RequestParam("no2") String no2) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("getVote");
		System.out.println(no1);
		System.out.println(no2);
		return counterpickService.getHeroname(no1, no2);
    }
	
	@RequestMapping(value = "/setVoteUpdate1", method = RequestMethod.POST)
	@ResponseBody
	public int setVoteUpdate1(@RequestParam Map<String, Object> params) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("setVoteUpdate");
		System.out.println(params);
//		System.out.println(cnhero);
//		System.out.println(voteno1);
		return counterpickService.setVoteUpdate1(params);
//		return 0;
    }
	
	@RequestMapping(value = "/setVoteUpdate2", method = RequestMethod.POST)
	@ResponseBody
	public int setVoteUpdate2(@RequestParam Map<String, Object> params) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("setVoteUpdate");
		System.out.println(params);
//		System.out.println(cnhero);
//		System.out.println(voteno1);
		return counterpickService.setVoteUpdate2(params);
//		return 0;
    }
	
	@RequestMapping(value = "/setVoteUpdate3", method = RequestMethod.POST)
	@ResponseBody
	public int setVoteUpdate3(@RequestParam Map<String, Object> params) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("setVoteUpdate");
		System.out.println(params);
//		System.out.println(cnhero);
//		System.out.println(voteno1);
		return counterpickService.setVoteUpdate3(params);
//		return 0;
    }
	
	@RequestMapping(value = "/getVoteno1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getVoteno1(@RequestParam Map<String, Object> params) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("getVoteno1");
		System.out.println(params);
//		System.out.println(cnhero);
//		System.out.println(voteno1);
		return counterpickService.getVoteno1(params);
//		return 0;
    }
	
	@RequestMapping(value = "/getVoteno2", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getVoteno2(@RequestParam Map<String, Object> params) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("getVoteno2");
		System.out.println(params);
//		System.out.println(cnhero);
//		System.out.println(voteno1);
		return counterpickService.getVoteno2(params);
//		return 0;
    }
	
	@RequestMapping(value = "/getVoteno3", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getVoteno3(@RequestParam Map<String, Object> params) { 
//		no.addAttribute("result",counterpickService.getData());
		System.out.println("getVoteno3");
		System.out.println(params);
//		System.out.println(cnhero);
//		System.out.println(voteno1);
		return counterpickService.getVoteno3(params);
//		return 0;
    }
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public CounterpickHeroBean counterpick_post(CounterpickHeroBean select_heroname) {
//
//		System.out.println("3");
//		System.out.println(select_heroname);
//		String heroname = select_heroname.getHeroname();
//		System.out.println("4");
//		System.out.println(heroname);
//		return counterpickService.getHeroname(select_heroname);
//	}
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	@ResponseBody
//	public List<CounterpickHeroBean> counterpick_post(RequestBody Map<> no) {
//		System.out.println("4");
//		System.out.println(no);
//		return counterpickService.getHero(no);
//	}
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	@ResponseBody
//	public List<CounterpickHeroBean> counterpick_post(@RequestBody int index) {
//		System.out.println("4");
//		System.out.println(index);
//		return counterpickService.getHero(index);
//	}
	
//	@RequestMapping(value = "", method = RequestMethod.PUT)
//	@ResponseBody
//	public int counterpick_post_vote(@RequestBody String heroname, int votenum) {
//		return counterpickService.setVotenum(heroname, votenum);
//	}
//	
}
