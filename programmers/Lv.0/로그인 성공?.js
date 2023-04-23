// https://school.programmers.co.kr/learn/courses/30/lessons/120883
// 본인 풀이
function solution(id_pw, db) {
  const userMap = db.reduce((acc, [id, pw]) => {
    acc[id] = pw
    return acc
  }, {})
  const [userId, userPw] = id_pw

  if (!userMap[userId]) {
    return 'fail'
  } else if (userMap[userId] !== userPw) {
    return 'wrong pw'
  } else {
    return 'login'
  }
}

// 다른 사람의 풀이 - Map 활용
function solution(id_pw, db) {
  const [id, pw] = id_pw;
  const map = new Map(db);
  return map.has(id) ? (map.get(id) === pw ? 'login' : 'wrong pw') : 'fail';
}