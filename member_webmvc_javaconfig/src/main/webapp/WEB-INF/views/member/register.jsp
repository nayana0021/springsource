<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<h1>회원 가입</h1>
	<!-- novalidate : html5 유효성 검증 사용하지 않겠음
		required, maxlength, max, min, email(@있는지 검사), url 
	 -->
<form action='<c:url value="/member/register"/>' method="post" novalidate>
  <div class="mb-3">
    <label for="userid" class="form-label">아이디</label>
		 <div class="row">
	    	<div class="col">
	    		<input type="text" class="form-control" id="userid" name="userid" placeholder="아이디" required pattern="^(?=[A-Za-z])(?=.*\d)(?=.*[!@#$%])[A-Za-z\d!@#$%]{5,12}$">
		   		 <div class="invalid-feedback">
				    	아이디를 확인해 주세요
			    </div>
	    	</div>
		    <div class="col-2">
    			<button type="button" class="w-100 btn btn-danger">중복아이디</button>
	    	</div>
		   </div>
	  </div>
		  
	    <div class="mb-3">
	    <label for="password" class="form-label">비밀번호</label>		<!-- 아이디 비밀번호 차이점 ?= 뒤에 .* 이 들어와서 비밀번호는 모든 문자로 시작해도 됨 아이디는 영어로만 시작해야됨  -->
	    <input type="text" class="form-control" id="password" name="password" placeholder="비밀번호" required pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%])[A-Za-z\d!@#$%]{5,15}$">
   	    <div class="invalid-feedback">
	    	비밀번호를 확인해 주세요
	    </div>
	  </div>
	  <div class="mb-3">
	    <label for="name" class="form-label">이름</label>
	    <input type="text" class="form-control" id="name" name="name" placeholder="이름" required pattern="^[가-힣]{2,5}$">
 	    <div class="invalid-feedback">
	    	이름을 확인해 주세요
	    </div>
	  </div>
	  <div class="mb-3">
	    <label for="gender" class="form-label">성별</label>
	    <input type="radio" name="gender" id="" value="남" class="form-check-input" required/>남
	    <input type="radio" name="gender" id="" value="여" class="form-check-input" required/>여
   	    <div class="invalid-feedback">
	    	성별을 선택해 주세요
	    </div>
	  </div>
	  	  <div class="mb-3"><!-- 상세한 검증은 js 에 해야함 -->
	    <label for="email" class="form-label">이메일</label> <!-- type="eamil"은 hon@n 까지만 확인할수있음 이메일 정규식 표현 찾아서 나중에 해봠 -->
	   	<input type="email" class="form-control" id="email" name="email" placeholder="이메일" required/>
 		 <div class="invalid-feedback">
	    	이메일을 확인해 주세요
	    </div>
	  </div> 
	  	<button type="submit" class="btn btn-primary">회원가입</button>
	  	<button type="button" class="btn btn-success">취소</button>
</form>
<script>
	const path = '<c:url  value="/list.do" />';
</script>
	  <script src='<c:url value="/resources/js/register.js" />'></script>   
<%@ include file="../include/footer.jsp" %>
