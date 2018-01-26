package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 그리디 알고리즘 
		// 가치가 큰 돈이 최선이라고 가정
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = 0;
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();

		while (n-- > 0) {
			a = sc.nextInt();

			list.add(a);

		}

		for (int i = list.size() - 1; i >= 0; i--) {

			a = list.get(i);

			if (k / a > 0) {

				cnt += k / a;
				k -= a * (k / a);

			}

		}

		System.out.println(cnt);

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