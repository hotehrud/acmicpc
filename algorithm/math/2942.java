package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		// http://mygumi.tistory.com/164
		int r = sc.nextInt();
		int g = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		int gcd = gcd(r,g);
		
		for (int n = 1; n <= gcd; n++) {

			if (gcd % n == 0) {
				sb.append(n + " " + (r / n) + " " + (g / n) + "\n");

			}

		}
		
		System.out.println(sb.toString());
	}

	public static int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}
			
		return gcd(b, a % b);
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