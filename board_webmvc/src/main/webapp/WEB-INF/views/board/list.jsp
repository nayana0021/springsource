<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
 <!-- Page Heading -->
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
     <h1 class="h3 mb-0 text-gray-800">Board List</h1>
 </div>
 <div class="d-flex">
 	<!-- 검색 부분 -->
 	<div class="flex-grow-1 pb-2 justify-content-between">
 		<form action="">
 			<div class="form-row">
 				<div class="form-group col-3">
 					<select name="type" id="type" class="form-control">
 						<option value="">---------</option>
 						<option value="T">제목</option>
 						<option value="C">내용</option>
 						<option value="W">작성자</option>
 						<option value="TC">제목 or 내용</option>
 						<option value="TW">제목 or 작성자</option>
 						<option value="TCW">제목 or 내용 or 작성자</option>
 					</select>
 				</div>
 				<div class="form-group col-5">
 					<input type="text" name="keyword" id="keyword" class="form-control" />
 				</div>
 				<div class="form-group col-3">
 					<button type="button" class="btn btn-info">검색</button>
 				</div>
 			</div>
 		</form>
 	</div>
 	<!-- 검색 종료 -->
 	<div class="pb-2">
 		<button class="btn btn-xs btn-success" type="button" onclick="location.href='/board/register'">Register New Board</button> 
 	</div>
 </div>
<table class="table table-striped table-bordered table-hover">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
      <th scope="col">수정일</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="dto" items="${list}">
    <tr>
      <th scope="row">${dto.bno}</th>
      <td><a href="/board/read?bno=${dto.bno}">${dto.title}</a></td>
      <td>${dto.writer}</td>
      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.regDate}" /></td>
      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.updateDate}" /></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<!-- 페이지 나누기 시작 -->
<nav aria-label="...">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item active" aria-current="page">
      <a class="page-link" href="#">2</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>
<!-- 페이지 나누기 종료 -->
<%@ include file="../include/footer.jsp" %>