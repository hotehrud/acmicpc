package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int r = sc.nextInt();
		int c = sc.nextInt();
		int zr = sc.nextInt();
		int zc = sc.nextInt();

		char[][] ans = new char[r * zr][c * zc];
		int x = 0, y = 0;

		for (int t = 0; t < r; t++) {

			x = 0;
			
			char[] array = sc.readLine().toCharArray();

			for (int k = 0; k < array.length; k++) {

				for (int i = y; i < y + zr; i++) {

					for (int j = x; j < x + zc; j++) {

						ans[i][j] = array[k];

					}

				}

				
				x += zc;

			}
			
			y += zr;
			
		}

		for (int i = 0; i < r * zr; i++) {

			for (int j = 0; j < c * zc; j++) {

				System.out.print(ans[i][j]);

			}
			System.out.println();
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