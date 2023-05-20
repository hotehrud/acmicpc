// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// 본인 풀이
function solution(answers) {
  const [number1, number2, number3] = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ]
  const students = [
    [1, 0],
    [2, 0],
    [3, 0],
  ]

  answers.forEach((n, i) => {
    students[0][1] += n === number1[i % number1.length] ? 1 : 0
    students[1][1] += n === number2[i % number2.length] ? 1 : 0
    students[2][1] += n === number3[i % number3.length] ? 1 : 0
  })

  const sorted = students.sort((a, b) => {
    return b[1] - a[1] || a[0] - b[0]
  })
  return sorted
    .filter((item) => item[1] === sorted[0][1])
    .map((item) => item[0])
}

// 다른 사람의 풀이
function solution(answers) {
  var answer = [];
  const man1 = [1, 2, 3, 4, 5];
  const man2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const man3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  let count = [0, 0, 0];

  for(let i = 0; i < answers.length; i++) {
    if(answers[i] == man1[i % man1.length]) count[0]++;
    if(answers[i] == man2[i % man2.length]) count[1]++;
    if(answers[i] == man3[i % man3.length]) count[2]++;
  }

  const max = Math.max(count[0], count[1], count[2]);
  for(let i = 0; i < count.length; i++) {
    if(max == count[i]) answer.push(i + 1);
  }

  return answer;
}