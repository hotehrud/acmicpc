// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// 본인 풀이
function solution(participant, completion) {
  const sortedParticipant = [...participant].sort()
  const sortedCompletion = [...completion].sort()
  let idx = 0
  while(true) {
    if (sortedParticipant[idx] !== sortedCompletion[idx]) {
      break
    }
    idx += 1
  }
  return sortedParticipant[idx]
}

// 다른 사람의 풀이
function solution(participant, completion) {
  const map = new Map();

  for(let i = 0; i < participant.length; i++) {
    let a = participant[i],
      b = completion[i];

    map.set(a, (map.get(a) || 0) + 1);
    map.set(b, (map.get(b) || 0) - 1);
  }

  for(let [k, v] of map) {
    if(v > 0) return k;
  }

  return 'nothing';
}