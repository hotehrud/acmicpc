package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int cnt = 0;
		
		// ABABAABABA
		// 스택을 활용해 스택의 top과 배열의 값을 비교해서 같으면 팝 다르면 푸시
		// 마지막 스택이 비었다면 좋은 단어.
		
		while(n-- > 0) {
			String s = sc.readLine();
			Stack<Character> stack = new Stack<>();
			char[] array = s.toCharArray();
			int len = array.length;
			
			for(int i=0;i<len;i++) {
				
				if (!stack.isEmpty()) {
					
					if (stack.peek() == array[i]) {
						
						stack.pop();
						
					} else {
						
						stack.push(array[i]);
						
					}
					
				} else {
					stack.push(array[i]);	
				}
				
			}
			
			if (stack.isEmpty()) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}

	public static int max(int a, int b) {
		if (a < b) {
			return b;
		} else {
			return a;
		}
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