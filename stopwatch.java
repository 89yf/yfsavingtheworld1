let timer = null;
let milliseconds = 0;
let seconds = 0;
let minutes = 0;

function startStopwatch() {
  if (timer !== null) return;
  timer = setInterval(updateStopwatch, 10);
}

function stopStopwatch() {
  clearInterval(timer);
  timer = null;
}

function resetStopwatch() {
  clearInterval(timer);
  timer = null;
  milliseconds = 0;
  seconds = 0;
  minutes = 0;
  updateDisplay();
}

function updateStopwatch() {
  milliseconds += 10;
  if (milliseconds === 1000) {
    seconds++;
    milliseconds = 0;
  }
  if (seconds === 60) {
    minutes++;
    seconds = 0;
  }
  updateDisplay();
}

function updateDisplay() {
  let displayElement = document.getElementById("display");
  let millisecondsDisplay = (milliseconds < 10 ? "00" : milliseconds < 100 ? "0" + Math.floor(milliseconds / 10) : Math.floor(milliseconds / 10));
  let secondsDisplay = (seconds < 10 ? "0" + seconds : seconds);
  let minutesDisplay = (minutes < 10 ? "0" + minutes : minutes);
  displayElement.textContent = minutesDisplay + ":" + secondsDisplay + ":" + millisecondsDisplay;
}
