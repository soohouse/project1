package kr.co.pr.board.model;

import java.util.List;

public interface IBoardDAO {
	
	void regist(String writer, String title, String content);
	
	List<BoardVO> listBoard();
	
	BoardVO contentBoard(int bId);
	
	void updateBoard(String title, String content, int bId);
	
	void deleteBoard(int bId);
	
	void upHit(int bId);

}
