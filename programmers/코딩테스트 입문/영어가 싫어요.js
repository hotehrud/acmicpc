// https://school.programmers.co.kr/learn/courses/30/lessons/120894
// 본인 풀이
function solution(numbers) {
  return Number(
    [
      'zero',
      'one',
      'two',
      'three',
      'four',
      'five',
      'six',
      'seven',
      'eight',
      'nine',
    ].reduce((acc, value, index) => {
      return acc.replaceAll(value, index)
    }, numbers),
  )
}

// 다른 사람의 풀이 - replace 정규식과 콜백 활용 예제 => replace(‘’, (v) => obj[v])
function solution(numbers) {
  const obj = {
    zero: 0, one: 1, two: 2, three: 3, four: 4,
    five: 5, six: 6, seven: 7, eight: 8, nine: 9
  };

  const num = numbers.replace(/zero|one|two|three|four|five|six|seven|eight|nine/g, (v) => {
    return obj[v];
  });

  return Number(num);
}