package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[301][301];
	static int[][] temp = new int[301][301];
	static boolean[][] visited = new boolean[301][301];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int n, m;

	private void solve() {
		// http://mygumi.tistory.com/192
		n = sc.nextInt();
		m = sc.nextInt();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int tmp = 0;
		while ((tmp = componentNumber()) < 2) {
			if (tmp == 0) {
				ans = 0;
				break;
			}
			++ans;
			visited = new boolean[301][301];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > 0) {
						temp[i][j] = nextYear(i, j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] -= temp[i][j];
				}
			}
		}
		System.out.println(ans);
	}

	public static int componentNumber() {
		int component = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					++component;
					dfs(i, j);
				}
			}
		}
		return component;
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= ny && ny < n && 0 <= nx && nx < m) {
				if (!visited[ny][nx] && map[ny][nx] > 0) {
					dfs(ny, nx);
				}
			}
		}
	}

	public static int nextYear(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= ny && ny < n && 0 <= nx && nx < m) {
				if (map[ny][nx] <= 0 && map[y][x] > 0) {
					++cnt;
				}
			}
		}
		return cnt;
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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