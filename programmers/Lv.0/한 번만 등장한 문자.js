// https://school.programmers.co.kr/learn/courses/30/lessons/120896
// 본인 풀이 - 알파벳 카운트 배열을 생성 + 아스키코드 활용
function solution(s) {
  const ASCII_CODE_a = 97
  const ALPHABET_SIZE = 26
  const alphabet = Array(ALPHABET_SIZE).fill(0)
  s.split('').forEach(item => {
    ++alphabet[item.charCodeAt(0) - ASCII_CODE_a]
  })
  return alphabet.reduce((acc, value, index) => {
    if (value === 1) {
      return acc += String.fromCharCode(index + ASCII_CODE_a)
    }
    return acc
  }, '')
}

// 다른 사람의 풀이 - indexOf, indexLastOf 를 활용해서 서로 다른 인덱스를 가지는 의미는 중복된 수가 존재한다는 의미
function solution(s) {
  let res = [];
  for (let c of s) if (s.indexOf(c) === s.lastIndexOf(c)) res.push(c);
  return res.sort().join('');
}