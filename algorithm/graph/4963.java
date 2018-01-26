package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	public static final int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	public static final int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	private void solve() {
		StringBuilder sb = new StringBuilder();

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}

			// 방문 여부는 boolean이 아닌 단지 번호를 삽입.

			int[][] a = new int[h + 1][w + 1];
			int[][] c = new int[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				String[] s = sc.readLine().split(" ");

				for (int j = 1; j <= w; j++) {
					a[i][j] = Integer.parseInt(s[j - 1]);
				}

			}

			int cnt = 0;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (a[i][j] == 1 && c[i][j] == 0) {
						bfs(a, c, j, i, ++cnt);
					}
				}

			}

			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int[][] a, int[][] c, int x, int y, int cnt) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		c[y][x] = cnt;

		while (!q.isEmpty()) {
			x = q.peek().x;
			y = q.peek().y;
			q.poll();

			for (int k = 0; k < 8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (0 < nx && nx <= w && 0 < ny && ny <= h) {
					if (a[ny][nx] == 1 && c[ny][nx] == 0) {
						q.add(new Pair(nx, ny));
						c[ny][nx] = cnt;
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		sc.init();

		new Main().solve();
	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
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