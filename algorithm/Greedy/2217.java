package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 그리디 알고리즘
		// 큰 로프부터 시작
		// 들어올리는 로프 중 가장 작은 로프 * k = 최대 중량
		
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();

		while (n-- > 0) {
			int rope = sc.nextInt();

			list.add(rope);
		}
		
		Collections.sort(list);

		int idx = list.size() - 1;
		int max = list.get(idx--);
		int k = 2;

		// 모든 루프를 탐색. 부분적인 탐색은 최대 중량의 반례 존재
		while (idx > -1) {
			
			int before = list.get(idx--);
			int tmp = before * k;
			
			if (max < tmp) {
				max = tmp;
			}
			
			k++;
			
		}
		System.out.println(max);
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