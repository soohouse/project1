package kr.co.pr.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;

public class ListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		 BoardDAO dao = BoardDAO.getInstance();
		 List<BoardVO> articles = dao.listBoard(); 
		 request.setAttribute("bList", articles);
	}

}
