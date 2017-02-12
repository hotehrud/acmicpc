package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// 수학으로 접근해야하지만 직접 구현
		// 라운드 별로 승자가 올라가는 시뮬레이션 하드코딩
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int cnt = 0;
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}

		out: while (list.size() != 1) {

			int idx = 0;

			int size = list.size() / 2;
			for (int i = 0; i < size; i++) {

				int target = list.get(idx);

				if (target == a || target == b) {

					int defeat = list.remove(idx + 1);

					if ((defeat == a || defeat == b) && (target == a || target == b)) {
						flag = true;
						break out;
					}

				} else {
					list.remove(idx);
				}

				idx++;
			}

			cnt++;

		}
		System.out.println(flag ? (cnt + 1) : -1);
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