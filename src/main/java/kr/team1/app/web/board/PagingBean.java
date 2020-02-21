package kr.team1.app.web.board;


import java.util.List;

public class PagingBean {
	
	int tot;
	int position;
	List<PagingSubBean> pbList;
	
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public List<PagingSubBean> getPbList() {
		return pbList;
	}
	public void setPbList(List<PagingSubBean> pbList) {
		this.pbList = pbList;
	}
	@Override
	public String toString() {
		return "PagingBean [tot=" + tot + ", position=" + position + ", pbList=" + pbList + "]";
	}
	
}