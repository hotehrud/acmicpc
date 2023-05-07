// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// 본인 풀이
function solution(id_list, report, k) {
  const userMap = {}
  const reportMap = {}
  report.forEach((item) => {
    const [from, to] = item.split(' ')
    reportMap[to] = reportMap[to] ? reportMap[to].add(from) : new Set([from])
    userMap[from] = userMap[from] ? userMap[from].add(to) : new Set([to])
  })
  return id_list.map((user) => {
    if (!userMap[user]) return 0
    return [...userMap[user]].filter((item) => [...reportMap[item]].length >= k)
      .length
  })
}

// 다른 사람의 풀이
function solution(id_list, report, k) {
  let reports = [...new Set(report)].map(a=>{return a.split(' ')});
  let counts = new Map();
  for (const bad of reports){
    counts.set(bad[1],counts.get(bad[1])+1||1)
  }
  let good = new Map();
  for(const report of reports){
    if(counts.get(report[1])>=k){
      good.set(report[0],good.get(report[0])+1||1)
    }
  }
  let answer = id_list.map(a=>good.get(a)||0)
  return answer;
}