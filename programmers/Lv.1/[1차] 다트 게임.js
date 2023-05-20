// https://school.programmers.co.kr/learn/courses/30/lessons/17682
// 본인 풀이
function solution(dartResult) {
  const BONUS = {
    S: 1,
    D: 2,
    T: 3
  }
  const OPTION = {
    '*': 2,
    '#': -1
  }
  const grade = dartResult.replaceAll(/[*#SDT]+/g, ' ').trim().split(' ')
  const bonus = dartResult.replaceAll(/[0-9*#]+/g, ' ').trim().split(' ')
  const option = dartResult.replaceAll(/[0-9]+/g, ' ').trim().split(' ').map(item => item[1])
  let ans = 0

  let prev = 0
  for(let i = 0; i < 3; i++) {
    const round = Math.pow(grade[i], BONUS[bonus[i]]) * (OPTION[option[i]] ?? 1)
    ans += round
    if (option[i] === '*') {
      ans += prev * OPTION['*'] - prev
    }
    prev = round
  }

  return ans;
}

// 다른 사람의 풀이 - \d === [0-9] 숫자, . 모든 문자 포함 , ? 있어도 되도 없어도 되고 , \D === [^0-9] 숫자 제외 문자, {m,}, {,n} m회 이상 반복, n회 이하 반복
function solution(dartResult) {
  const bonus = { 'S': 1, 'D': 2, 'T': 3 },
    options = { '*': 2, '#': -1, undefined: 1 };

  let darts = dartResult.match(/\d.?\D/g);

  for (let i = 0; i < darts.length; i++) {
    let split = darts[i].match(/(^\d{1,})(S|D|T)(\*|#)?/),
      score = Math.pow(split[1], bonus[split[2]]) * options[split[3]];

    if (split[3] === '*' && darts[i - 1]) darts[i - 1] *= options['*'];

    darts[i] = score;
  }

  return darts.reduce((a, b) => a + b);
}