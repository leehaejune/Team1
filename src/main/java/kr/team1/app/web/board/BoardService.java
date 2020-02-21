package kr.team1.app.web.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface BoardService {
//	public Map<String, Object> getPag(PaggingBean pb);
	public	Boardbean getBoard(Boardbean bb);
	public Map<String, Object> getBoardList();	
	public Map<String, Object> getBoardList2();
	public Map<String, Object> getBoardList4(int no);
	public Map<String, Object>getBoardList3(String type, int position, HttpSession sqlsession,  HttpServletRequest req);
//	public List<Boardbean> getBoardList4(Boardbean bb);
//	public int getBoardList4(int no);
	public Map<String, Object> getBoardData(int no);
//
	
	public int setBoard(HashMap<String, String> map);
	public int upBoard(HashMap<String, String> map);
	public int delBoard(int no);

	
	
	
	public Map<String, Object> getData();
	
}
