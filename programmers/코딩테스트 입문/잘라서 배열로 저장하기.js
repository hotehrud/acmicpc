// https://school.programmers.co.kr/learn/courses/30/lessons/120913
// 본인 풀이
function solution(my_str, n) {
  return Array(Math.ceil(my_str.length / n)).fill().map((item, index) =>
    my_str.slice(index * n, (index + 1) * n),
  )
}
