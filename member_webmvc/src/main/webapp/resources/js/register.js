/**
 * 	폼 모든 요소가 비어있는지 확인 하나라도 비어있다면 못 가게 막기
 */

	
	const form = document.querySelector("form");
	
	form.addEventListener("submit", (e)=>{
		if(!form.checkValidity()){
			e.preventDefault();
			e.stopPropagation();
		}
		
		form.classList.add("was-validated");
	})
// 부트스트랩 이용

document.querySelector(".btn-danger").addEventListener("click", ()=>{
	//사용자가 입력한 userid 가져오기
	const userid = document.querySelector("#userid").value;
	
	// , {} 콤마하고 중괄호쓰면 문장 여러개라는 뜻이고 method post 로 보내고 
	// 키:밸류 형식으로 userid 객체 생성
	fetch("dupId.do",{
		method:"post",
		body: new URLSearchParams({userid:userid})
		
	})
	.then((response) => response.text())
	.then((result) => {
		console.log(result);
		if(result.trim() === "true"){
			alert("아이디를 사용할 수 있습니다");
		}else{
			alert("아이디를 사용할 수 없습니다");
		}
	});
		
})




/*	const form = document.querySelector("form");
	
 	form.addEventListener("submit", (e) => {
		 e.preventDefault();
		 
	const id = document.querySelector("#userid");
	const pwd = document.querySelector("#password");
	const name = document.querySelector("#name");
	const gdr = document.querySelector('input[name="gender"]');
	const eml = document.querySelector("#email");
	
	if(id.value === ""){
		alert("아이디를 입력해 주세요")
		id.focus();
		return;
	}else if(pwd.value === ""){
		alert("비밀번호를 입력해 주세요")
		 pwd.focus();
		 return;
	 }else if(name.value === ""){
		 alert("이름을 입력해 주세요")
		 name.focus();
		 return;
	 }else if(gdr.value === ""){
		 alert("성별을 입력해 주세요")
		 gdr.focus();
		 return;
	 }else if(eml.value === ""){
		 alert("이메일을 입력해 주세요")
		 eml.focus();
		 return;
	 }
		 
		form.submit();
		 
		 
	 })*/