// https://school.programmers.co.kr/learn/courses/30/lessons/42862
// 본인 풀이 - 여벌이 있는 학생을 별도로 관리 => extra
function solution(n, lost, reserve) {
  const lostItems = lost.sort((a, b) => a - b)
  const reserveItems = reserve.sort((a, b) => a - b)
  const extra = reserveItems.reduce((acc, val) => {
    if (!lostItems.includes(val)) {
      acc[val] = true
    } else {
      lostItems.splice(lostItems.indexOf(val), 1)
    }
    return acc
  }, [])
  let lostCount = lost.length

  lostItems.forEach(num => {
    if (extra[num - 1]) {
      lostCount -= 1
      extra[num - 1] = false
    } else if (extra[num + 1]) {
      lostCount -= 1
      extra[num + 1] = false
    }
  })

  return n - lostCount
}


// 다른 사람의 풀이 - 각 학생이 가지고 있는 옷을 하나의 배열로 관리 => students
function solution(n, lost, reserve) {
  const students = {};
  let answer = 0;
  for(let i = 1; i <= n; i++){
    students[i] = 1;
  }
  lost.forEach(number => students[number] -= 1);
  reserve.forEach(number => students[number] += 1);

  for(let i = 1; i <= n; i++){
    if(students[i] === 2 && students[i-1] === 0){
      students[i-1]++;
      students[i]--;
    } else if(students[i] === 2 && students[i+1] === 0){
      students[i+1]++;
      students[i]--;
    }
  }
  for(let key in students){
    if(students[key] >= 1){
      answer++;
    }
  }
  return answer;
}