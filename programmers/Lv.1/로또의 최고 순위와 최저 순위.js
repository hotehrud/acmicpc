// https://school.programmers.co.kr/learn/courses/30/lessons/77484
// 본인 풀이
function solution(lottos, win_nums) {
  const zeroList = lottos.filter(value => value === 0)
  const myWinNums = lottos.filter(value => win_nums.includes(value))
  const rank = [6,6,5,4,3,2,1]

  return [rank[myWinNums.length + zeroList.length] , rank[myWinNums.length] ];
}

// 다른 사람의 풀이
function solution(lottos, win_nums) {
  const answer = [];
  const min = lottos.filter(n => win_nums.includes(n)).length;
  const max = lottos.filter(n => n === 0).length + min;

  max > 1 ? answer.push(7 - max) : answer.push(6);
  min > 1 ? answer.push(7 - min) : answer.push(6);

  return answer;
}