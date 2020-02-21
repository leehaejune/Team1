package kr.team1.app.web.counterpick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

public interface CounterpickService {
	
	public List<CounterpickHeroBean> getHero(CounterpickHeroBean heroname);
	
	public List<CounterpickHeroBean> getHeroname(String index);
	
	public List<CounterpickHeroBean> getHeroimg1(String index);
	
//	public List<CounterpickHeroBean> getHeroname(String index1, String index2);
	
	public Map<String, Object> getHeroname(String index1, String index2);
	
	public CounterpickHeroBean getHeroimg(String heroname);
	
	public int setVotenum(String heroname, int votenum);

	public Map<String, Object> getData_cp();

	public Map<String, Object> getVoteData(String heroname);

//	public List<CounterpickHeroBean> getHeroname(String no);
	
	public int setVoteUpdate1(Map<String, Object> params);
	
	public int setVoteUpdate2(Map<String, Object> params);
	
	public int setVoteUpdate3(Map<String, Object> params);

	public List<Map<String, Object>> getVoteno1(Map<String, Object> params);
	
	public List<Map<String, Object>> getVoteno2(Map<String, Object> params);
	
	public List<Map<String, Object>> getVoteno3(Map<String, Object> params);

}
