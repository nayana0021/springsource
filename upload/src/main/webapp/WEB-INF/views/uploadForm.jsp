<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form 안 file 요소가 존재 시 enctype 변경 -->
	<form action="" method="post" enctype="multipart/form-data"> 
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name" />
		</div>
		<div>
			<label for="file">file</label>
			<input type="file" name="file" id="file" multiple accept="image/*, .txt"/> <!-- multiple 파일 여러개 첨부 가능 -->
		</div><!-- accept 첨부할 수 있는 파일을 제한할 수 있다 (accept="image/*, .txt" : 파일 첨부시 이미지와 txt만 뜨게 된다 -->
		<div>
			<button type="submit">submit</button>
		</div>
	</form>
</body>
</html>