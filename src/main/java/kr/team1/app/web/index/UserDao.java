package kr.team1.app.web.index;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserDao {
	
	public UserBean getUser(UserBean ub);
	public int idExist(String signid);
	public int signup(HashMap<String, String> map);
	public int userup(HashMap<String, String> map);
	public int userDelete(HashMap<String, String> map);
	public List<HashMap> boardview();
}
