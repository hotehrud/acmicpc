package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();

			int[][] map = new int[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				map[i][1] = i * 100 + 1;
			}

			for (int i = 1; i <= h; i++) {

				for (int j = 2; j <= w; j++) {
					map[i][j] = map[i][j - 1] + 1;
				}

			}
			
			int hh = n % h == 0 ? h : n % h;
			int ww = (int) ((n / h) == 0 ? 1 : Math.ceil((float) n / h));
			
			sb.append((map[hh][ww]) + "\n");
			
		}

		System.out.println(sb.toString());
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