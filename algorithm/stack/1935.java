package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// http://mygumi.tistory.com/184
		int n = sc.nextInt();
		char[] s = sc.next().toCharArray();
		int len = s.length;
		double[] array = new double[n];
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		for (int i = 0; i < len; i++) {
			char ch = s[i];
			
			switch(ch) {
			case '+':
			case '-':
			case '*':
			case '/':
				cal(stack, stack.pop(), stack.pop(), ch);
				break;
			default: 
				stack.push(array[ch - 'A']);
				break;
			}
		}
		System.out.format("%.2f", stack.peek());
	}

	public static void cal(Stack<Double> stack, double a, double b, char op) {
		switch(op) {
		case '+':
			stack.push(b + a);
			break;
		case '-':
			stack.push(b - a);
			break;
		case '*':
			stack.push(b * a);
			break;
		case '/':
			stack.push(b / a);
			break;
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