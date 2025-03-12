/* text_iife.js */
// 텍스트 작성과 삭제 즉시 실행 함수
(function(){
  const spanEl = document.querySelector("main h2 span");
  const txtArr = ['Web Publisher', 'Front-End Developer', 'Web UI Designer', 'UX Designer', 'Back-End Developer'];
  let index = 0;
  let currentTxt = txtArr[index].split("");
  function writeTxt(){
    spanEl.textContent  += currentTxt.shift(); 
    if(currentTxt.length !== 0){ 
      setTimeout(writeTxt, Math.floor(Math.random() * 100));
    }else{
      currentTxt = spanEl.textContent.split("");
      setTimeout(deleteTxt, 3000);
    }
  }
  function deleteTxt(){
    currentTxt.pop();
    spanEl.textContent = currentTxt.join("");
    if(currentTxt.length !== 0){
      setTimeout(deleteTxt, Math.floor(Math.random() * 100))
    }else{
      index = (index + 1) % txtArr.length;
      currentTxt = txtArr[index].split("");
      writeTxt();
    }
  }
  writeTxt();
})();
/* end text_iife.js */



/* move.js 
  <button data-animation-scroll="true" data-target="#about">*/
/* 애니메이션 스크롤 이동 */
const animationMove = function(selector){
  // ① selector 매개변로 이동할 대상 요소 노드 가져오기
  const targetEl = document.querySelector(selector);
  // ② 현재 브라우저의 스크롤 정보(y 값)
  const browserScrollY = window.pageYOffset;
  // ③ 이동할 대상의 위치(y 값)
  const targetScorllY = targetEl.getBoundingClientRect().top + browserScrollY;
  // ④ 스크롤 이동
  window.scrollTo({ top: targetScorllY, behavior: 'smooth' });
};
// 스크롤 이벤트 연결하기
const scollMoveEl = document.querySelectorAll("[data-animation-scroll='true']"); 
for(let i = 0; i < scollMoveEl.length; i++){
  scollMoveEl[i].addEventListener('click', function(e){
    const target = this.dataset.target;
    animationMove(target);
  });
}
/* End move.js */

/*
  유효성 검사 사이트
  validator.w3.org  html 요효성검사
   jigsaw.w3.org/css-validator


*/