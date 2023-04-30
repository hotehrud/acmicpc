// https://school.programmers.co.kr/learn/courses/30/lessons/161989
// 본인 풀이
function solution(n, m, section) {
  let idx = 0
  let cnt = 0
  while (idx < section.length) {
    const end = section[idx] + m - 1
    for (; idx <= section.length; idx++) {
      if (section[idx] > end) {
        break
      }
    }
    ++cnt
  }
  return cnt
}

// 다른 사람의 풀이
function solution(n, m, sections) {
  var answer = 0;
  var painted = 0;
  for(var section of sections) {
    if(painted < section) {
      answer++;
      painted = section+m-1;
    }
  }
  return answer;
}