package kr.team1.app.web.counterpick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CounterpickDao {
	
	public List<CounterpickHeroBean> getHero(CounterpickHeroBean cpb);
	
	public Map<String, Object> getHero(CounterpickHeroBean cpb1, CounterpickHeroBean cpb2);
	
	public List<CounterpickHeroBean> getHero(String cpb);
	
	public List<CounterpickHeroBean> getHeroimg1(CounterpickHeroBean cpb);
	
	public List<CounterpickHeroBean> getHero(String cpb1, String cpb2);
	
//	public CounterpickHeroBean getHeroname(String heroname);
	
	public CounterpickHeroBean getHeroimg(String heroname);
	
	public int setVotenum(CounterpickHeroBean votenum);

	public List<Map<String, Object>> getHero();

	public List<Map<String, Object>> getVoteHero(String heroname);
	
	public int setVoteUpdate1(Map<String, Object> params);
	
	public int setVoteUpdate2(Map<String, Object> params);
	
	public int setVoteUpdate3(Map<String, Object> params);

	public List<Map<String, Object>> getVoteno1(Map<String, Object> params);
	
	public List<Map<String, Object>> getVoteno2(Map<String, Object> params);
	
	public List<Map<String, Object>> getVoteno3(Map<String, Object> params);

}
