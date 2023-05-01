// https://school.programmers.co.kr/learn/courses/30/lessons/155652
// 본인 풀이
function solution(s, skip, index) {
  const alphabets = Array(122 - 97 + 1)
    .fill(97)
    .map((val, idx) => String.fromCharCode(val + idx))
    .filter((item) => !skip.includes(item))
  const map = alphabets.reduce((acc, val, idx) => {
    acc[val] = idx
    return acc
  }, {})
  return s
    .split('')
    .map((item) => alphabets[(map[item] + index) % alphabets.length])
    .join('')
}

// 다른 사람의 풀이
function solution(s, skip, index) {
  const alphabet = [...'abcdefghijklmnopqrstuvwxyz'].filter(c => !skip.includes(c));
  return s.split("").map(c => alphabet[(alphabet.indexOf(c) + index) % alphabet.length]).join("");
}