// https://school.programmers.co.kr/learn/courses/30/lessons/138476
function solution(k, tangerine) {
  tangerine.sort((a,b)=> a-b)
  const map = new Map()

  for(let i=0;i<tangerine.length;i++) {
    map.set(tangerine[i], (map.get(tangerine[i]) ?? 0) + 1)
  }

  const sortedItems = [...tangerine.sort((a,b) => map.get(b) - map.get(a))]

  let idx = 0
  let result = 0
  let remain = k
  while(remain > 0) {
    const cnt = map.get(sortedItems[idx])
    remain -= cnt
    idx += cnt
    result++
  }
  return result
}

function runTests() {
  const testCases = [
    //6	[1, 3, 2, 5, 4, 5, 2, 3]	3
    // 4	[1, 3, 2, 5, 4, 5, 2, 3]	2
    // 2	[1, 1, 1, 1, 2, 2, 2, 3]	1
    { input: [6,[1, 3, 2, 5, 4, 5, 2, 3]], expected: 3 },
    { input: [4,[1, 3, 2, 5, 4, 5, 2, 3]], expected: 2 },
    { input: [2, [1, 1, 1, 1, 2, 2, 2, 3]], expected: 1 },
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
