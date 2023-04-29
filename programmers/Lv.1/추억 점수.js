// https://school.programmers.co.kr/learn/courses/30/lessons/176963
// 본인 풀이
function solution(name, yearning, photo) {
  const grade = name.reduce((acc, val, idx) => {
    acc[val] = yearning[idx]
    return acc
  }, {})
  return photo.map(items => {
    return items.reduce((acc, val) => {
      return acc + (grade[val] ?? 0)
    }, 0)
  })
}

// 다른 사람의 풀이
function solution(name, yearning, photo) {
  return photo.map((v)=> v.reduce((a, c)=> a += yearning[name.indexOf(c)] ?? 0, 0))
}
