// https://school.programmers.co.kr/learn/courses/30/lessons/147355
// 본인 풀이
function solution(t, p) {
  const len = p.length
  let ans = 0
  for(let i = 0; i < t.length; i++) {
    const str = t.slice(i, i + len)
    const [p1, p2] = [Number(str), Number(p)]
    if (str.length === len && p1 <= p2) {
      ++ans
    }
  }
  return ans;
}

// 다른 사람의 풀이 - 반복문은 t.length-p.length 줄일 수 있음, + 부호 붙이면 문자에서 숫자로 변환
function solution(t, p) {
  let count = 0;
  for(let i=0; i<=t.length-p.length; i++) {
    let value = t.slice(i, i+p.length);
    if(+p >= +value) count++;
  }
  return count;
}