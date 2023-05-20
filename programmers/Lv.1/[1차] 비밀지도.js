// https://school.programmers.co.kr/learn/courses/30/lessons/17681
// 본인 풀이
function solution(n, arr1, arr2) {
  const map1 = arr1.map(item => `000000000000000${item.toString(2)}`.slice(-n))
  const map2 = arr2.map(item => `000000000000000${item.toString(2)}`.slice(-n))
  let ans = Array(n).fill('')

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      ans[i] += map1[i][j] === '1' || map2[i][j] === '1' ? '#' : ' '
    }
  }
  return ans
}

// 다른 사람의 풀이 - OR 연산자 === | , /1|0/g => 1 또는 0 정규식을 통해 맵 그리기
function solution(n, arr1, arr2) {
  return arr1.map((v, i) => addZero(n, (v | arr2[i]).toString(2)).replace(/1|0/g, a => +a ? '#' : ' '));
}

const addZero = (n, s) => {
  return '0'.repeat(n - s.length) + s;
}
