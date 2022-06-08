<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<%-- BoardDAO dao = BoardDAO.getInstance();
	List<BoardVO> articles = dao.listBoard(); 
	request.setAttribute("bList", articles);--%>
<html>
    <head>
        
        <!--게시판만 적용되는 css-->            
        <style>

            .table-striped > tbody > tr {
                background-color: rgba(255, 255, 255)
            }
            .row h2 {
                color: aliceblue;
                
            }
            
            .pagination-sm {
                margin: 0;
            }
            
        </style>
    </head>

    <body>

	<%@ include file="../include/header_pr.jsp" %>
	
 
	        
    <section>
        
        <div class="container">
            <div class="row">
               <c:set var="listboard" value="${listBoard}"/>
                <h2>게시판 목록</h2>
                <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="background-color: #9DCAFF; text-align: center;">번호</th>
                            <th style="background-color: #9DCAFF; text-align: center;">제목</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성자</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성일</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="b" items="${bList}">
                        <tr>
                            <td>${b.boardID}</td>
                            <td>
                            	<a href="/WebTemp/content.board?bId=${b.boardID}">${b.title}</a>
                            </td>
                            <td>${b.writer}</td>
                            
                            <td>
                            	<fmt:formatDate value="${b.regDate}" pattern="yyyy년 MM월 dd일 a hh시 mm분"/>
                            </td>
                        </tr>
                      
									
                   </c:forEach>
                       
                    </tbody>
                </table>

                <div class="text-center">
                    <ul class="pagination pagination-sm">
                        <li><a href="#">이전</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">다음</a></li>
                    </ul>
                    <button class="btn btn-info pull-right" onclick="location.href='/WebTemp/write.board'">글쓰기</button>
                </div>
                
            </div>
        </div> 
    </section>

	<%@ include file="../include/footer_pr.jsp" %>

    </body>

</html>