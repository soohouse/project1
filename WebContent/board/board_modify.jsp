<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
       
       <%--
       	int bID = Integer.parseInt(request.getParameter("bId"));
       	BoardVO vo = BoardDAO.getInstance().contentBoard(bID);
       
       
       --%>


</head>
<body>


 <%@ include file="../include/header_pr.jsp" %>
  
    
     <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 수정<small>(디자인이궁금하세요?)</small></h2>
				
                    <form action="/WebTemp/update.board" method="post">
                        <div class="form-group">
                            <label>글번호 : </label>
                            <input type="text" class="form-control" value="${article.boardID}" name="bId" readonly>
                        </div>
                        <div class="form-group">
                            <label>글쓴이 : </label>
                            <input type="text" class="form-control" placeholder="자유" value="${article.writer}" name="bWriter">
                        </div>
                        <div class="form-group">
                            <label>제목 : </label>
                            <input type="text" class="form-control" placeholder="자유" value="${article.title}" name="bTitle"">
                        </div>
                        <div class="form-group">
                            <label>내용 : </label>
                            <textarea class="form-control" rows="5" name="bContent" >${article.content}</textarea>
                        </div>

                        <!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='/WebTemp/boardlist.board'">목록</button>
                            <button type="submit" class="btn btn-info"  onclick="return confirm('수정하시겠습니까?')">수정</button>
                            
                        </div>

                    </form>
                </div>
            </div>
        </div>


        </section>
    
 <%@ include file="../include/footer_pr.jsp" %>
</body>
</html>