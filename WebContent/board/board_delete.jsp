<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>

<%
	int bId = Integer.parseInt(request.getParameter("bId"));
	BoardDAO.getInstance().deleteBoard(bId);
%>

<script>
	alert('삭제가 완료되었습니다.');
	location.href = 'board_list'.jsp';
</script>

</body>
</html>