// https://school.programmers.co.kr/learn/courses/30/lessons/120902
// 본인 풀이
function solution(my_string) {
  const splited = my_string.split(' ')
  const operator = {
    '+': (value) => value,
    '-': (value) => -value
  }

  let index = 1
  let sum = Number(splited[0])
  while(index < splited.length) {
    sum += operator[splited[index]](Number(splited[index + 1]))
    index += 2
  }
  return sum
}

// 다른 사람의 풀이 - 스택 활용
function solution(my_string) {
  const stack = [];

  let sign = 1;
  for (const ch of my_string.split(" ")) {
    if (ch === "+") {
      sign = 1;
    } else if (ch === "-") {
      sign = -1;
    } else {
      stack.push(ch * sign);
    }
  }

  return stack.reduce((a,b) => a + b, 0);
}
