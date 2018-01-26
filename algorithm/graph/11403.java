package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 방향 그래프, 가중치 x

		int[][] a = new int[n + 1][n + 1];
		int[] c = new int[n + 1];
		int[][] path = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
			}

		}

		for (int i = 1; i <= n; i++) {
			dfs(a, c, i);

			for (int j = 1; j <= n; j++) {

				path[i][j] = c[j];

			}
			Arrays.fill(c, 0);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(path[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// 재귀 DFS - 인접행렬
	public static void dfs(int[][] a, int[] c, int v) {
		int n = a.length - 1;

		for (int i = 1; i <= n; i++) {

			if (a[v][i] == 1 && c[i] == 0) {
				c[i] = 1;
				dfs(a, c, i);
			}

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