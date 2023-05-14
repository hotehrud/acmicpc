  // https://school.programmers.co.kr/learn/courses/30/lessons/42889
// 본인 풀이
function solution(N, stages) {
  const stage = Array(N + 2).fill(0)
  const failure = Array(N + 1).fill([0, 0])
  let tryCount = 0
  stages.forEach(n => {
    stage[n] += 1
  })

  for(let i = N; i > 0; i--) {
    tryCount += stage[i + 1]
    failure[i] = [i, stage[i] / (stage[i] + tryCount)]
  }
  return failure.slice(1).sort((a, b) => b[1] - a[1] || a[0] - b[0]).map(item => item[0])
}

// 다른 사람의 풀이
function solution(N, stages) {
  let result = [];
  for(let i=1; i<=N; i++){
    let reach = stages.filter((x) => x >= i).length;
    let curr = stages.filter((x) => x === i).length;
    result.push([i, curr/reach]);
  }
  result.sort((a,b) => b[1] - a[1]);
  return result.map((x) => x[0]);
}