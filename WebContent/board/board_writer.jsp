<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    
       
    <!--글쓰기만 적용되는 css-->   
    <style>
        .table-striped {
            text-align: center; 
            border: 2px solid #737373; 
        }

        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }
    </style>
</head>

<body>

<%@ include file="../include/header_pr.jsp" %>


    <section>
        <div class="container" style="margin-top: 5%;">
            <div class="row">
                <form action="/WebTemp/regist.board" method="post">
                    <table class="table table-striped" >
                        <thead>
                            <tr>
                                <th colspan="2" style="background-color: #9DCAFF; text-align: center;">게시판 글쓰기</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="text" class="form-control" placeholder="작성자" name="bWriter" maxlength="50" ></td>
                            </tr>
                            <tr>
                                <td><input type="text" class="form-control" placeholder="글 제목" name="bTitle" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td><textarea rows="15" class="form-control" placeholder="1000 글자 이하" name="bContent" maxlength="1000" ></textarea></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <input type="button" class="btn btn-primary pull-left" onclick="location.href='/WebTemp/boardlist.board'" value="목록">
                    <input type="submit" class="btn btn-primary pull-right"  value="글쓰기">
                </form>
            </div>
        </div>
    </section>

	<%@ include file="../include/footer_pr.jsp" %>    
 
 

</body>

</html>