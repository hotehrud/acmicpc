package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int m;
	static int n;
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };

	private void solve() {

		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		// DFS 기본 
		// 그래프 연결 요소 찾기

		while (t-- > 0) {

			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();

			int[][] a = new int[n][m];
			boolean[][] c = new boolean[n][m];

			while (k-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				a[y][x] = 1;

			}

			int components = 0;

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < m; j++) {

					if (a[i][j] == 1 && !c[i][j]) {

						dfs(a, c, j, i);

						components++;

					}

				}

			}

			sb.append(components + "\n");

		}
		System.out.println(sb.toString());
	}

	public static void dfs(int[][] a, boolean[][] c, int x, int y) {

		if (c[y][x]) {
			return;
		}

		c[y][x] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (0 <= nx && nx < m && 0 <= ny && ny < n) {

				if (a[ny][nx] == 1 && !c[ny][nx]) {
					dfs(a, c, nx, ny);
				}

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