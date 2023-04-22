// https://school.programmers.co.kr/learn/courses/30/lessons/120924
// 본인 풀이
function solution(common) {
  const diffForAP = common[1] - common[0]
  const diffForGP = common[1] / common[0]
  const isAP = common[2] - diffForAP === common[1]

  if (isAP) {
    return common[common.length - 1] + diffForAP
  } else {
    return common[common.length - 1] * diffForGP
  }
}

// 다른 사람의 풀이
// common[common.length - 1] 대신 pop 을 활용할 수 있음.
function solution(common) {
  if ((common[1]-common[0])==(common[2]-common[1])){
    return common.pop() + common[1] - common[0];
  }
  else{
    return common.pop()*common[1]/common[0];
  }
}