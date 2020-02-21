package kr.team1.app.web.board;

public class Boardbean {

	int no;
	int hits;
	String title;
	String content1;
	String content2;
	String content3;
	String content4;
	String content5;
	String heroname;
	String heroimg;
	String mapname;
	String id;
	String date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
//		String from = "123";
//		int no = Integer.parseInt(from);
		this.no =no;
	}
	
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits =hits;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
		}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	public String getContent4() {
		return content4;
	}
	public void setContent4(String content4) {
		this.content4 = content4;
	}
	public String getContent5() {
		return content5;
	}
	public void setContent5(String content5) {
		this.content5 = content5;
	}
	public String getHeroname() {
		return heroname;
	}
	public void setHeroname(String heroname) {
		this.heroname= heroname;
	}
	public String getHeroimg() {
		return heroimg;
	}
	public void setHeroimg(String heroimg) {
		this.heroimg= heroimg;
	}
	public String getMapname() {
		return mapname;
	}
	public void setMapname(String mapname) {
		this.mapname = mapname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BoardBean [no=" + no + ", hits=" + hits + ", title =" +title + ", content1 =" +content1 + ",  content2 ="
				+ content2 + ", content3 =" + content3 + ", content4 =" +content4  +" , content5 =" + content5 +" , heroimg =" +heroimg +" , heroname =" +heroname +" , mapname =" +mapname +" , id =" +id +", date =  "+date+"  ]";
	}
	
}
