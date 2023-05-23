/**
 * 버튼 클릭 시 도서 전체 목록 가져오기
 *
 * 화면 깜빡임 없이 데이터 가져오기 => ajax
 *
 * ajax : fetch, jquery, axios
 */

document.querySelector(".btn-primary").addEventListener("click", () => {
  // fetch("경로").then(서버로부터 데이터 받기(적절한 타입으로 변환)).then(화면출력).catch(에러);

  fetch("/list")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      // 내용 보여줄 위치 가져오기
      const content = document.querySelector(".table tbody");
      let str = "";
      data.forEach((item) => {
        str += "<tr>";
        str += "<th scope='row'>" + item.code + "</th>";
        str += "<td>" + item.title + "</td>";
        str += "<td>" + item.writer + "</td>";
        str += "<td>" + item.price + "</td>";
        str += "</tr>";
      });
      content.innerHTML = str;
    })
    .catch((error) => console.log(error));
});

document.querySelector(".btn-info").addEventListener("click", () => {
  // 사용자가 입력한 코드 가져오기
  const code = document.querySelector("#code1").value;

  fetch("/" + code)
    .then((response) => {
      if (!response.ok) {
        throw new Error("url 확인");
      }
      return response.json();
    })
    .then((item) => {
      const content = document.querySelector(".table tbody");
      let str = "<tr>";
      str += "<th scope='row'>" + item.code + "</th>";
      str += "<td>" + item.title + "</td>";
      str += "<td>" + item.writer + "</td>";
      str += "<td>" + item.price + "</td>";
      str += "</tr>";

      content.innerHTML = str;
    })
    .catch((error) => console.log(error));
});

// 폼 서브밋 시 기존 기능 중지
const form = document.querySelector("#insertForm");

form.addEventListener("submit", (e) => {
  e.preventDefault(); //submit 중지

  // 폼 안의 데이터 가져오기
  // 자바스크립트 객체로 생성
  // {code:'1001', price:25000}
  let data = {
    code: document.querySelector("#code").value,
    title: document.querySelector("#title").value,
    writer: document.querySelector("#writer").value,
    price: document.querySelector("#price").value,
    description: document.querySelector("#description").value,
  };

  // JSON.stringify() : 자바스크립트 객체를 json 형태로 변환
  fetch("/create", {
    method: "post",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("데이터 확인");
      }
      return response.text();
    })
    .then((data) => {
      if (data === "success") {
        alert("입력 성공");
      }
    })
    .catch((error) => alert(error));
});

// 삭제 버튼 클릭 시 code 가져온 후 삭제
document.querySelector(".btn-danger").addEventListener("click", () => {
  // 입력한 코드 가져오기
  const code = document.querySelector("#code1").value;

  fetch("/" + code, {
    method: "delete",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("데이터 확인");
      }
      return response.text();
    })
    .then((data) => {
      if (data === "success") {
        alert("삭제 성공");
      }
    })
    .catch((error) => alert(error));
});

const updateForm = document.querySelector("#updateForm");

updateForm.addEventListener("submit", (e) => {
  e.preventDefault();

  // updateForm 안의 데이터 가져와서 자바스크립트 객체로 생성
  let data = {
    code: document.querySelector("#code2").value,
    price: document.querySelector("#price2").value,
  };

  fetch("/update", {
    method: "PUT",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("데이터 확인");
      }
      return response.text();
    })
    .then((data) => {
      if (data === "success") {
        alert("수정 성공");
      }
    })
    .catch((error) => alert(error));
});
