package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// http://mygumi.tistory.com/122
		
		int c = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[] count = new int[10000001];

		for (int i = 1; i <= 10000000; i++) {
			for (int j = 1; j <= 10000000 / i; j++) {
				count[i * j]++;
			}
		}

		while (c-- > 0) {

			int l = sc.nextInt();
			int u = sc.nextInt();

			sb.append(getCount(count, l, u) + "\n");

		}
		System.out.println(sb.toString());
	}

	public static int getCount(int[] count, int x, int y) {
		int max = 0;

		for (int i = x; i <= y; i++) {

			if (count[i] >= max) {
				max = count[i];
			}

		}
		return max;
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