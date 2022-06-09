package kr.co.pr.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			int bId = Integer.parseInt(request.getParameter("bId"));
			String title = request.getParameter("bTitle");
			String content = request.getParameter("bContent");
			
			BoardDAO.getInstance().updateBoard(title, content, bId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
