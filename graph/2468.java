package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int n;

	private void solve() {
		// http://mygumi.tistory.com/171
		n = sc.nextInt();

		int[][] array = new int[n][n];
		boolean[][] visited;
		int ans = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = sc.nextInt();
			}
		}

		for (int h = 1; h <= 100; h++) {
			int cnt = 0;
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (array[i][j] > h && !visited[i][j]) {
						++cnt;
						dfs(array, visited, i, j, h);
					}
				}
			}
			
			if (ans < cnt) {
				ans = cnt;
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int[][] array, boolean[][] visited, int y, int x, int h) {
		if (visited[y][x]) {
			return;
		}

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (array[ny][nx] > h && !visited[ny][nx]) {
					dfs(array, visited, ny, nx, h);
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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}