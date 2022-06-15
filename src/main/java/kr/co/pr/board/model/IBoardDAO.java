package kr.co.pr.board.model;

import java.util.List;

import kr.co.pr.board.page.PageVO;

public interface IBoardDAO {
	
	void regist(String writer, String title, String content);
	
	List<BoardVO> listBoard(PageVO paging);
	
	BoardVO contentBoard(int bId);
	
	void updateBoard(String title, String content, int bId);
	
	void deleteBoard(int bId);
	
	void upHit(int bId);

	int countArticles();

}
