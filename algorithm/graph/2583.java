package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int m, n, area;

	private void solve() {
		m = sc.nextInt();
		n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();

		map = new boolean[m + 1][n + 1];

		for (int i = 0; i < k; i++) {
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();
			int rightX = sc.nextInt();
			int rightY = sc.nextInt();

			draw(leftX, rightX, leftY, rightY);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!map[i][j]) {
					++cnt;
					area = 1;
					dfs(i, j);
					list.add(area);
				}
			}
		}
		
		sb.append(cnt + "\n");
		Collections.sort(list);
		for(int v : list) {
			sb.append(v + " ");
		}
		System.out.println(sb.toString());
	}

	public static void draw(int lx, int rx, int ly, int ry) {
		for (int i = lx; i < rx; i++) {
			for (int j = ly; j < ry; j++) {
				map[j][i] = true;
			}
		}
	}

	public static void dfs(int y, int x) {
		map[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (!map[ny][nx]) {
					++area;
					dfs(ny, nx);
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