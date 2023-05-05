// https://school.programmers.co.kr/learn/courses/30/lessons/134240
// 본인 풀이
function solution(food) {
  food.shift()
  const order = [...food].map((item, idx) => Array(Math.floor(item / 2)).fill(idx + 1)).flat()
  return order.join('') + '0' + order.reverse().join('')
}

// 다른 사람의 풀이
function solution(food) {
  let res = '';
  for (let i = 1; i < food.length; i++) {
    res += String(i).repeat(Math.floor(food[i]/2));
  }

  return res + '0' + [...res].reverse().join('');
}