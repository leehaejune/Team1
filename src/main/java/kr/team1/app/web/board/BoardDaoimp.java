package kr.team1.app.web.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;
@Repository
public class BoardDaoimp implements BoardDao {
	@Autowired
	SqlSession sqlsession;


	@Override
	public Boardbean getBoard(Boardbean bb) {
		return sqlsession.selectOne("board.bList", bb);
	}
	@Override
	public Map<String, Object> getBoardData(int no) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("result5", sqlsession.selectOne("board.bdList",no));
		return sqlsession.selectOne("board.bdList",no);

	}
	@Override
	public Map<String, Object> getBoardList() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", sqlsession.selectList("board.bList"));
		return resultMap;

	}
	
	@Override
	public Map<String, Object> getBoardList2() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result2", sqlsession.selectList("board.bList2"));
		return resultMap;

	}
	
	@Override
	public Map<String, Object> getBoardList4(int no) {
//		System.out.println("In!!");
//		System.out.println(sqlsession.selectList("board.getboardList"));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result6",sqlsession.update("board.hitscnt", no));
		resultMap.put("result4", sqlsession.selectOne("board.getboardList", no));
		return resultMap;

	}
	
	@Override
	public int hits(Map<String, Object> paramMap) {
	return sqlsession.update("board.hitscnt",paramMap);
	}
//	@Override
//	   public int getBoardList4(int no) {
//		return sqlsession.selectOne("board.getboardList",no);
//
//	   }
	
	@Override
	public List<Boardbean> getBoardList3(Map<String, Object> paramMap) {
//		System.out.println(bb);
//		System.out.println(sqlsession.selectList("board.getboradList3", paramMap));
		return sqlsession.selectList("board.getboradList3", paramMap);

		}
	
	@Override
	public int getTotalCnt(Map<String, Object> paramMap) {
		return sqlsession.selectOne("board.getTotalCnt", paramMap);
	}


	
	
	
//	@Override
//	public List<Boardbean> getBoardList4(Boardbean bb) {
//		System.out.println(bb);
//		System.out.println(sqlsession.selectList("board.bListhero", bb));
//		return sqlsession.selectList("board.bListhero",bb);
//
//		}
//	@Override
//	public List<Map<String, Object>> getPag(PaggingBean pb) {
//		System.out.println("in!!");
//		System.out.println(sqlsession.selectList("board.getPag", pb));
//		return sqlsession.selectList("board.getPag", pb);
//	}
//	@Override
//	public int countBoard() {
//		return sqlsession.selectOne("board.countPag");
//	}

	@Override
	public int setBoard(HashMap<String, String> map) {
		return sqlsession.insert("board.bcreate", map);
	};
	@Override
	public int upBoard (HashMap<String, String> map) {
		return sqlsession.update("board.bupdate", map);
	};
	
	@Override
	public int delBoard(int no) {
		return sqlsession.delete("board.bdelete", no);
	};
	
	/******************************************************************/
	@Override
	public List<Map<String, Object>> getHero() {
		return sqlsession.selectList("board.getHero");
	}

	@Override
	public List<Map<String, Object>> getMap() {
		return sqlsession.selectList("board.getMap");
	}
}
