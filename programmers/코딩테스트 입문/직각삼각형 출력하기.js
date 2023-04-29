// https://school.programmers.co.kr/learn/courses/30/lessons/120823
// 본인 풀이
const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input = line.split(' ');
}).on('close', function () {
  let str = ''
  for(let i = 1; i <= Number(input[0]); i++) {
    for(let j = 1; j <= i; j++) {
      str += '*'
    }
    str += '\n'
  }
  console.log(str);
});

// 다른 사람의 풀이
const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input = line.split(' ');
}).on('close', function () {
  solution(Number(input[0]));
});

function solution(n) {
  for(let i = 1; i < n + 1; i++) {
    console.log('*'.repeat(i));
  }
}