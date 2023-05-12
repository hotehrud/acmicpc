// https://school.programmers.co.kr/learn/courses/30/lessons/81301
// 본인 풀이
function solution(s) {
  const code = {
    zero: 0,
    one: 1,
    two: 2,
    three: 3,
    four: 4,
    five: 5,
    six: 6,
    seven: 7,
    eight: 8,
    nine: 9
  }
  let str = s
  Object.keys(code).forEach(item => {
    str = str.replaceAll(item, code[item])
  })
  return +str
}

// 다른 사람의 풀이
function solution(s) {
  let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
  var answer = s;

  for(let i=0; i< numbers.length; i++) {
    let arr = answer.split(numbers[i]);
    answer = arr.join(i);
  }

  return Number(answer);
}

// 다른 사람의 풀이
for(let [key, value] of Object.entries(charSet)) {
  let re = new RegExp(`${key}`,"g");
  s = s.replace(re, value);
}