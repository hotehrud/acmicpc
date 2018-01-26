package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 상단 가장 왼쪽을 기준으로 W or B 2가지 경우 올 수 있다.
		// 8*8씩 짤라서 체크한다.

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] map = new char[n][m];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			String[] s = sc.readLine().split("");

			for (int j = 0; j < m; j++) {

				map[i][j] = s[j].charAt(0);

			}

		}

		for (int i = 0; i <= n - 8; i++) {
			int w = 0, b = 0;

			for (int j = 0; j <= m - 8; j++) {

				w = check(map, i, j, true);
				b = check(map, i, j, false);

				min = Math.min(min, Math.min(w, b));
			}

		}

		System.out.println(min);
	}

	public static int check(char[][] map, int n, int m, boolean w) {
		int cnt = 0;
		char[] color = { 'W', 'B' };

		if (w) {
			char tmp = color[0];
			color[0] = color[1];
			color[1] = tmp;
		}

		for (int i = n; i < n + 8; i++) {

			for (int j = m; j < m + 8; j++) {

				if (map[i][j] != color[(i + j) % 2]) {
					cnt++;
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