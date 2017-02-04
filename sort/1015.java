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

		// 정렬되었어도 인덱스와 쌍으로 저장하여 초기 인덱스 유지
		// 값을 기준으로 정렬, 사전순이기 때문에 인덱스를 통해 정렬 조건 추가
		
		int n = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();
		int[] p = new int[1001];

		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			
			list.add(new Pair(i,v));
			
		}

		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				
				if (o1.value < o2.value) {
					return -1;
				} else if (o1.value > o2.value) {
					return 1;
				} else {
					if (o1.idx < o2.idx) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
		
		for (int i = 0; i < n; i++) {
			p[list.get(i).idx] = i;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(p[i] + " ");
		}

	}

	public static class Pair {
		int idx;
		int value;

		Pair(int idx, int value) {
			this.idx = idx;
			this.value = value;
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