package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int cnt;

	private void solve() {
		// http://mygumi.tistory.com/191

		while ((k = sc.nextInt()) != 0) {
			array = new int[13];

			for (int i = 0; i < k; i++) {
				array[i] = sc.nextInt();
			}

			for (int i = 0; i < k; i++) {
				cnt = 1;
				dfs(i, array[i] + " ");
			}

			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int v, String str) {
		if (cnt == 6) {
			sb.append(str + "\n");
		} else {
			for (int i = v + 1; i < k; i++) {
				++cnt;
				dfs(i, str + array[i] + " ");
			}
		}
		--cnt;
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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