package kr.team1.app.web.index;

public class UserBean {
	
	private String id;
	private String pwd;
	private String nick;
	private String role;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", role=" + role + ", email="
				+ email + "]";
	}

}
