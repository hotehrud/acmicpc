// https://school.programmers.co.kr/learn/courses/30/lessons/118666
// 본인 풀이
function solution(survey, choices) {
  const mbti = {
    R: 0,
    T: 0,
    C: 0,
    F: 0,
    J: 0,
    M: 0,
    A: 0,
    N: 0,
  }
  const grade = [3, 2, 1, 0, 1, 2, 3]
  let ans = ''

  survey.forEach(([a, b], idx) => {
    const selectedValue = choices[idx]
    if (selectedValue < 4) {
      mbti[a] += grade[selectedValue - 1]
    } else {
      mbti[b] += grade[selectedValue - 1]
    }
  })

  ans += mbti.R >= mbti.T ? 'R' : 'T'
  ans += mbti.C >= mbti.F ? 'C' : 'F'
  ans += mbti.J >= mbti.M ? 'J' : 'M'
  ans += mbti.A >= mbti.N ? 'A' : 'N'
  return ans
}

// 다른 사람의 풀이
// 별도 점수 배열을 관리할 필요 없음 => Math.abs(7 - 4) === Math.abs(1 - 4)
// 하드코딩보다는 enum 같은 값(types)을 통해 셋팅하는 것이 바람직해보임.
function solution(survey, choices) {
  const MBTI = {};
  const types = ["RT","CF","JM","AN"];

  types.forEach((type) =>
    type.split('').forEach((char) => MBTI[char] = 0)
  )

  choices.forEach((choice, index) => {
    const [disagree, agree] = survey[index];

    MBTI[choice > 4 ? agree : disagree] += Math.abs(choice - 4);
  });

  return types.map(([a, b]) => MBTI[b] > MBTI[a] ? b : a).join("");
}