// https://school.programmers.co.kr/learn/courses/30/lessons/120923
// 본인 풀이
function solution(num, total) {
  const odd = num % 2 !== 0
  const center = Math.floor(total / num)
  const half = Math.floor(num / 2)
  const start = odd ? center - half : center - half + 1
  return Array(num).fill(start).map((v, i) => v + i);
}


// 다른 사람의 풀이, 등차가 1 이라는 점을 이용.
function solution(num, total) {
  var min = Math.ceil(total/num - Math.floor(num/2));
  var max = Math.floor(total/num + Math.floor(num/2));

  return new Array(max-min+1).fill(0).map((el,i)=>{return i+min;});
}