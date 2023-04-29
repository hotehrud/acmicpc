// https://school.programmers.co.kr/learn/courses/30/lessons/120866
// 본인 풀이 - 폭탄과 인접하는 칸들을 표시한 후, 다시 모든 칸 탐색하면서 카운트
function solution(board) {
  const x = [-1, 0, 1]
  const y = [-1, 0, 1]
  const n = board.length

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if (board[i][j] === 1) {
        for(let k = 0; k < y.length; k++) {
          for(let l = 0; l < x.length; l++) {
            const ny = i - y[k]
            const nx = j - x[l]
            if (nx > -1 && nx < n && ny > - 1 && ny < n) {
              if (board[ny][nx] !== 1) {
                board[ny][nx] = 2
              }
            }
          }
        }
      }
    }
  }
  return board.flat().filter(item => item === 0).length
}


// 다른 사람의 풀이 - 각 칸을 기준으로 인접한 곳에 폭탄 유무를 체크.
function solution(board) {

  let outside = [[-1,0], [-1,-1], [-1,1], [0,-1],[0,1],[1,0], [1,-1], [1,1]];
  let safezone = 0;

  board.forEach((row, y, self) => row.forEach((it, x) => {
    if (it === 1) return false;
    return outside.some(([oy, ox]) => !!self[oy + y]?.[ox + x])
      ? false : safezone++;
  }));

  return safezone;
}