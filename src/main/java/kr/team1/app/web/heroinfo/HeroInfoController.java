package kr.team1.app.web.heroinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.team1.app.web.index.UserBean;


@Controller
@RequestMapping("/")
public class HeroInfoController {
	
	@Autowired private HeroInfoService his;
	
	@RequestMapping(value = "/heroinfo", method = RequestMethod.GET)
	public String heroinfo(HttpSession session, HttpServletRequest req) throws Exception {
		String key = req.getParameter("key");
//		System.out.println(key);
		if(key != null) {
			session.setAttribute("key", key);
//			System.out.println(session.getAttribute("key"));
			if (key.equals("1") || key.equals("17") || key.equals("25")) {
				return "heroinfo";
				
			} else {
				System.out.println("false");
				String referer = req.getHeader("REFERER");
			      String[] split = referer.split("/");
			      String url = "";
			      if (split.length > 3) {
			         for (int i = 3; i < (split.length - 3); i++) {
			            url += "/" + split[i];
			         }
			         System.out.println(url);
			         if (url == "/login") {
			            return "redirect:/";
			         }
			      } else {
			         url = "/";
			      }
			      return "redirect:" + referer;
			}
		}
		
		return "redirect:/herolist";
	}
	
	@RequestMapping(value = "heroinfo2", method = RequestMethod.GET)
	public ModelAndView heroinfo(HttpSession session, ModelAndView mav) {
		mav = his.getData(session, mav);
		mav.setViewName("page/heroinfo");
		return mav;
	}
	
	@RequestMapping(value = "herolist", method = RequestMethod.GET)
	public ModelAndView herolist(HttpSession session, ModelAndView mav) {
		mav.addObject("Att", his.getList("Att"));
		mav.addObject("Cha", his.getList("Cha"));
		mav.addObject("Sub", his.getList("Sub"));
		mav.setViewName("herolist");
		return mav;
	}
	
	@RequestMapping(value = "herocomment", method = RequestMethod.POST)
	public @ResponseBody int comments(@RequestParam HashMap<String, String> map, HttpSession session, CommentBean cb) {
		UserBean ub = (UserBean) session.getAttribute("UserInfo");
		String key = (String) session.getAttribute("key");
		InformBean ib = his.getHeroInfo(key);

		cb.setContent(map.get("content"));
		cb.setDate(map.get("date"));
		cb.setId(ub.getId());
		cb.setHeropage(ib.getHeroname());
		System.out.println(cb);
		
		return his.setComments(cb);
	}
}