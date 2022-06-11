<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<%--
	int bId = Integer.parseInt(request.getParameter("bId"));
	BoardVO vo = BoardDAO.getInstance().contentBoard(bId);
	
	
	--%>
	
	<%--
		board content 연결되는지 확인하고, 수정하기
	 --%>
	
	
    
<!DOCTYPE html>
<html lang="en">
<head>
       

</head>
<body>




 <%@ include file="../include/header_pr.jsp" %>
    
     <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 상세보기<small>(디자인이궁금하세요?)</small></h2>
				<c:set var="vo" value="${vo}"/>
                    <form action="board_list.jsp">
                        <div class="form-group">
                            <label>등록일: </label>
                            <fmt:formatDate value="${vo.regDate}" pattern="yyyy년 MM월 dd일 a hh시 mm분"/> 
                            <input type="text" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>글번호:</label>
                       
                            <input type="text" class="form-control" name="bId" value="${vo.bId}" readonly>
                        </div>
                        <div class="form-group">
                            <label>글쓴이:</label>
                            <input type="text" class="form-control" placeholder="글쓴이" name="bWriter" value="${vo.writer}">
                        </div>
                        <div class="form-group">
                            <label>제목:</label>
                            <input type="text" class="form-control" placeholder="제목" name="bTitler" value="${vo.title}">
                        </div>
                        <div class="form-group">
                            <label>내용: </label>
                            <textarea class="form-control" rows="5" name="bContent" >${vo.content}</textarea>
                        </div>
                        
                        <!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='/WebTemp/board_list.jsp';">목록</button>
                            <button type="button" class="btn btn-info" onclick="location.href=/WebTemp/board_modify.jsp?bId=${vo.bId}';" >수정</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>


        </section>
        
        
    
        <%@ include file="../include/footer_pr.jsp" %>
        
      
    
</body>
</html>