package kr.team1.app.web.heroinfo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

//- 컨트롤러에서 요청될 service 메소드 작성

public interface HeroInfoService  {
	
	public ModelAndView getData(HttpSession session, ModelAndView mav);
	public List<HeroBean> getList(String hp);
	public int setComments(CommentBean cb);
	public InformBean getHeroInfo(String key);
}
