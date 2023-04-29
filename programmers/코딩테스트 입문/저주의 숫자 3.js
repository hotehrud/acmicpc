// https://school.programmers.co.kr/learn/courses/30/lessons/120871
// 본인 풀이
function solution(n) {
  let array = Array(101)
  let index = 1
  let value = 1
  while(index <= 100) {
    if (value % 3 !== 0 && value.toString().split('3').join('') === value.toString()) {
      array[index] = value
      ++index
    }
    ++value
  }
  return array[n]
}

// 다른 사람의 풀이 - 숫자 3을 includes 로 활용
function solution(n) {
  let arr = [];
  let num = 0;
  while (arr.length !== n && ++num) if (num%3!==0 && !(''+num).includes('3')) arr.push(num);
  return arr.pop();
}