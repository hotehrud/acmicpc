// https://school.programmers.co.kr/learn/courses/30/lessons/12926
// 본인 풀이
function solution(s, n) {
  const LENGTH = 26
  const lower = ['a'.charCodeAt(), 'z'.charCodeAt()]
  const upper = ['A'.charCodeAt(), 'Z'.charCodeAt()]
  const lowerArray = Array(LENGTH).fill(lower[0]).map((v, i) => String.fromCharCode(v + i))
  const upperArray = Array(LENGTH).fill(upper[0]).map((v, i) => String.fromCharCode(v + i))
  return s.split('').map(str => {
    const next = str.charCodeAt() + n
    if (str === ' ') {
      return ' '
    } if (str.charCodeAt() > upper[1]) {
      return lowerArray[(next - lower[0]) % LENGTH]
    } else {
      return upperArray[(next - upper[0]) % LENGTH]
    }
  }).join('')
}

// 다른 사람의 풀이
function solution(s, n) {
  var upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  var lower = "abcdefghijklmnopqrstuvwxyz";
  var answer= '';

  for(var i =0; i <s.length; i++){
    var text = s[i];
    if(text == ' ') {
      answer += ' ';
      continue;
    }
    var textArr = upper.includes(text) ? upper : lower;
    var index = textArr.indexOf(text)+n;
    if(index >= textArr.length) index -= textArr.length;
    answer += textArr[index];
  }
  return answer;
}