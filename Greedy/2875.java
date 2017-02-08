package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 그리디 알고리즘
		// 여자와 남자를 비교할 때 2명인 여자를 먼저 뺀다고 가정한다.

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;

		while (k-- > 0) {

			if (getCount(n, true) >= getCount(m, false)) {
				n--;
			} else {
				m--;
			}

		}
		
		ans = n/2 <= m ? n/2 : m; 
		
		System.out.println(ans);
	}

	public static int getCount(int n, boolean female) {

		if (female) {
			n = (int) Math.ceil(n / 2);
		}

		return n;
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