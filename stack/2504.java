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

		// http://mygumi.tistory.com/175

		Stack<String> stack = new Stack<>();

		int check = 0;
		for (int i = 0; i < len; i++) {
			if (check == -1) {
				System.out.println(0);
				return;
			}

			if (array[i].equals("(") || array[i].equals("[")) {
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
						check = stackInnerLoop(stack, "[", "(", 2);
					}
				} else {
					if (stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					} else {
						check = stackInnerLoop(stack, "(", "[", 3);
					}
				}
			}
		}

		// 최종 스택 안에는 정수들만 존재한다.
		// 괄호가 있을 시 올바르지 않은 문자열
		while (!stack.isEmpty()) {
			if (stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[")
					|| stack.peek().equals("]")) {
				System.out.println(0);
				return;
			}
			sum += Integer.parseInt(stack.pop());
		}
		System.out.println(sum);
	}

	public static int stackInnerLoop(Stack<String> stack, String s1, String s2, int value) {
		int result = 0;

		while (!stack.isEmpty()) {
			String top = stack.peek();

			if (top.equals(s1)) {
				return -1;
			} else if (top.equals(s2)) {
				stack.pop();
				result *= value;
				stack.push(String.valueOf(result));
				break;
			} else {
				result += Integer.parseInt(stack.pop());
			}
		}
		
		return result;
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