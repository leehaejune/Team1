package kr.team1.app.web.heroinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

//Service : 유지보수와 로직프로세스를 유연하게 처리하기 위한 중간 단계.
//controller -> service(interface) -> ServiceImpl -> dao

@Service
public class HeroInfoServiecImp implements HeroInfoService {

	@Autowired 
	private HeroInfoDao hid;
	
	@Override
	public ModelAndView getData(HttpSession session, ModelAndView mav) {
		System.out.println("service");
		
		Object key = session.getAttribute("key");
		System.out.println(key);
		
		mav.addObject("InformBean", hid.getHeroInfo(key.toString()));
		mav.addObject("SkillBeans", hid.getSkill(key.toString()));
		mav.addObject("CommentBeans", hid.getComments(key.toString()));
		return mav;
	}
	
	@Override
	public int setComments(CommentBean cb) {
		return hid.setComments(cb);
	}
	
	@Override
	public List<HeroBean> getList(String hp) {
		return hid.getList(hp);
	}
	
	@Override
	public InformBean getHeroInfo(String key) {
		return hid.getHeroInfo(key);
	}
}
