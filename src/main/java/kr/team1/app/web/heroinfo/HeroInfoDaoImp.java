package kr.team1.app.web.heroinfo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HeroInfoDaoImp implements HeroInfoDao {
	
	@Autowired private SqlSession sql;

	@Override
	public InformBean getHeroInfo(String key) {
		return sql.selectOne("heroinfo.getHeroInfo", key);
	}

	@Override
	public List<SkillBean> getSkill(String key) {
		return sql.selectList("heroinfo.getSkill", key);
	}

	@Override
	public List<CommentBean> getComments(String key) {
		return sql.selectList("heroinfo.getComments", key);
	}
	
	@Override
	public int setComments(CommentBean cb) {
		return sql.insert("heroinfo.setComments", cb);
	}
	
	@Override
	public List<HeroBean> getList(String hp) {
	
		return sql.selectList("heroinfo.getList", hp);
	}

}
