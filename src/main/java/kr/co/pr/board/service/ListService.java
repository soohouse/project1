package kr.co.pr.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;
import kr.co.pr.board.page.PageCreator;
import kr.co.pr.board.page.PageVO;

public class ListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		 PageVO paging = new PageVO();
		 BoardDAO dao = BoardDAO.getInstance();
		 
		 if(request.getParameter("page") !=null) {
			 paging.setPage(Integer.parseInt(request.getParameter("page")));
			 paging.setCountPerPage(Integer.parseInt(request.getParameter("cpp")));
		 }
		 
		 System.out.println("선택한 페이지: " + paging.getPage() + "게시물 수: " + paging.getCountPerPage());
		 
		 List<BoardVO> articles = dao.listBoard(paging);
		 
		 PageCreator pc = new PageCreator();
		 pc.setPaging(paging);
		 pc.setTotalCount(dao.countArticles());
		 
		 System.out.println(pc);
		 

		 
		 request.setAttribute("bList", articles);
		 request.setAttribute("pc", pc);
		 
		 
	}

}
