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
		// 음수가 나오면 그 뒤의 수들은 모두 음수로 만들어버린다.

		String s = sc.readLine();
		ArrayList<Character> list = new ArrayList<>();
		String[] split = s.split("[-]|[+]");

		if (s.charAt(0) == '-') {
			list.add('-');
		} else {
			list.add('+');
		}

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				list.add(s.charAt(i));
			}

		}
		
		int ans = 0;
		boolean minus = false;
		
		for(int i=0;i<list.size();i++) {
			
			int n = Integer.parseInt(split[i]);
			
			if (list.get(i) == '-') {
				minus = true;
			} 
			
			if (minus) {
				n = -n;
			} 

			ans += n;
			
		}
		System.out.println(ans);
	}

	public static int getCount(int n, boolean female) {

		if (female) {
			n = (int) Math.ceil(n / 2);
		}

		return n;
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