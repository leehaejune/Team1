package kr.team1.app.web.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface BoardDao {

	public Boardbean getBoard(Boardbean bb);
//	public List<Map<String,Object>> getPag(PaggingBean pb);
	public Map<String, Object> getBoardList();
	public Map<String, Object> getBoardList2();
	public Map<String, Object> getBoardList4(int no);
	public List<Boardbean> getBoardList3(Map<String, Object> paramMap);

	public Map<String, Object> getBoardData(int no);
	public int hits(Map<String, Object> paramMap);
	
	public int getTotalCnt(Map<String, Object> paramMap);

//	public Map<String, Object> getBoard2(int hno, int mno);
	

	public int setBoard(HashMap<String, String> map);
	public int upBoard(HashMap<String, String> map);
	public int delBoard(int no);
//	
	public List<Map<String, Object>> getHero();
	public List<Map<String, Object>> getMap();
	
//	public int countBoard();

}
