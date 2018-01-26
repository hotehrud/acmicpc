package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		String s = "";

		while (!(s = sc.readLine()).equals("#")) {
			char[] array = s.toCharArray();
			boolean[] check = new boolean[123];
			int cnt = 0;

			for (int i = 0; i < array.length; i++) {

				if ((65 <= array[i] && array[i] <= 90) || (97 <= array[i] && array[i] <= 122)) {
					check[array[i]] = true;
				}

			}

			for (int i = 65; i <= 122; i++) {

				if (check[i]) {
					cnt++;
				}

				if (check[i] && i + 32 <= 122 && check[i + 32]) {
					cnt--;
				}

			}
			System.out.println(cnt);
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