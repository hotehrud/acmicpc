package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			int hp = sc.nextInt();
			int mp = sc.nextInt();
			int attack = sc.nextInt();
			int defensive = sc.nextInt();
			int hp2 = sc.nextInt();
			int mp2 = sc.nextInt();
			int attack2 = sc.nextInt();
			int defensive2 = sc.nextInt();
			
			int hpSum = hp+hp2;
			int mpSum = mp+mp2;
			int attackSum = attack+attack2;
			int defensiveSum = defensive+defensive2;
			
			if (hpSum < 1) hpSum = 1;
			if (mpSum < 1) mpSum = 1;
			if (attackSum < 0) attackSum = 0;
//			if (defensiveSum < 0) defensiveSum = 0;
			
			sb.append(1*hpSum + 5*mpSum + 2*attackSum + 2*defensiveSum + "\n");
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