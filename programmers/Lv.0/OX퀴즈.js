// https://school.programmers.co.kr/learn/courses/30/lessons/120907
// 본인 풀이
function solution(quiz) {
  const operator = {
    '+': (x, y) => Number(x) + Number(y),
    '-': (x, y) => Number(x) - Number(y),
  }

  return quiz.map((item) => {
    const [x, op, y, _, result] = item.split(' ')
    return operator[op](x, y) === Number(result) ? 'O' : 'X'
  })

}

// 다른 사람의 풀이 - +, - 를 1, -1 로 표현하여 곱하기와 함께 사용할 수 있음
function solution(quiz) {
  var answer = [];
  return quiz.map(t => {
    const [calc, result] = t.split(' = ');
    const sign = calc.includes('+') ? 1 : -1
    const [a, b] = calc.split(sign === 1 ? ' + ' : ' - ');

    return +a + (+b * sign) === +result ? 'O' : 'X'
  });
}
