import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/

	static int[][] map, colors;
	static boolean[] visited = new boolean[100];
	static int n;
	static int[] ans = new int[2];
	static int[] dy = { -1, -1, 1, 1 };
	static int[] dx = { -1, 1, 1, -1 };

	private void solve() {
		n = sc.nextInt();
		map = new int[n][n];
		colors = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						colors[i][j] = 1;
					}
				} else {
					if (j % 2 != 0) {
						colors[i][j] = 1;
					}
				}
			}
		}
		dfs(-1, 0, 1);
		dfs(-1, 0, 0);
		System.out.println(ans[0] + ans[1]);
	}

	public static void dfs(int v, int cnt, int color) {
		if (ans[color] < cnt) {
			ans[color] = cnt;
		}

		for (int i = v + 1; i < n * n; i++) {
			int c = i / n;
			int r = i % n;

			if (colors[c][r] != color) {
				continue;
			}

			if (map[c][r] == 1) {
				if (check(c, r)) {
					visited[i] = true;
					dfs(i, cnt + 1, color);
				}
			}
		}
		if (v == -1) return;
		visited[v] = false;
	}

	public static boolean check(int c, int r) {
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + r;
			int ny = dy[i] + c;
			int v = ny * n + nx;

			for (int j = 1; j < n; j++) {
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (visited[v]) {
						return false;
					}
				}
				nx += dx[i];
				ny += dy[i];
				v = ny * n + nx;
			}
		}
		return true;
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