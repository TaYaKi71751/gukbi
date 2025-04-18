window.onload = function () {
    //var img=['img/1.jpg','img/2.jpg','img/3.jpg'];
    var sliderImgs = document
        .getElementById("mySlider")
        .getAttribute("data-imglist");
    //슬라이더에서 사용할 이미지 배열 제작
    sliderImgs = JSON.parse(sliderImgs);
    console.log(sliderImgs);
    console.log(sliderImgs[0]);
    // 슬라이더를 실행할 이미지 얻어오기
    var mySlider = document.getElementById("holder");
    var index = 0;
    document.getElementById("prev").addEventListener("click",
        function () {
            if (index == 0) {
                index = sliderImgs.length;
            }
            index = index - 1;
            mySlider.src = sliderImgs[index];
            //mySlider.src=sliderImgs[--index];
            // alert(mySlider.src+ “:”+index) src 와 index 정보확인
            // 기본 이벤트가 있을때 무시하고 싶으면 리턴값을 false 로 한다.
            return false;
        })
    document.getElementById("next").addEventListener("click", function () {
        index = index + 1;
        index = index % sliderImgs.length;
        //index=++index%sliderImgs.length;
        mySlider.src = sliderImgs[index];
    })
}
