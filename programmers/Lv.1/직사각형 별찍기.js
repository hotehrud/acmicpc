// https://school.programmers.co.kr/learn/courses/30/lessons/12969
// 본인 풀이
process.stdin.setEncoding('utf8');
process.stdin.on('data', data => {
  const n = data.split(" ");
  const a = Number(n[0]), b = Number(n[1]);
  let ans = ''
  for(let y = 0; y < b; y++) {
    for(let x = 0; x < a; x++) {
      ans += '*'
    }
    ans += '\n'
  }
  console.log(ans)
});

// 다른 사람의 풀이
process.stdin.setEncoding('utf8');
process.stdin.on('data', data => {
  const n = data.split(" ");
  const a = Number(n[0]), b = Number(n[1]);
  const row = '*'.repeat(a)
  for(let i =0; i < b; i++){
    console.log(row)
  }

});