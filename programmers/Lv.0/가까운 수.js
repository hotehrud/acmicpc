// https://school.programmers.co.kr/learn/courses/30/lessons/120890
// 본인 풀이 - 비교 대상을 배열에 함께 넣고 정렬 => 비교 대상의 인덱스 +-1 을 비교
function solution(array, n) {
  array.push(n)
  const index = array.sort((a, b) => {
    if (a < b) {
      return -1
    } else {
      return 1
    }
  }).findIndex(item => item === n)
  if (index === 0) {
    return array[index + 1]
  } else if (index === array.length - 1) {
    return array[array.length - 2]
  } else if (Math.max(array[index + 1] - array[index], array[index] - array[index - 1]) === array[index + 1] - array[index]) {
    return array[index - 1]
  } else {
    return array[index + 1]
  }
}

// 다른 사람의 풀이 - 정렬 조건 커스텀
function solution(array, n) {
  array.sort((a,b) => Math.abs(n - a) - Math.abs(n - b) || a - b);

  return array[0];
}