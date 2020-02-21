package kr.team1.app.web.board;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceimp implements BoardService {
	
	
	@Autowired
	private BoardDao boardDao;
	@Autowired private PagingUtil pu;

	@Override
	public Boardbean getBoard(Boardbean bb) {
		return boardDao.getBoard( bb);
	};
	@Override
	public Map<String, Object> getBoardData(int no) {
//		System.out.println("in!!");
		return boardDao.getBoardData(no);
	}
	@Override
	public Map<String, Object> getBoardList() {
//		System.out.println("in!!");
		return boardDao.getBoardList();
	}
	@Override
	public Map<String, Object> getBoardList2() {
//		System.out.println("in!!");
		return boardDao.getBoardList2();
	}
	@Override
	public Map<String, Object> getBoardList4(int no) {
//		System.out.println("in!!");
		return boardDao.getBoardList4(no);
	}
	@Override
	public Map<String, Object> getBoardList3(String type, int position, HttpSession sqlsession,  HttpServletRequest req){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, Object> paramMap = getParamMap(req);
		// 리스트 전체 수 
		int tot = boardDao.getTotalCnt(paramMap);
		// 페이징 결과값 가져오기
		PagingBean pb = pu.setPaging(type, position, sqlsession, tot);
		paramMap.put("position", pb.getPosition());
//		System.out.println(paramMap);
		
		// 설정 된 블럭을 이용하여 리스트 가져오기
		resultMap.put("list", boardDao.getBoardList3(paramMap));
		// 페이징 대상 데이터 생성하기
		resultMap.put("pagination", pb.getPbList());
		// 설정된 블럭 위치값 전달하기
		resultMap.put("position", pb.getPosition());
		
		return resultMap;
	}
	
	private Map<String, Object> getParamMap(HttpServletRequest req) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		Enumeration<?> enume = req.getParameterNames();
		while(enume.hasMoreElements()) {
			Object name = enume.nextElement();
			String value = req.getParameter(name.toString());
//			System.out.println(name + " : " + value);
			paramMap.put(name.toString(), value);
		}
		
		return paramMap;
	}
//	@Override
//	public List<Boardbean> getBoardList4(Boardbean bb){
//		return boardDao.getBoardList4(bb);
//	}
//	@Override
//	public Map<String, Object> getPag(PaggingBean pb) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("rows", boardDao.getPag(pb));
//		resultMap.put("totCnt", boardDao.countBoard());
//		return resultMap;
//	}
	
	@Override
	public int setBoard(HashMap<String, String> map) {
		return boardDao.setBoard(map);
	};
	@Override
	public int upBoard(HashMap<String, String> map) {
		return boardDao.upBoard(map);
	};
	@Override
	public int delBoard(int no) {
		return boardDao.delBoard(no);
	};
	/******************************************************************/
	@Override
	public Map<String, Object> getData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("HeroList", boardDao.getHero());
		resultMap.put("MapList", boardDao.getMap());
		return resultMap;
	};


}

