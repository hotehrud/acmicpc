// https://school.programmers.co.kr/learn/courses/30/lessons/120921
// 본인 풀이
function solution(A, B) {
  const splited = A.split('')
  let move = 0
  while(move < A.length) {
    if (splited.join('') === B) {
      return move
    }
    ++move
    splited.unshift(splited.pop())
  }
  return move === A.length ? -1 : move
}


// 다른 사람의 풀이 - 같은 문자열을 append 해서 찾기
let solution=(a,b)=>(b+b).indexOf(a)