// https://school.programmers.co.kr/learn/courses/30/lessons/120824
// 본인 풀이
function solution(num_list) {
  const items = [...num_list]
  const even = items.filter(item => item % 2 === 0).length
  return [even, num_list.length - even];
}

// 다른 사람의 풀이
function solution(num_list) {
  var answer = [0,0];

  for(let a of num_list){
    answer[a%2] += 1
  }

  return answer;
}
