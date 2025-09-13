// https://school.programmers.co.kr/learn/courses/30/lessons/70129
function solution(s) {
  let str = s
  let zero = 0
  let cnt = 0

  while(str !== '1') {
    const len = str.length
    str = str.replaceAll('0', '')
    const newLen = str.length

    zero += len - newLen
    str = newLen.toString(2)
    ++cnt
  }

  return [cnt, zero]
}

function runTests() {
  const testCases = [
    { input: ["110010101001"], expected: [3,8] },
    { input: ["01110"], expected: [3,3] },
    { input: ["1111111"], expected: [4,1] },
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
