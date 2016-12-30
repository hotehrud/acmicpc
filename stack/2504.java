package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		String[] array = sc.readLine().split("");
		int len = array.length;
		int sum = 0;
		
		Stack<String> stack = new Stack<>();
		
		// 괄호가 올바르게 닫히면 계산된 값 스택에 푸시
		// 올바른 문자열이라면 실행이 다 되면 스택에는 정수만 남는다
		
		for(int i=0;i<len;i++) {
			int result = 0;

			if (array[i].equals("(")) {
				
				stack.push(array[i]);
				
			} else if (array[i].equals("[")) {
				
				stack.push(array[i]);
				
			} else {
				
				if (stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				
				if (array[i].equals(")")) {
					if (stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} else {
						// 정수 계산 
						// 괄호 나오기 전까지 정수들은 덧셈
						while(!stack.isEmpty()) {
							String top = stack.peek();

							if (top.equals("[")) {
								System.out.println(0);
								return;
							} else if (top.equals("(")) {
								stack.pop();
								result *= 2;
								stack.push(String.valueOf(result));
								break;
							} else {
								result += Integer.parseInt(stack.pop());	
							}
							
						}
						
					}
				} else {
					//  "]" 경우 
					if (stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					} else {
						
						while(!stack.isEmpty()) {
							String top = stack.peek();

							if (top.equals("(")) {
								System.out.println(0);
								return;
							} else if (top.equals("[")) {
								stack.pop();
								result *= 3;
								stack.push(String.valueOf(result));
								break;
							} else {
								result += Integer.parseInt(stack.pop());	
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		// 스택 안에는 정수들만 존재한다.
		// 괄호가 있을 시 올바르지 않은 문자열

		while(!stack.isEmpty()) {
			
			if (stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[") || stack.peek().equals("]")) {
				System.out.println(0);
				return;
			}
			sum += Integer.parseInt(stack.pop());
		}
		
		System.out.println(sum);		
	}
	
	public static void main(String[] args) {
		sc.init();

		new Main().solve();
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}