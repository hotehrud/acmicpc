package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		//// http://mygumi.tistory.com/162
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.000");
		// String.format( "%.3f", n)
		int i = 1;

		// a^2 + b^2 = c^2
		// a^2 + b^2 - c^2 = 0;
		
		// a^2 + b^2 
		// (a^2 - c^2) + b^2 = 0; => (a^2 - c^2) = 음수여야만 직각삼각형 가능
		// (b^2 - c^2) + a^2 = 0; => (b^2 - c^2) = 음수여야만 직각삼각형 가능 

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0) {
				break;
			} else {
				sb.append("Triangle #" + (i++) + "\n");

				if (a == -1) {
					if ((c * c) - (b * b) <= 0) {
						sb.append("Impossible.\n");
					} else {
						sb.append("a = " + df.format(Math.sqrt((c * c) - (b * b))) + "\n");
					}
				} else if (b == -1) {
					if ((c * c) - (a * a) <= 0) {
						sb.append("Impossible.\n");
					} else {
						sb.append("b = " + df.format(Math.sqrt((c * c) - (a * a))) + "\n");
					}
				} else {
					sb.append("c = " + df.format(Math.sqrt((a * a) + (b * b))) + "\n");
				}
				sb.append("\n");
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