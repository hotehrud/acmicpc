// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// 본인 풀이
function solution(today, terms, privacies) {
  const expirationDate = terms.reduce((acc, val) => {
    const [type, month] = val.split(' ')
    acc[type] = Number(month)
    return acc
  }, {})
  const result = []
  privacies.forEach((item, index) => {
    const [date, type] = item.split(' ')
    const now = new Date(today)
    const end = new Date(date)
    end.setMonth(end.getMonth() + expirationDate[type])
    end.setDate(end.getDate() - 1)
    if (now > end) {
      result.push(index + 1)
    }
  })
  return result
}

// 다른 사람의 풀이
function solution(today, terms, privacies) {
  var answer = [];
  var [year, month, date] = today.split(".").map(Number);
  var todates = year * 12 * 28 + month * 28 + date;
  var t = {};
  terms.forEach((e) => {
    let [a, b] = e.split(" ");
    t[a] = Number(b);
  });
  privacies.forEach((e, i) => {
    var [day, term] = e.split(" ");
    day = day.split(".").map(Number);
    var dates = day[0] * 12 * 28 + day[1] * 28 + day[2] + t[term] * 28;
    if (dates <= todates) answer.push(i + 1);
  });
  return answer;
}