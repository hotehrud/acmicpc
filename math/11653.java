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
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		// n을 소인수분해한다면 나타나는 인수 중 제일 큰 값은 루트 n
		// 2부터 나눌수 있을때까지 계속 나눈다.
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			
			while(n%i == 0) {
				sb.append(i + "\n");
				n/=i;
			}
		}
		
		if (n > 1) {
			sb.append(n + "\n");
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