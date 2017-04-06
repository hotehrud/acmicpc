package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();

		int[] array = new int[n + 1];
		boolean[][] dp = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			array[i] = sc.nextInt();
		}

		// http://mygumi.tistory.com/145
		// dp[N][S] = N개 곡에서 볼륨 S 가능 여부
		
		dp[0][s] = true;

		for (int i = 1; i <= n; i++) {

			for (int j = 0; j <= m; j++) {

				if (!dp[i - 1][j]) {
					continue;
				}
				
				if (j - array[i] >= 0) {
					dp[i][j - array[i]] = true;
				}

				if (j + array[i] <= m) {
					dp[i][j + array[i]] = true;
				}

			}

		}

		for (int i = m; i >= 0; i--) {
			if (dp[n][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
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