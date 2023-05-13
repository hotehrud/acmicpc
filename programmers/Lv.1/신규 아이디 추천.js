// https://school.programmers.co.kr/learn/courses/30/lessons/72410
// 본인 풀이
function solution(new_id) {
  let id = new_id.toLowerCase()
  id = id.replace(/[^a-z0-9-_.]/g, '')
  id = id.replace(/([.])\1+/g, '.')

  if (id[0] === '.') {
    id = id.substring(1)
  }

  if (id[id.length - 1] === '.') {
    id = id.substring(0, id.length - 1)
  }

  id = id || 'a'
  id = id.slice(0, 15)

  if (id[id.length - 1] === '.') {
    id = id.substring(0, id.length - 1)
  }

  if (id.length <= 2) {
    id += id[id.length - 1].repeat(3 - id.length)
  }
  return id
}

// 다른 사람의 풀이
function solution(new_id) {
  const answer = new_id
    .toLowerCase() // 1
    .replace(/[^\w-_.]/g, '') // 2
    .replace(/\.+/g, '.') // 3
    .replace(/^\.|\.$/g, '') // 4
    .replace(/^$/, 'a') // 5
    .slice(0, 15).replace(/\.$/, ''); // 6
  const len = answer.length;
  return len > 2 ? answer : answer + answer.charAt(len - 1).repeat(3 - len);
}