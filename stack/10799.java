package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		String s = sc.readLine();
		Stack<Integer> stack = new Stack<>();
		int len = s.length();
		int sum = 0;
		
		// 스택에 인덱스를 저장
		// 닫은 괄호 시 top과 비교해서 인접한 경우 스택의 크기만큼 더함. 
		// 인접한 경우가 아닐시는 +1 
		
		for(int i=0;i<len;i++) {
			char ch = s.charAt(i);
			
			if(ch == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					int top = stack.pop();
					if (i - top == 1) {
						sum += stack.size();
						System.out.println(stack.size());
					} else {
						sum += 1;
					}	
				}
				
			}
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