// https://school.programmers.co.kr/learn/courses/30/lessons/12918
// 본인 풀이
function solution(s) {
  const len = s.length
  if ((len === 4 || len === 6 ) && s.match(/\d/g).length === len) {
    return true
  } else {
    return false
  }
}

// 다른 사람의 풀이
function alpha_string46(s){
  var regex = /^\d{6}$|^\d{4}$/;

  return regex.test(s);
}

function alpha_string46(s) {
  return s.length == 4 || s.length == 6 ? !isNaN(s) : false
}