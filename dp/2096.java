package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// http://mygumi.tistory.com/143

		int n = sc.nextInt();
		int[][] max = new int[n][3];
		int[][] min = new int[n][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				max[i][j] = sc.nextInt();
				min[i][j] = max[i][j]; 
			}
		}

		for (int i = 1; i < n; i++) {
			max[i][0] += Math.max(max[i-1][0], max[i-1][1]);
			max[i][1] += Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]);
			max[i][2] += Math.max(max[i-1][1], max[i-1][2]);
			
			min[i][0] += Math.min(min[i-1][0], min[i-1][1]);
			min[i][1] += Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]);
			min[i][2] += Math.min(min[i-1][1], min[i-1][2]);
		}

		System.out.println(Math.max(Math.max(max[n-1][0], max[n-1][1]), max[n-1][2]) 
				+ " " + Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]));
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