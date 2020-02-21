package kr.team1.app.web.counterpick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterpickDaoImp implements CounterpickDao {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<CounterpickHeroBean> getHero(CounterpickHeroBean cpb) {
		System.out.println("11");
		System.out.println(cpb);
		System.out.println(sqlsession.selectList("counterpick_sql.heroinfo_heroname", cpb));
		return sqlsession.selectList("counterpick_sql.heroinfo_heroname", cpb);
	}
	
	@Override
	public List<CounterpickHeroBean> getHeroimg1(CounterpickHeroBean cpb) {
		System.out.println("11");
		System.out.println(cpb);
		System.out.println(sqlsession.selectList("counterpick_sql.heroinfo_heroimg1", cpb));
		return sqlsession.selectList("counterpick_sql.heroinfo_heroimg1", cpb);
	}
	
	@Override
	public List<CounterpickHeroBean> getHero(String cpb) {
		System.out.println("1");
		System.out.println(cpb);
		System.out.println(sqlsession.selectList("counterpick_sql.heroinfo_heroname", cpb));
		return sqlsession.selectList("counterpick_sql.heroinfo_heroname", cpb);
	}

//	@Override
//	public CounterpickHeroBean getHeroname(String heroname) {
//		System.out.println("1");
//		System.out.println(heroname);
//		return sqlsession.selectOne("counterpick_sql.heroinfo_heroname", heroname);
//	}

	@Override
	public CounterpickHeroBean getHeroimg(String heroname) {
		return sqlsession.selectOne("counterpick_sql.heroinfo_heroimg", heroname);
	}

	@Override
	public int setVotenum(CounterpickHeroBean votenum) {
		return sqlsession.insert("counterpick_sql.herovote", votenum);
	}

	@Override
	public List<Map<String, Object>> getHero() {
		return sqlsession.selectList("counterpick_sql.getHero");
	}
	
	@Override
	public List<Map<String, Object>> getVoteHero(String heroname) {
		return sqlsession.selectList("counterpick_sql.getVoteHero", heroname);
	}
	
	@Override
	public List<Map<String, Object>> getVoteno1(Map<String, Object> params) {
		return sqlsession.selectList("counterpick_sql.getVoteno1", params);
	}
	
	@Override
	public List<Map<String, Object>> getVoteno2(Map<String, Object> params) {
		return sqlsession.selectList("counterpick_sql.getVoteno2", params);
	}
	
	@Override
	public List<Map<String, Object>> getVoteno3(Map<String, Object> params) {
		return sqlsession.selectList("counterpick_sql.getVoteno3", params);
	}
	
	@Override
	public Map<String, Object> getHero(CounterpickHeroBean cpb1, CounterpickHeroBean cpb2) {
		System.out.println("11");
		System.out.println(cpb1);
		System.out.println(cpb2);
//		System.out.println(sqlsession.selectM("counterpick_sql.heroinfo_herovote", cpb1));
		System.out.println(sqlsession.selectList("counterpick_sql.heroinfo_herovote", cpb2));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("no1", sqlsession.selectList("counterpick_sql.heroinfo_herovote", cpb1));
		result.put("no2", sqlsession.selectList("counterpick_sql.heroinfo_herovote", cpb2));
//		sqlsession.selectMap(statement, mapKey)
		System.out.println(result);
		return result;
	}
	

	@Override
	public List<CounterpickHeroBean> getHero(String cpb1, String cpb2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setVoteUpdate1(Map<String, Object> params) {
		Map<String, String> result = new HashMap<String, String>();
//		result.put("mnhero", mnhero);
//		result.put("cnhero", cnhero);
//		result.put("voteno1", cnhero);
		return sqlsession.update("counterpick_sql.vote_update1", params);
	}
	
	@Override
	public int setVoteUpdate2(Map<String, Object> params) {
		Map<String, String> result = new HashMap<String, String>();
//		result.put("mnhero", mnhero);
//		result.put("cnhero", cnhero);
//		result.put("voteno1", cnhero);
		return sqlsession.update("counterpick_sql.vote_update2", params);
	}
	
	@Override
	public int setVoteUpdate3(Map<String, Object> params) {
		Map<String, String> result = new HashMap<String, String>();
//		result.put("mnhero", mnhero);
//		result.put("cnhero", cnhero);
//		result.put("voteno1", cnhero);
		return sqlsession.update("counterpick_sql.vote_update3", params);
	}


}
