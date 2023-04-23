// https://school.programmers.co.kr/learn/courses/30/lessons/120887
// 본인 풀이
function solution(i, j, k) {
  const str = Array(j - i + 1).fill(i).map((v, i) => v + i).join('')
  return str.length - str.replaceAll(k, '').length
}

// 다른 사람의 풀이 - 특정 문자열 기준으로 분리
function solution(i, j, k) {
  let a ='';
  for(i;i<=j;i++){
    a += i;
  }

  return a.split(k).length-1;
}