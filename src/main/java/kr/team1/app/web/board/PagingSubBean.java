package kr.team1.app.web.board;


public class PagingSubBean {

	int num;
	int position;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "PagingSubBean [num=" + num + ", position=" + position + "]";
	}
	
}
