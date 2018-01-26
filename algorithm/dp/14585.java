package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] array = new boolean[301][301];
		int[][] dp = new int[301][301];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			array[x][y] = true;
		}
		
		// http://mygumi.tistory.com/167
		// dp[x][y] = 좌표가 x, y 일 때까지, 최대로 먹을 수 있는 사탕 개수

		for (int i = 0; i < 301; i++) {

			for (int j = 0; j < 301; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				if (i == 0) {
					if (array[i][j]) {
						dp[i][j] = (m - i - j) + dp[i][j - 1];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				} else if (j == 0) {
					if (array[i][j]) {
						dp[i][j] = (m - i - j) + dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else {
					if (array[i][j]) { 
						dp[i][j] = (m - i - j) + Math.max(dp[i - 1][j], dp[i][j - 1]);	
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}

			}

		}
		System.out.println(dp[300][300]);
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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}