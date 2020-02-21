package kr.team1.app.web.index;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public UserBean getUser(UserBean ub) {
		return sqlsession.selectOne("user.getUser", ub);
	};
	@Override
	public int idExist(String signid) {
		return sqlsession.selectOne("user.idExist", signid);
	};
	@Override
	public int signup(HashMap<String, String> map) {
		return sqlsession.insert("user.signup", map);
	};
	@Override
	public int userup(HashMap<String, String> map) {
		return sqlsession.update("user.userup",map);
	};
	@Override
	public int userDelete(HashMap<String, String> map) {
		String pwd1 = map.get("pwd");
		String pwd2 = sqlsession.selectOne("user.pwdCheck", map);
		
		if (pwd1.equals(pwd2)) {
			System.out.println("correct");
			return sqlsession.update("user.delete", map);
		} else {
			System.out.println("incorrect");
			return 0;
		}
	};
	@Override
	public List<HashMap> boardview() {
		return sqlsession.selectList("user.bList");
	};
}
