package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// http://mygumi.tistory.com/176
		int n = sc.nextInt();
		int[] array = new int[n + 2];
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			array[i] = sc.nextInt();
		}
		stack.push(0);

		for (int i = 1; i <= n + 1; i++) {

			while(!stack.isEmpty() && array[stack.peek()] > array[i]) {
				int height = array[stack.peek()];
		        stack.pop();
		        int width = i - stack.peek() - 1;

				ans = Math.max(ans, width * height);
			}
			stack.push(i);
		}

		System.out.println(ans);
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