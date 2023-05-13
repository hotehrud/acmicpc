// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// 본인 풀이
function solution(board, moves) {
  const stack = []
  let ans = 0
  moves.forEach(n => {
    for(let i = 0; i < board.length; i++) {
      if (board[i][n - 1] !== 0) {
        const targetNumber = board[i][n - 1]
        if (stack[stack.length - 1] === targetNumber) {
          stack.pop()
          ans += 1
        } else {
          stack.push(targetNumber)
        }
        board[i][n - 1] = 0
        break
      }
    }
  })
  return ans * 2
}

// 다른 사람의 풀이 - 행열 바꾸고 반전시키면서 0 은 제거하여 불필요한 탐색 X
const transpose = matrix =>
  matrix.reduce(
    (result, row) => row.map((_, i) => [...(result[i] || []), row[i]]),
    []
  );

const solution = (board, moves) => {
  const stacks = transpose(board).map(row =>
    row.reverse().filter(el => el !== 0)
  );
  const basket = [];
  let result = 0;

  for (const move of moves) {
    const pop = stacks[move - 1].pop();
    if (!pop) continue;
    if (pop === basket[basket.length - 1]) {
      basket.pop();
      result += 2;
      continue;
    }
    basket.push(pop);
  }

  return result;
};