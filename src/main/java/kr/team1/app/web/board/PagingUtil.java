package kr.team1.app.web.board;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class PagingUtil {

	private int view = 4;
	
	public PagingBean setPaging(String type, int position, HttpSession session, int tot) {
		PagingBean pb = new PagingBean();
		
		// 현재 보여주는 블럭 위치 (limit 시작 위치) 섹션값 구하기
		Object obj = session.getAttribute("position");
		// 호출 시 사용된 블럭위치 값 비교 (-1 경우 새로고침 했을 경우)
		if(position < 0) {
			if(obj == null) { 
				// 섹션값이 없을 경우 모든값 초기값으로 설정
				position = 0;
			} else {
				// 섹션값이 존재 할 경우 블럭위치 값으로 사용
				position = Integer.parseInt(obj.toString());
			}
		}
		// 왼쪽, 오른쪽 클릭 이벤트 처리 (P: 왼쪽, N: 오른쪽)
		if("P".equals(type)) {
			// 현재 블럭에서 전 블럭으로 감소 처리
			position -= view;
			// 감소 했을 경우 음수일 경우 초기값으로 돌아가기
			if(position < 0) position = 0;
		} else if("N".equals(type)) {
			// 현재 블럭에서 후 블럭으로 증가 처리
			position += view;
			// 증가 했을 경우 리스트 전체 수 보다 클 경우 전 블럭으로 돌아가기
			if(position > tot) position -= view;
		}
		// 블럭 위치값 섹션에 다시 저장 하기
		session.setAttribute("position", position);
		
		// 페이징 사용할 설정값 담기
		pb.setPosition(position);
		pb.setTot(tot);
		pb.setPbList(getPaging(tot));
		
		return pb;
	}
	
	private List<PagingSubBean> getPaging(int tot) {
		List<PagingSubBean> pbList = new ArrayList<PagingSubBean>(); 
		// 페이징 시작 번호 설정
		int num = 1;
		// 블럭위치 설정
		int position = 0;
		// 리스트 전체 수가 0 보다 클 경우 생성하기
		if(tot > 0) {
			// 블럭단위로 나누었을때 몇개의 블럭인지 구하기
			int 블럭수 = (int) Math.ceil((double) tot / view);
			// 블럭수 만큼 반복하기
			for(int i = 0; i < 블럭수; i++) {
				num = (i + 1);
				position = (i * view);
				// 리스트 전체 수 보다 큰 경우 종료하기
				if(position > tot) break;
				PagingSubBean psb = new PagingSubBean();
				// 페이징 번호 담기
				psb.setNum(num);
				// 블럭 위치값 담기
				psb.setPosition(position);
				pbList.add(psb);
			}
		}
		return pbList;
	}
	
}
