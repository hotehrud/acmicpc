// https://school.programmers.co.kr/learn/courses/30/lessons/12981
function solution(n, words) {
  const already = []
  let prev = ''

  for(let i=0;i<words.length;i+=n) {
    const round = words.slice(i, i + n)

    for(let j=0;j<round.length;j++) {
      const current = round[j]

      if(prev && prev[prev.length - 1] !== current[0] || already.includes(current)) {
        return [j + 1, Math.ceil((i + 1) / n)]
      }

      prev = current
      already.push(current)
    }
  }
  return [0, 0]
}

function runTests() {
  const testCases = [
    { input: [3,["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]], expected: [3,3] },
    { input: [5,["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]], expected: [0,0] },
    { input: [2, ["hello", "one", "even", "never", "now", "world", "draw"]], expected: [1,3] },
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
