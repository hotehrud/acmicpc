// https://school.programmers.co.kr/learn/courses/30/lessons/12911
function solution(n) {
  const cnt = n.toString(2).replaceAll('0', '').length
  let next = n + 1

  while(next <= 1000000) {
    const nextCnt = next.toString(2).replaceAll('0', '').length

    if (nextCnt === cnt) {
      break;
    }

    ++next
  }

  return next
}

function runTests() {
  const testCases = [
    //78	83
    // 15	23
    { input: [78], expected: [83] },
    { input: [15], expected: [23] },
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
