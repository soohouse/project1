<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		request.setCharacterEncoding("utf-8");
		
		
	    String writer = request.getParameter("writer");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	   
	 	BoardDAO dao = BoardDAO.getInstance();
	 	BoardDAO.getInstance().regist(writer, title, content);
	    response.sendRedirect("board_list.jsp");
	    
		

	%>

</body>
</html>