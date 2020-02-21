package kr.team1.app.web.heroinfo;

public class CommentBean {
	
	private String no;
	private String id;
	private String content;
	private String date;
	private String heropage;

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeropage() {
		return heropage;
	}
	public void setHeropage(String heropage) {
		this.heropage = heropage;
	}

	@Override
	public String toString() {
		return "CommentBean [no=" + no + ", id=" + id + ", content=" + content + ", date=" + date + ", heropage="
				+ heropage + "]";
	}
	
}
