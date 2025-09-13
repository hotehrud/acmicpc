// https://school.programmers.co.kr/learn/courses/30/lessons/42885
function solution(people, limit) {
  const sortedPeople = [...people.sort((a,b) => a-b)]
  let cnt = 0

  while(sortedPeople.length !== 0) {
    const top = sortedPeople[sortedPeople.length - 1]
    let weight = top
    sortedPeople.pop()

    if (weight + sortedPeople[0] <= limit) {
      sortedPeople.shift()
    }

    ++cnt
  }
  return cnt
}

function runTests() {
  const testCases = [
    //[70, 50, 80, 50]	100	3
    // [70, 80, 50]	100	3
    { input: [[70, 50, 80, 50], 100], expected: 3 },
    { input: [[70, 80, 50], 100], expected: 3 },
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
