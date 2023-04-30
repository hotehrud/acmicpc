// https://school.programmers.co.kr/learn/courses/30/lessons/160586
// 본인 풀이
function solution(keymap, targets) {
  const keyList = {}
  keymap.forEach(list => {
    list.split('').forEach((item, index) => {
      const pressed = index + 1
      if (!keyList.hasOwnProperty(item) || keyList[item] > pressed) {
        keyList[item] = pressed
      }
    })
  })
  return targets.map(target => {
    return target.split('').reduce((acc, val) => {
      if (acc === -1 || !keyList.hasOwnProperty(val)) {
        return -1
      }
      return acc + keyList[val]
    }, 0)
  })
}

// 다른 사람의 풀이
function solution(keymap, targets) {
  const answer = [];
  const map = {}
  for (const items of keymap) {
    items.split('').map((item, index) => map[item] = (map[item] < index+1 ? map[item] : index+1))
  }
  for (const items of targets) {
    answer.push(items.split('').reduce((cur, item) => cur += map[item], 0) || -1)
  }
  return answer;
}

// 본인 풀이 개선 - hasOwnProperty 로직 제거 가능
function solution(keymap, targets) {
  const keyList = {}
  keymap.forEach(list => {
    list.split('').forEach((item, index) => {
      const pressed = index + 1
      keyList[item] = keyList[item] < pressed ? keyList[item] : pressed
    })
  })
  return targets.map(target => {
    return target.split('').reduce((acc, val) => {
      return acc + keyList[val]
    }, 0) || -1
  })
}