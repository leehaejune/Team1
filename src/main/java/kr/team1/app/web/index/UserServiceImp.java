package kr.team1.app.web.index;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	@Autowired private UserDao userDao;

	@Override
	public UserBean getUser(UserBean ub) {
		return userDao.getUser(ub);
	};
	@Override
	public int idExist(String signid) {
		return userDao.idExist(signid);
	};
	@Override
	public int signup(HashMap<String, String> map) {
		return userDao.signup(map);
	};
	@Override
	public int userup(HashMap<String, String> map) {
		return userDao.userup(map);
	};
	@Override
	public int userDelete(HashMap<String, String> map) {
		return userDao.userDelete(map);
	};
	@Override
	public List<HashMap> boardview() {
		return userDao.boardview();
	};
}
