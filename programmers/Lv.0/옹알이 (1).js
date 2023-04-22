// https://school.programmers.co.kr/learn/courses/30/lessons/120956
// 본인 풀이
function solution(babbling) {
  const whitelist = ["aya", "ye", "woo", "ma"]

  return babbling.filter(item => {
    let nextIndex = 0
    let status = false
    let whiteIndex = 0
    while(whiteIndex < whitelist.length) {
      const whitelistItem = whitelist[whiteIndex++]
      if (nextIndex === item.indexOf(whitelistItem)) {
        nextIndex += whitelistItem.length
        whiteIndex = 0
      }
      if (nextIndex === item.length) {
        status = true
        break
      }
    }
    return status
  }).length
}

// 다른 사람의 풀이
function solution(babbling) {
  var answer = 0;
  const regex = /^(aya|ye|woo|ma)+$/;

  babbling.forEach(word => {
    if (regex.test(word)) answer++;
  })

  return answer;
}
