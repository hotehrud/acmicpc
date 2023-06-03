// https://school.programmers.co.kr/learn/courses/30/lessons/12916
// 본인 풀이
function solution(s){
  const [p, y] = s.toLowerCase().split('').reduce((acc, val) => {
    val === 'p' && ++acc[0]
    val === 'y' && ++acc[1]
    return acc
  }, [0, 0])
  return p === y ? true : false
}

// 다른 사람의 풀이
function solution(s){
  return s.toUpperCase().split("P").length === s.toUpperCase().split("Y").length;
}