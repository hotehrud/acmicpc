// https://school.programmers.co.kr/learn/courses/30/lessons/12948
// 본인 풀이
function solution(phone_number) {
  return '*'.repeat(phone_number.length - 4) + phone_number.slice(-4);
}

// 다른 사람의 풀이
function hide_numbers(s){
  return s.replace(/\d(?=\d{4})/g, "*");
}