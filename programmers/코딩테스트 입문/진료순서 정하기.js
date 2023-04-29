// https://school.programmers.co.kr/learn/courses/30/lessons/120835
// 본인 풀이
function solution(emergency) {
  const desc = [...emergency].sort((a ,b) => b - a)
  return emergency.map(target => desc.findIndex(value =>  target === value) + 1)
}

// 다른 사람의 풀이 - slice() 를 활용해서 새로운 배열 생성
function solution(emergency) {
  let sorted = emergency.slice().sort((a,b)=>b-a);
  return emergency.map(v=>sorted.indexOf(v)+1);
}