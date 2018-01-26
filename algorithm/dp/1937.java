package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	private void solve() {

		// DP + DFS
		
		int n = sc.nextInt();
		int[][] array = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = sc.nextInt();
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				max = Math.max(max, dfs(array, dp, i, j));

			}
		}
		
		System.out.println(max);
	}

	public static int dfs(int[][] array, int[][] dp, int x, int y) {
		int n = array.length;

		// 이미 계산된 곳은 들리지 않고, 그 곳의 값을 리턴.
		if (dp[y][x] == 0) {
			dp[y][x] = 1;
			
			for (int i = 0; i < 4; i++) {
				int xx = dx[i] + x;
				int yy = dy[i] + y;

				if (0 <= xx && xx < n && 0 <= yy && yy < n) {

					if (array[y][x] > array[yy][xx]) {

						dp[y][x] = Math.max(dp[y][x], dfs(array, dp, xx, yy) + 1);
						
					}

				}
			}	
		}
		
		return dp[y][x];
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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