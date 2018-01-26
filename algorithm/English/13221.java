package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 직선 방향만 이동 가능
		
		int person_x = sc.nextInt();
		int person_y = sc.nextInt();
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int ans_x = 0;
		int ans_y = 0;
		
		while(n-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int tmp = Math.abs(person_x - x) + Math.abs(person_y - y);
			
			if (min > tmp) {
				min = tmp;
				ans_x = x;
				ans_y = y;
			}
			
		}
		System.out.println(ans_x + " " + ans_y);
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