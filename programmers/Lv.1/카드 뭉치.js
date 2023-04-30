// https://school.programmers.co.kr/learn/courses/30/lessons/159994
// 본인 풀이
function solution(cards1, cards2, goal) {
  let [card1Index, card2Index] = [0, 0]
  while(goal.length > 0) {
    const value = goal[0]
    if (value === cards1[card1Index]) {
      card1Index++
      goal.shift()
      continue
    }
    if (value === cards2[card2Index]) {
      card2Index++
      goal.shift()
      continue
    }
    break
  }
  return goal.length === 0 ? 'Yes' : 'No'
}

// 다른 사람의 풀이 - index 관리할 필요 없이 shift 로 제거하면서 탐색
function solution(cards1, cards2, goal) {

  for(const s of goal) {

    if(cards1[0] == s) {
      cards1.shift();
    } else if(cards2[0] == s) {
      cards2.shift();
    } else {
      return "No"
    }
  }

  return "Yes";
}