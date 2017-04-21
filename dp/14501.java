package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int[] t = new int[n + 1];
		int[] p = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();

			dp[i] = p[i];
		}

		// dp[n] = n일때까지 얻은 수익

		for (int i = 2; i <= n; i++) {

			for (int j = 1; j < i; j++) {

				if (i - j >= t[j]) {
					dp[i] = Math.max(p[i] + dp[j], dp[i]);
				}

			}

		}

		int max = 0;

		for (int i = 1; i <= n; i++) {
			if (i + t[i] <= n + 1) {
				if (max < dp[i]) {
					max = dp[i];
				}
			}
		}
		System.out.println(max);
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