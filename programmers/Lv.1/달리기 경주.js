// 실패 - 시간 초과
function solution(players, callings) {
  const ranks = [...players]
  callings.forEach(person => {
    const index = ranks.indexOf(person)
    ranks[index - 1] = ranks.splice(index, 1, ranks[index - 1])[0]
  })
  return ranks;
}

// 실패 - 시간 초과
function solution(players, callings) {
  function getByValue(map, searchValue) {
    for (let [key, value] of map.entries()) {
      if (value === searchValue)
        return key;
    }
  }
  const m = new Map(players.map((v, i) => [v, i + 1]))
  callings.forEach((target) => {
    const rank = m.get(target)
    const front = getByValue(m, rank - 1)
    m.set(front, rank)
    m.set(target, rank - 1)
  })
  const sortedMap = new Map([...m].sort((a, b) => a[1] - b[1]))
  return [...sortedMap.keys()]
}

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
// 본인 풀이 - Map
function solution(players, callings) {
  let rankMap = new Map(players.map((v, i) => [v, i]))
  let nameMap = new Map(players.map((v, i) => [i, v]))
  callings.forEach(person => {
    const targetRank = rankMap.get(person)
    const targetName = nameMap.get(targetRank)
    const frontName = nameMap.get(targetRank - 1)
    const frontRank = rankMap.get(frontName)

    rankMap.set(targetName, frontRank)
    rankMap.set(frontName, targetRank)
    nameMap.set(targetRank, frontName)
    nameMap.set(frontRank, targetName)
  })
  return [...nameMap].map(item => item[1])
}

// 다른 사람의 풀이 - Array
function solution(players, callings) {
  let idx;
  let name1;
  let name2;
  const idxList = {}

  players.forEach((name,index)=>idxList[name]=index)
  for(let call of callings){
    idx = idxList[call]
    name1 = players[idx]
    name2 = players[idx-1]
    idxList[call]-=1
    idxList[name2]+=1
    players[idx] = name2
    players[idx-1] = name1
  }

  return players;
}