// https://school.programmers.co.kr/learn/courses/30/lessons/12930
// 본인 풀이
function solution(s) {
  return s.split(' ').map(word => {
    return word.split('').map((val, idx) => {
      return idx % 2 !== 0 ? val.toLocaleLowerCase() : val.toLocaleUpperCase()
    }).join('')
  }).join(' ')
}

// 다른 사람의 풀이 - (\w)(\w) 연속된 두 문자
function solution(s){
  return s.toUpperCase().replace(/(\w)(\w)/g, function(a){return a[0].toUpperCase()+a[1].toLowerCase();})

}