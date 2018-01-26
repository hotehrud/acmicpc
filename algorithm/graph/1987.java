package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int r;
	static int c;
	static int cnt = 1;
	static int ans = 1;

	private void solve() {
		// http://mygumi.tistory.com/186
		r = sc.nextInt();
		c = sc.nextInt();
		char[][] map = new char[r][c];
		boolean[] visited = new boolean[26];

		for (int i = 0; i < r; i++) {
			map[i] = sc.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = (char) (map[i][j] - 'A');
			}
		}

		dfs(map, visited, 0, 0);
		System.out.println(ans);
	}

	public static void dfs(char[][] map, boolean[] visited, int y, int x) {
		int idx = map[y][x];

		visited[idx] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (-1 < nx && nx < c && -1 < ny && ny < r) {
				int next = map[ny][nx];

				if (!visited[next]) {
					ans = Math.max(++cnt, ans);
					dfs(map, visited, ny, nx);
				}

			}
		}

		--cnt;
		visited[idx] = false;
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