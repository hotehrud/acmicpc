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

		// 3의 배수판정법 - 모든 자리의 수의 합이 3의 배수이다.
		// 0은 무조건 존재해야한다.

		String s = sc.readLine();
		StringBuilder sb = new StringBuilder();
		int[] array = new int[10];
		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - '0';
			array[n]++;
			sum += n;
		}

		if (sum % 3 != 0 || array[0] == 0) {
			System.out.println(-1);
			return;
		} else {
			for (int i = 9; i >= 0; i--) {
				while (array[i]-- > 0) {
					sb.append(i);
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