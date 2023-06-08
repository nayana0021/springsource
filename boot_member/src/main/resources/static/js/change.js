/**
 * 	기존 비밀번호, 새비밀번호, 새비밀번호 확인 내용 비어 있지 않도록 확인
 * 	새비밀번호화 새비밀번호 확인 동일한가?
 */

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
	
	
	const curPwd = document.querySelector("#floatingPassword1");
	const newPwd = document.querySelector("#floatingPassword2");
	const confirmPwd = document.querySelector("#floatingPassword3");
	
	if(curPwd.value === ""){
		alert("현재 비밀번호를 확인해주세요");
		curPwd.select();
		return;
	}else if(newPwd.value === ""){
		alert("새 비밀번호를 확인해주세요");
		newPwd.select();
		return;
	}else if(confirmPwd.value ===""){
		alert("새 비밀번호확인을 엥 확인해주세요");
		confirmPwd.select();
		return;
	}
	
	if(newPwd.value !== confirmPwd.value){
		alert("새 비밀번호와 새비밀번호 확인이 일치하지 않습니다");
		confirmPwd.select();
		return;
	}
	
/*const cpwd = document.querySelector("#floatingPassword1");
const npwd = document.querySelector("#floatingPassword2");
const cnpwd = document.querySelector("#floatingPassword3");
	
	if(cpwd.value === "" ){
		console.log(cpwd.value);
		alert("현재비밀번호를 입력해주세요")
		cpwd.focus();
		return;
	}else if(npwd.value === ""){
		alert("새비밀번호를 입력해주세요")
		npwd.focus();
		return;
	}else if(cnpwd.value === ""){
		alert("새비밀번호확인을 입력해주세요")
		cnpwd.focus();
		return;
	}
*/	
	
	form.submit();
})
