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
		// 동석차 존재하지 않음으로 서류심사가 순위를 1위부터 기준으로 잡는다면 면접심사 순위만 고려하면 된다.
		// 두 점수 중 하나만이라도 높으면 떨어지지 않는다  

		int t = sc.nextInt();

		while (t-- > 0) {

			int n = sc.nextInt();
			int[] document = new int[n+1];

			for (int i = 0; i < n; i++) {

				document[sc.nextInt()] = sc.nextInt();
				
			}
			
			int tmp = document[1]; 
			int ans = 1;
				
			for(int i=2;i<=n;i++) {
				
				if (tmp >= document[i]) {
					tmp = document[i];
					ans++;
				}
				
			}

			System.out.println(ans);
		}

	}

	public static class Person {
		int document;
		int interview;

		Person(int document, int interview) {
			this.document = document;
			this.interview = interview;
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