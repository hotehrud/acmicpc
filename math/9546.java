package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		int[] array = new int[31];
		StringBuilder sb = new StringBuilder();	
		
		// 내릴 땐 무조건 절반 + 반명이 내린다.
		// 마지막 정류장에서는 무조건 한명이 남아있어야한다.
		// 5명 -> 3명 내림 -> 2명의 절반 + 반명은 1명이 남게 될 수 없다.
		
		array[1] = 1;
		
		for(int i=2;i<31;i++) {
			array[i] = 2 * array[i-1] + 1;
		}
		
		while(t-- > 0) {
			sb.append(array[sc.nextInt()] + "\n");
		}
		
		System.out.println(sb.toString());
	}

	public static int max(int a, int b) {
		if (a < b) {
			return b;
		} else {
			return a;
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