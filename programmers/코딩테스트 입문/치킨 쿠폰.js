// https://school.programmers.co.kr/learn/courses/30/lessons/120884
// 본인 풀이
function solution(coupon) {
  let count = 0
  while(coupon > 9) {
    const chicken = Math.floor(coupon / 10)
    const remainCoupon = coupon % 10
    count += chicken
    coupon = chicken + remainCoupon
  }
  return count
}