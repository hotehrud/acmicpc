package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		int w = sc.nextInt();

		// http://mygumi.tistory.com/140
		
		int[][][] dp = new int[3][1001][32];
		int[] arr = new int[1001];
		int ans = 0;

		for (int i = 1; i <= t; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i <= t; i++) {

			for (int j = 1; j <= w + 1; j++) {

				if (arr[i] == 1) {
					
					dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);

					dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);

				} else {

					dp[1][i][j] = Math.max(dp[2][i - 1][j - 1], dp[1][i - 1][j]);

					dp[2][i][j] = Math.max(dp[1][i - 1][j - 1] + 1, dp[2][i - 1][j] + 1);

				}

			}

		}

		for (int i = 1; i <= w + 1; i++) {
			ans = Math.max(ans, Math.max(dp[1][t][i], dp[2][t][i]));
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