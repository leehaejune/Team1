package kr.team1.app.web.index;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserService {
	
	public UserBean getUser(UserBean ub);
	public int idExist(String signup);
	public int signup(HashMap<String, String> map);
	public int userup(HashMap<String, String> map);
	public int userDelete(HashMap<String, String> map);
	public List<HashMap> boardview();
}
