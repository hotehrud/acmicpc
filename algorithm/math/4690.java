package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		StringBuilder sb = new StringBuilder();

		for (int ai = 6; ai <= 100; ai++) {
			int a = ai * ai * ai;
			int b = 2;
			int c = 0;
			int d = 0;

			while (a > (b + c + d)) {

				for (int bi = 2; bi <= ai - 3; bi++) {
					b = bi * bi * bi;

					for (int ci = bi + 1; ci <= ai - 2; ci++) {
						c = ci * ci * ci;

						for (int di = ci + 1; di <= ai - 1; di++) {
							d = di * di * di;

							if (a == (b + c + d)) {
								sb.append("Cube = " + ai + ", Triple = (" + bi + "," + ci + "," + di + ")\n");
							}

						}

					}

				}

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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}