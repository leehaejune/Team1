package kr.team1.app.web.heroinfo;

public class SkillBean {
	
	private String heroname;
	private String sname;
	private String content;
	private String key;
	private String img;
	private String movie;
	private String movieimg;
	
	private String no;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSkillno() {
		return skillno;
	}
	public void setSkillno(String skillno) {
		this.skillno = skillno;
	}
	public String getHeroname() {
		return heroname;
	}
	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getMovieimg() {
		return movieimg;
	}
	public void setMovieimg(String movieimg) {
		this.movieimg = movieimg;
	}
	private String skillno;
	@Override
	public String toString() {
		return "SkillBean [no=" + no + ", skillno=" + skillno + ", heroname=" + heroname + ", sname=" + sname
				+ ", content=" + content + ", key=" + key + ", img=" + img + ", movie=" + movie + ", movieimg="
				+ movieimg + "]";
	}
	
	

}
