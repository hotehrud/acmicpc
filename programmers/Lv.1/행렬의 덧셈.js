// https://school.programmers.co.kr/learn/courses/30/lessons/12950
// 본인 풀이
function solution(arr1, arr2) {
  let ans = []
  for(let i = 0; i < arr1.length; i++) {
    ans[i] = []
    for(let j = 0; j < arr1[0].length; j++) {
      ans[i][j] = arr1[i][j] + arr2[i][j]
    }
  }
  return ans
}

// 다른 사람의 풀이
function sumMatrix(A,B){
  return A.map((arr1, idx1) => arr1.map((val, idx2) => val+B[idx1][idx2]));
}