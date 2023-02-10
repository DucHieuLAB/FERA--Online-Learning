const questions = document.getElementsByClassName("question");
const time = document.getElementById("time");
const result = document.getElementById("result");
const result_form = document.getElementById("result-form");
const btn_next = document.getElementById("btn_next");
const btn_previous = document.getElementById("btn_previous");
var minutes, seconds, duration;
var currentIndex = 0;

function TimeCouting() {
    minutes = parseInt(duration / 60, 10);
    seconds = parseInt(duration % 60, 10);
    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;
    time.textContent = minutes + ":" + seconds;
    if (duration === 0) {
        //duration equal 0 then submit result then return
        submitResult();
        return;
    }
    duration--;
}

function startTimer(time) {
    setInterval(TimeCouting, 1000);
}

function getResult() {
    var rs = "";
    var inputAnswers = document.querySelectorAll('.ans-form');
    for (var i = 0; i < inputAnswers.length; i++) {
        if (inputAnswers[i].checked) {  
            rs += inputAnswers[i].value + "-";
        }
    }
    return rs;
}

function submitResult() {
    result.value = getResult();
    result_form.submit();
}

window.onload = function () {
    questions[currentIndex].style.display = 'block';
    var timelabel = time.textContent;
    duration = parseInt(timelabel.substr(0, 2), 10) * 60 + parseInt(timelabel.substr(3, 2), 10);
    startTimer(duration--, time);
};

function previousQuestion() {
    if (currentIndex == 1) {
        btn_previous.style.display = 'none';
    }
    if (currentIndex <= questions.length - 1) {
        btn_next.textContent = "Next";
    }
    questions[currentIndex].style.display = 'none';
    questions[currentIndex - 1].style.display = 'block';
    currentIndex--;

}

function nextQuestion() {
    if (currentIndex == questions.length - 1) {
        if (confirm('Finish Quiz ?')) {
            submitResult();
        }

    } else {
        if (currentIndex >= 0) {
            btn_previous.style.display = 'inline-block';
        }
        if (currentIndex == questions.length - 2) {
            btn_next.textContent = "Finish";
        }
        questions[currentIndex].style.display = 'none';
        questions[currentIndex + 1].style.display = 'block';
        currentIndex++;
    }
}