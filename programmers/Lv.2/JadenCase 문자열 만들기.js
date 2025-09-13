// https://school.programmers.co.kr/learn/courses/30/lessons/12951
function solution(s) {
  let str = s[0].toLocaleUpperCase()

  for(let i=1;i<s.length; i++) {
    const target = s[i]
    const prev = s[i - 1]
    if (prev === ' ') {
      str += target.toLocaleUpperCase()
    } else {
      str += target.toLocaleLowerCase()
    }
  }

  return str
}

function runTests() {
  const testCases = [
    //"3people unFollowed me"	"3people Unfollowed Me"
    // "for the last week"	"For The Last Week"
    { input: ["3people unFollowed me"], expected: "3people Unfollowed Me" },
    { input: ["for the last week"], expected: "For The Last Week" },
    { input: ["1For 2Fhe 3Iast 4Fweek"], expected: "1for 2fhe 3iast 4fweek" },
    { input: ["1For   2Fhe 3Iast 4Fweek"], expected: "1for   2fhe 3iast 4fweek" },
    { input: ["   2Fhe 3Iast 4Fweek"], expected: "   2fhe 3iast 4fweek" },
    { input: ["a   2Fhe 3Iast 4Fweek"], expected: "A   2fhe 3iast 4fweek" },
  ];

  testCases.forEach((test, i) => {
    const result = solution(...test.input);
    const passed = result === test.expected;
    console.log(`Test ${i + 1}: ${passed ? '✅' : '❌'}`);
    if (!passed) {
      console.log(`  Expected: ${test.expected}, Got: ${result}`);
    }
  });
}

runTests();
