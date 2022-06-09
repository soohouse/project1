package kr.co.pr.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;

public class ModifyService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardVO vo = BoardDAO.getInstance().contentBoard(bId);
		request.setAttribute("board_modify", vo);

	}

}
