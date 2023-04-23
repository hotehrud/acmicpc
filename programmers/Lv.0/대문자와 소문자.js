// https://school.programmers.co.kr/learn/courses/30/lessons/120893
// 본인 풀이
function solution(my_string) {
  return my_string.split('').map(item => {
    const code = item.charCodeAt(0)
    return 97 <= code && code <= 122 ? item.toUpperCase() : item.toLowerCase()
  }).join('')
}

// 다른 사람의 풀이 - 아스키코드 활용할 필요 없이 소문자인지 대문자인지만 판단하면 됨 v === v.toLowerCase()
function solution(my_string) {
  var answer = '';
  for (let c of my_string) answer += c === c.toLowerCase() ? c.toUpperCase() : c.toLowerCase();
  return answer;
}