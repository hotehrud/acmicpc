package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		// http://mygumi.tistory.com/165
		// 그리디 알고리즘
		// 야구는 팀이 공격일 때만 점수를 얻을 수 있다.
		// 먼저 공격하는 A팀을 기준.
		
		int[] a = new int[10];
		int aScore = 0;
		int bScore = 0;
		
		for(int i=1;i<10;i++) a[i] = sc.nextInt();
		
		for(int i=1;i<10;i++) {
			aScore += a[i];
			
			if (aScore > bScore) {
				System.out.println("Yes");
				return;
			}
			
			bScore += sc.nextInt();
		}
		System.out.println("No");
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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}