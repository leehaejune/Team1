package kr.team1.app.web.heroinfo;

import java.util.HashMap;
import java.util.List;

public interface HeroInfoDao {
	
	public InformBean getHeroInfo(String key);
	public List<SkillBean> getSkill(String key);
	public List<CommentBean> getComments(String key);
	public List<HeroBean> getList(String hp);
	
	public int setComments(CommentBean cb);
}
