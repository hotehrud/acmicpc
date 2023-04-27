// https://school.programmers.co.kr/learn/courses/30/lessons/120839
// 본인 풀이
function solution(rsp) {
  return rsp.split('').map(item => {
    if (item === '2') {
      return '0'
    } else if (item === '0') {
      return '5'
    } else {
      return '2'
    }
  }).join('')
}

// 다른 사람의 풀이
function solution(rsp) {
  let arr = {
    2: 0,
    0: 5,
    5: 2
  };
  var answer = [...rsp].map(v => arr[v]).join("");
  return answer;
}
