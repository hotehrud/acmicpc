// https://school.programmers.co.kr/learn/courses/30/lessons/120876
// 본인 풀이 - 주어지는 숫자 범위만큼의 cnt 배열 활용
function solution(lines) {
  const cnt = Array(201).fill(0)
  lines.forEach(line => {
    const start = line[0] + 100
    const end = line[1] + 100
    for(let i = start; i < end; i++) {
      ++cnt[i]
    }
  })

  return cnt.reduce((acc, value) => {
    return value > 1 ? acc + 1 : acc
  }, 0);
}