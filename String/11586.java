package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String input = sc.readLine();
			sb.append(input + "\n");
		}

		int k = sc.nextInt();

		if (k == 2) {

			String[] s = sb.toString().split("\n");
			sb = new StringBuilder();

			for (int i = 0; i < s.length; i++) {
				sb.append(new StringBuilder(s[i]).reverse() + "\n");
			}

		} else if (k == 3) {

			String[] s = sb.toString().split("\n");
			sb = new StringBuilder();

			for (int i = s.length - 1; i > -1; i--) {
				sb.append(s[i] + "\n");
			}

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