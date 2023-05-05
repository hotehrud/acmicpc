// https://school.programmers.co.kr/learn/courses/30/lessons/133499
// 본인 풀이
function solution(babbling) {
  const whitelist = ['aya', 'ye', 'woo', 'ma']
  return babbling.reduce((acc, input) => {
    let newInput = input
    whitelist.forEach((item) => {
      newInput = slice(newInput, item)
    })
    return newInput.trim() === '' ? acc + 1 : acc
  }, 0)
}

function slice(str, word) {
  if (str.indexOf(word) > -1 && str.indexOf(word + word) === -1) {
    return str.replaceAll(word, ' ')
  }
  return str
}

// 다른 사람의 풀이
function solution(babbling) {
  const regexp1 = /(aya|ye|woo|ma)\1+/;
  const regexp2 = /^(aya|ye|woo|ma)+$/;

  return babbling.reduce((ans, word) => (
    !regexp1.test(word) && regexp2.test(word) ? ++ans : ans
  ), 0);
}

function solution(babbling) {
  const babblables = ["aya", "ye", "woo", "ma"];

  return babbling.reduce((possible, babbl, index) => {
    for (let i = 0; i < babblables.length; i += 1) {
      if (babbl.includes(babblables[i].repeat(2))) return possible;
    }

    for (let i = 0; i < babblables.length; i += 1) {
      babbl = babbl.split(babblables[i]).join(' ').trim();
    }

    if (babbl) return possible;

    return possible += 1;
  }, 0)
}