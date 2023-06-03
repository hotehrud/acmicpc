// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 본인 풀이
function solution(arr)
{
  let ans = []
  arr.forEach(item => {
    if (ans[ans.length - 1] !== item) {
      ans.push(item)
    }
  })
  return ans
}

// 다른 사람의 풀이
function solution(arr)
{
  return arr.filter((val,index) => val != arr[index+1]);
}