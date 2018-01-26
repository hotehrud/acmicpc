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
		// 가장 가치가 큰 동전부터 거슬러 준다. 

		int money = 1000 - sc.nextInt();
		int[] array = {500,100,50,10,5,1};
		int idx = 0;
		int ans = 0;
		
		while(money != 0) {
			
			int change = money / array[idx];
			
			money -= change * array[idx++];
			
			ans += change;
		}
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