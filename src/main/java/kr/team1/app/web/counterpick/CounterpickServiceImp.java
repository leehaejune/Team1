package kr.team1.app.web.counterpick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CounterpickServiceImp implements CounterpickService {
	
	@Autowired
	private CounterpickDao counterpickDao;

	@Override
	public List<CounterpickHeroBean> getHero(CounterpickHeroBean heroname) {
		CounterpickHeroBean cpb = new CounterpickHeroBean();
		cpb.setNo(heroname.getNo());
		System.out.println("2");
		System.out.println(heroname);
		return counterpickDao.getHero(cpb);
	}

	@Override
	public List<CounterpickHeroBean> getHeroname(String index) {
		System.out.println(index);
		CounterpickHeroBean cpb = new CounterpickHeroBean();
		cpb.setNo(index);
		System.out.println("2");
		System.out.println(index);
		
		return counterpickDao.getHero(cpb);
	}
	
	@Override
	public List<CounterpickHeroBean> getHeroimg1(String index) {
		System.out.println(index);
		CounterpickHeroBean cpb = new CounterpickHeroBean();
		cpb.setHeroname(index);
		System.out.println("2");
		System.out.println(index);
		
		return counterpickDao.getHeroimg1(cpb);
	}

	@Override
	public CounterpickHeroBean getHeroimg(String heroname) {
		return counterpickDao.getHeroimg(heroname);
	}

	@Override
	public int setVotenum(String heroname, int votenum) {
		CounterpickHeroBean cpb = new CounterpickHeroBean();
		cpb.setHeroname(heroname);
		cpb.setVotenum(votenum);
		return counterpickDao.setVotenum(cpb);
	}
	
	@Override
	public Map<String, Object> getData_cp() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("HeroList", counterpickDao.getHero());
		System.out.println(resultMap);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> getVoteData(String heroname) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("HeroList", counterpickDao.getVoteHero(heroname));
		System.out.println("resultMap");
		System.out.println(resultMap);
		return resultMap;
	}
	
	@Override
	public List<Map<String, Object>> getVoteno1(Map<String, Object> params) {
		System.out.println("params");
		System.out.println(params);
		return counterpickDao.getVoteno1(params);
	}
	
	@Override
	public List<Map<String, Object>> getVoteno2(Map<String, Object> params) {
		System.out.println("params");
		System.out.println(params);
		return counterpickDao.getVoteno2(params);
	}
	
	@Override
	public List<Map<String, Object>> getVoteno3(Map<String, Object> params) {
		System.out.println("params");
		System.out.println(params);
		return counterpickDao.getVoteno3(params);
	}
	
	@Override
	public Map<String, Object> getHeroname(String index1, String index2) {
//		System.out.println(index);
		CounterpickHeroBean cpb1 = new CounterpickHeroBean();
		cpb1.setNo(index1);
		System.out.println("2");
//		System.out.println(index);
		CounterpickHeroBean cpb2 = new CounterpickHeroBean();
		cpb2.setNo(index2);
		return counterpickDao.getHero(cpb1, cpb2);
	}

	@Override
	public int setVoteUpdate1(Map<String, Object> params) {
		System.out.println("params");
		System.out.println(params);
		return counterpickDao.setVoteUpdate1(params);
	}
	
	@Override
	public int setVoteUpdate2(Map<String, Object> params) {
		System.out.println("params");
		System.out.println(params);
		return counterpickDao.setVoteUpdate2(params);
	}
	
	@Override
	public int setVoteUpdate3(Map<String, Object> params) {
		System.out.println("params");
		System.out.println(params);
		return counterpickDao.setVoteUpdate3(params);
	}

	

//	@Override
//	public List<CounterpickHeroBean> getHeroname(String no) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
