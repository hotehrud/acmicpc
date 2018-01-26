package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		// http://mygumi.tistory.com/163
		int n = sc.nextInt();
		int[] array = new int[n];
		long[] sum = new long[n];
		long ans = 0;

		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			sum[i] += sum[i - 1] + array[i];
		}

		for (int i = 0; i < n - 1; i++) {
			ans += (sum[n - 1] - sum[i]) * array[i];
		}

		System.out.println(ans);
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