// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// 본인 풀이 - x, y 각각의 최소/최대값을 구하기
function solution(wallpaper) {
  let [lux, luy, rdx, rdy] = [wallpaper[0].length -1, wallpaper.length -1, 0, 0]
  wallpaper.forEach((row, y) => {
    [row.indexOf('#'), row.lastIndexOf('#')].forEach(x => {
      if (x > -1) {
        lux = Math.min(lux, x)
        luy = Math.min(luy, y)
        rdx = Math.max(rdx, x + 1)
        rdy = Math.max(rdy, y + 1)
      }
    })
  })
  return [luy, lux, rdy, rdx]
}

// 다른 사람의 풀이 - 한번에 모아서 최소/최대 구하기
function solution(wallpaper) {
  let left = [];
  let top = [];
  let right = []
  let bottom = [];
  wallpaper.forEach((v,i) => {
    [...v].forEach((val,ind) => {
      if(val === "#") {
        left.push(i)
        top.push(ind)
        right.push(i + 1)
        bottom.push(ind + 1)
      }
    })
  })
  return [Math.min(...left), Math.min(...top), Math.max(...right), Math.max(...bottom)]
}