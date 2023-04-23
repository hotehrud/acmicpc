// https://school.programmers.co.kr/learn/courses/30/lessons/120892
// 본인 풀이
function solution(cipher, code) {
  return cipher.split('').filter((_, index) => (index + 1) % code === 0).join('');
}

// 다른 사람의 풀이 - 반복문을 배수만큼 i 를 증가시키면서 문자열 append 방식으로 하면 탐색 횟수를 줄일 수 있음
function solution(cipher, code) {
  var answer = "";
  for (let i = code - 1; i < cipher.length; i += code) {
    answer += cipher[i];
  }
  return answer;
}