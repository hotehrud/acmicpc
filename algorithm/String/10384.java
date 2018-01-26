package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int k=1;k<=t;k++) {
			
			String s = sc.readLine();
			int len = s.length();
			int[] array = new int[26];
			
			for(int i=0;i<len;i++) {
				
				int ch = s.charAt(i);
				
				if (65 <= ch && ch <= 90) {
					array[ch-65]++;
				} else if (97 <= ch && ch <= 122) {
					array[ch-97]++;
				}
				
			}
			
			int min = array[0];
			
			for(int i=1;i<=25;i++) {
				
				if (min > array[i]) {
					min = array[i];
				}
				
			}
			
			sb.append("Case " + k + ": ");
			
			if (min == 0) {
				sb.append("Not a pangram");
			} else if (min == 1) {
				sb.append("Pangram!");
			} else if (min == 2) {
				sb.append("Double pangram!!");
			} else {
				sb.append("Triple pangram!!!");
			}
			sb.append("\n");
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