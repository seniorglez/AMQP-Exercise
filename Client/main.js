const superagent = require('superagent');
const SockJS = require('sockjs-client');
const Stomp = require('stompjs');



const host = "localhost";
const port = "8080";

console.log(`Host: ${host}`);
console.log(`Port: ${port}`);

const listenProgress = () => {
  console.log(`Listening to the progress of task`);
  const stompClient = Stomp.over(new SockJS(`http://${host}:${port}/websocket`));
  stompClient.connect({}, function(frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe(`/task`, function(message) {
      const res = JSON.parse(message.body);
      if (res.result) {
        console.log(`Result: ${res.result}`);
        process.exit();
      }
      else console.log(`${res.progress}%`);
    });
  });
}

listenProgress();
