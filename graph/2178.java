package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final int[] dx = { 0, 0, 1, -1 };
	public static final int[] dy = { 1, -1, 0, 0 };

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] a = new int[n+1][m+1];
		int[][] dist = new int[n+1][m+1];
		boolean[][] c = new boolean[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			String[] s = sc.readLine().split("");

			for (int j = 1; j <= m; j++) {
				a[i][j] = Integer.parseInt(s[j - 1]);
			}

		}
		
		bfs(a,c,dist,n,m);
		
		System.out.println(dist[n][m]);
		
	}

	public static void bfs(int[][] a, boolean[][] c, int[][] dist, int n, int m) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(1, 1));
		c[1][1] = true;
		dist[1][1] = 1;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (0 < nx && nx <= m && 0 < ny && ny <= n) {
					if (a[ny][nx] == 1 && !c[ny][nx]) {
						q.add(new Pair(nx, ny));
						dist[ny][nx] += dist[y][x] + 1;
						c[ny][nx] = true;
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