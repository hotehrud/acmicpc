package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// http://mygumi.tistory.com/179
		int n = sc.nextInt();
		int f = sc.nextInt();
		int ans = 1;

		Stack<Integer>[] stack = new Stack[7];
		for (int i = 1; i <= 6; i++) {
			stack[i] = new Stack<Integer>();
			stack[i].push(0);
		}

		stack[sc.nextInt()].push(sc.nextInt());

		for (int i = 1; i < n; i++) {
			int ln = sc.nextInt();
			int fn = sc.nextInt();

			while (stack[ln].peek() > fn) {
				stack[ln].pop();
				ans++;
			}

			if (stack[ln].peek() != fn) {
				stack[ln].push(fn);
				ans++;
			}
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