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
		// 패키지 가격과 낱개 가격이 가장 낮은 걸로만 비교
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> pack = new ArrayList<>();
		ArrayList<Integer> piece = new ArrayList<>();

		while (m-- > 0) {
			pack.add(sc.nextInt());
			piece.add(sc.nextInt());
		}

		Collections.sort(pack);
		Collections.sort(piece);

		int ans = 0;
		int k = n / 6;
		int remainder = n % 6;
		
		if (k == 0) {
			k = 1;
			remainder = 0;
		}
		
		int pack_price = pack.get(0) * k;
		
		pack_price += pack.get(0) < piece.get(0) * remainder ? pack.get(0) : piece.get(0) * remainder;
		
		int piece_price = piece.get(0) * n;

		if (pack_price > piece_price) {
			ans = piece_price;
		} else {
			ans = pack_price;
		}
		System.out.println(ans);
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