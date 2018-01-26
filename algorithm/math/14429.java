package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int num = 0;
		
		// 베스킨 라빈스 31 필승 전략

		for (int i = 1; i <= n; i++) {

			int j = sc.nextInt();
			int m = sc.nextInt();
			int turn = 2;

			int r = (j - 1) % (1 + m);

			while (r + 1 + m < j) {

				turn += 2;
				r += (1 + m);

			}

			if (min > turn) {
				min = turn;
				num = i;
			}

		}
		System.out.println(num + " " + min);
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