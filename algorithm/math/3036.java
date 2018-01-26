package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 유클리드 호제법 
		
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int first = sc.nextInt();
		
		while(n-->1) {
			int next = sc.nextInt();
			int gcd = gcd(first, next);
			
			sb.append(first/gcd + "/" + next/gcd + "\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static int gcd(int a, int b) {
		
		int tmp = 0;
		
		while(b != 0) {
			
			tmp = a % b;
			a = b;
			b = tmp;
			
		}
		
		return a;
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