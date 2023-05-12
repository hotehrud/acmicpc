// https://school.programmers.co.kr/learn/courses/30/lessons/82612
// 본인 풀이
function solution(price, money, count) {
  const array = [0]

  for(let i = 1; i <= count; i++) {
    array[i] = array[i - 1] + price * i
  }

  return array[count] > money ? array[count] - money : 0
}

// 다른 사람의 풀이 - 가우스 공식
function solution(price, money, count) {
  const tmp = price * count * (count + 1) / 2 - money;
  return tmp > 0 ? tmp : 0;
}