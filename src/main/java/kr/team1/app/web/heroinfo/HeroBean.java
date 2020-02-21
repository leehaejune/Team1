package kr.team1.app.web.heroinfo;

public class HeroBean {
	
	private String no;
	private String heroname;
	private String heroimg;
	private String heroposition;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getHeroname() {
		return heroname;
	}
	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}
	public String getHeroimg() {
		return heroimg;
	}
	public void setHeroimg(String heroimg) {
		this.heroimg = heroimg;
	}
	public String getHeroposition() {
		return heroposition;
	}
	public void setHeroposition(String heroposition) {
		this.heroposition = heroposition;
	}
	@Override
	public String toString() {
		return "HeroBean [no=" + no + ", heroname=" + heroname + ", heroimg=" + heroimg + ", heroposition="
				+ heroposition + "]";
	}
}
