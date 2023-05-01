// https://school.programmers.co.kr/learn/courses/30/lessons/140108
// 본인 풀이
function solution(s) {
  let [x, y, i] = [0, 0, 0]
  return [...s].reduce((acc, val, idx) => {
    s[i] === val ? x += 1 : y += 1
    if (x === y) {
      x = 0
      y = 0
      i = idx + 1
      return acc + 1
    }
    if (idx === s.length - 1) {
      return acc + 1
    }
    return acc
  }, 0)
}

// 다른 사람의 풀이 - 하나의 카운트 => 시작할때 1, 같은 문자 나오면 증가 + 다른 문자 나오면 감소 => 0 이 되는 순간이 문제 조건
function solution(s) {
  let answer = 0;
  let current;
  let count = 0;

  for(let i = 0; i < s.length; i++) {
    if(count === 0) {
      answer++;
      current = s[i]
      count = 1
    } else {
      if(current !== s[i]) count--;
      else count++;
    }
  }

  return answer;
}