// https://school.programmers.co.kr/learn/courses/30/lessons/86491
// 본인 풀이
function solution(sizes) {
  const items = sizes.flat()
  let [min, max] = [Math.min(...items), Math.max(...items)]

  sizes.forEach(size => {
    const [minSize] = [Math.min(...size), Math.max(...size)]
    if (min < minSize) {
      min = minSize
    }
  })

  return max * min;
}

// 다른 사람의 풀이
function solution(sizes) {
  const rotated = sizes.map(([w, h]) => w < h ? [h, w] : [w, h]);

  let maxSize = [0, 0];
  rotated.forEach(([w, h]) => {
    if (w > maxSize[0]) maxSize[0] = w;
    if (h > maxSize[1]) maxSize[1] = h;
  })
  return maxSize[0]*maxSize[1];
}