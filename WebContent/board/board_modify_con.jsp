<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
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
	
   
    
    //BoardDAO dao = BoardDAO.getInstance();
    
 	int bId = Integer.parseInt(request.getParameter("bId"));
    String title = request.getParameter("bTitle");
    String content = request.getParameter("bContent");
    System.out.println("content값 가져오니" + bId);
    BoardDAO.getInstance().updateBoard(title, content, bId);
   //	response.sendRedirect("board_content.jsp?bId=<%=vo.getBoardID()");
   
   	
  
    %>
    
    <script>
		alert('수정이 완료되었습니다');
		location.href='board_list.jsp';
	</script>

</body>
</html>