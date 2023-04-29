// https://school.programmers.co.kr/learn/courses/30/lessons/120869
// 본인 풀이
function solution(spell, dic) {
  return dic.filter(item => spell.sort().join('') === item.split('').sort().join('')).length > 0 ? 1 : 2
}

// 다른 사람의 풀이 - some() 활용 및 join() 을 toString() 대체 가능.
function solution(p, d) {
  return d.some(s => p.sort().toString() == [...s].sort().toString()) ? 1 : 2;
}