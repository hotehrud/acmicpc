// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// 본인 풀이
function solution(nums) {
  let ans = 0
  const recursion = (sum, idx, len) => {
    if (len === 3) {
      if (isPrime(sum)) {
        ans += 1
      }
      return
    }
    for(let i = idx; i < nums.length; i++) {
      if (len < 3) {
        recursion(sum + nums[i], i + 1, len + 1)
      }
    }
  }
  recursion(0, 0, 0, 0)
  return ans
}

function isPrime(n) {
  if (n === 2) {
    return true
  }
  for(let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      return false
    }
  }
  return true
}

// 다른 사람의 풀이 - 조합 이용
function solution(nums) {
  const allCombi = combineWithoutRepetitions(nums, 3);
  const combSum = getCombSum(allCombi);
  const prime = getPrimeNumList(Math.max(...combSum));
  return combSum.filter(el => prime[el] !== 0).length;
}

function combineWithoutRepetitions(comboOptions, comboLength) {
  if (comboLength === 1) {
    return comboOptions.map(comboOption => [comboOption]);
  }

  const combos = [];

  comboOptions.forEach((currentOption, optionIndex) => {
    const smallerCombos = combineWithoutRepetitions(
      comboOptions.slice(optionIndex + 1),
      comboLength - 1,
    );

    smallerCombos.forEach((smallerCombo) => {
      combos.push([currentOption, ...smallerCombo]);
    });
  });

  return combos;
}

function getCombSum(comb) {
  return comb.map(el => el.reduce((a,b)=>a+b));
}

function getPrimeNumList(num) {
  const prime = [];

  for(let i = 2; i <= num; i += 1) {
    prime.push(i);
  }

  for(let i = 2; i <= Math.sqrt(num); i += 1) {
    if(prime[i] === 0) continue;

    for(let j = i + i; j <= num; j += i) {
      prime[j] = 0;
    }
  }

  return prime;
}