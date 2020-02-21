package kr.team1.app.web.index;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/")
public class IndexController {
    
	@Autowired private UserService userService;
	
	Object key = null;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(HttpSession session, Model model, HttpServletRequest req) {
		session.setAttribute("indexboard", userService.boardview());
		String logindivS = req.getParameter("logindivS");
		if (logindivS == null) {logindivS = "0";}
		System.out.println(logindivS + "," + session.getAttribute("UserInfo"));
		System.out.println("----------------------------");
		if (logindivS.equals("1") && session.getAttribute("UserInfo") == null) {
			model.addAttribute("logindiv", "1");
			System.out.println("true");
		} else {
			model.addAttribute("logindiv", "0");
			System.out.println("false");
		}
		System.out.println(model);
		return "index";
	}
	
	@RequestMapping(value = "joinSuccess", method = RequestMethod.GET)
	public String joinSuccess(HttpSession session) {return "joinSuccess";}
	
	@RequestMapping(value = "userUpdate", method = RequestMethod.GET)
	public String userUpdate(HttpSession session) {return "userUpdate";}
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup(HttpSession session, Model model) {
		Map<String, Object> authMap = new HashMap<String, Object>();
		key = UUID.randomUUID();
		authMap.put("paramName", "_auth");
		authMap.put("paramValue", key);
		model.addAttribute("_auth", authMap);
		session.setAttribute("_auth", authMap);
		
		return "indexJoin";
	}
	
	//LOGIN
	@RequestMapping(value = "security/success", method = RequestMethod.POST)
	public String success(@AuthenticationPrincipal UserDetails userDetails, UserBean ub, HttpSession session, HttpServletRequest req) {
		System.out.println("userdetails = " + userDetails.toString());
		ub.setId(userDetails.getUsername());
		session.setAttribute("UserInfo", userService.getUser(ub));
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
	
	@RequestMapping(value = "security/logout")
	public String logout(HttpServletRequest req) {
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
	
	@RequestMapping(value = "logindiv")
	public String logindiv(HttpServletRequest req, RedirectAttributes redir, HttpSession session) {
		System.out.println(session.getAttribute("UserInfo"));
		Object obj = session.getAttribute("UserInfo");
		System.out.println(obj);
		if (obj == null) {
			redir.addAttribute("logindivS", 1);
		} else {
			redir.addAttribute("logindivS", 0);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "security/error")
	public ResponseEntity<String> error() {
		HttpHeaders head = new HttpHeaders();
		head.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
		String html = 
"<img style='margin:77px auto; display:block;' src='../../../res/img/inven_logo.gif'>"
+ "<span style='text-align:center;'><h1>로그인 실패</h1><p>아이디와 비밀번호를 다시 확인해주세요<br></p>"
+ "<button onClick='history.go(-1)' style='display:block; margin:30px auto; background-color:orange; height:50px; width:115px; color:white;'>이전페이지로<br>돌아가기</button></span>";
		return new ResponseEntity<String>(html, head, HttpStatus.CREATED);
	}
	@RequestMapping(value = "security/denied")
	public ResponseEntity<String> denied() {
		HttpHeaders head = new HttpHeaders();
		head.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
		String html = 
"<img style='margin:77px auto; display:block;' src='../../../res/img/inven_logo.gif'>"
+ "<span style='text-align:center;'><h1>접근 불가</h1><p>접근 권한이 없습니다 로그인을 해주세요<br></p>"
+ "<button onClick='history.go(-1)' style='display:block; margin:30px auto; background-color:orange; height:50px; width:115px; color:white;'>이전페이지로<br>돌아가기</button></span>";
		return new ResponseEntity<String>(html, head, HttpStatus.CREATED);
	}
	
	//SIGNUP
	@RequestMapping(value = "idExist", method = RequestMethod.POST)
	public ResponseEntity<Integer> idExist(HttpServletRequest req, HttpSession session) throws Exception {
//		Object obj = session.getAttribute("_auth");
		String auth = req.getParameter("_auth");
//		System.out.println("auth : " + auth);
//		System.out.println("key : " + key);
		int status = -1;
//		if(obj != null) {
//			Map<String, Object> authMap = (Map<String, Object>) obj;
			if(key.toString().equals(auth)) {
				System.out.println("-----");
				status = userService.idExist(req.getParameter("idExist"));
			}
//		}
		return new ResponseEntity<Integer>(status, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public @ResponseBody int signup(@RequestParam HashMap<String, String> map) {
		return userService.signup(map);
	}
	
	//UPDATE
	@RequestMapping(value = "userUp", method = RequestMethod.POST)
	public @ResponseBody int userup(@RequestParam HashMap<String, String> map) {
		if (map.get("pwd").length() < 4 ) {
			map.remove("pwd");
		}
		return userService.userup(map);
	}
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody int delete(@RequestParam HashMap<String, String> map) {
		return userService.userDelete(map);
	}
}
