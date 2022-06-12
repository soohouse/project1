package kr.co.pr.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.IBoardDAO;
import kr.co.pr.board.service.ContentService;
import kr.co.pr.board.service.DeleteService;
import kr.co.pr.board.service.IBoardService;
import kr.co.pr.board.service.ListService;
import kr.co.pr.board.service.ModifyService;
import kr.co.pr.board.service.UpdateService;
import kr.co.pr.board.service.WriterService;



@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RequestDispatcher dp;
	private IBoardService sv;
    public BoardController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}

	
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String uri = request.getRequestURI();
			String conPath = request.getContextPath();
			uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
			
			System.out.println(uri);
			
			switch (uri) {
			
			case "write":
				System.out.println("글쓰기 페이지로 이동 요청");
				response.sendRedirect("/WebTemp/board/board_writer.jsp");
				break;
				
			case "regist": 
				System.out.println("글 등록 요청");
				sv = new WriterService();
				sv.execute(request, response);
				
				response.sendRedirect("/WebTemp/board_list.jsp");
				break;
				
			case "boardlist":
				System.out.println("글 목록 페이지 이동");
				sv = new ListService();
				sv.execute(request, response);
				dp=request.getRequestDispatcher("board/board_list.jsp");
				dp.forward(request, response);
				break;
				
			case "content":
				System.out.println("글 상세 보기 요청");
				sv = new ContentService();
				sv.execute(request, response);
				dp = request.getRequestDispatcher("board/board_content.jsp");
				dp.forward(request, response);
				break;
			
			case "modify":
				System.out.println("글 수정 페이지 이동");
				sv = new ModifyService();
				sv.execute(request, response);
				dp = request.getRequestDispatcher("board/board_modify.jsp");
				dp.forward(request, response);
				break;
				
			case "update":
				System.out.println("글 수정 요청");
				sv = new UpdateService();
				sv.execute(request, response);
				response.sendRedirect("/WebTemp/board.board?bId=" + request.getParameter("bId"));
				
			case "delete":
				System.out.println("삭제 요청");
				sv = new DeleteService();
				sv.execute(request, response);
				response.sendRedirect("/WebTemp/board_list.board");
				break;
				
				
				
	}
}
}



