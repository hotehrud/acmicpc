package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		String input = "";
		StringBuilder sb = new StringBuilder();
		
		// 주어지는 예제를 모두 소문자로 변경 후 체크 
		
		while(!(input = sc.readLine()).equals("#")) {
		
			input = input.toLowerCase().replaceAll(" ", "");
			char ch = input.toLowerCase().charAt(0);
			int cnt = 0;
			
			for(int i=1;i<input.length();i++) {
				
				if (input.charAt(i) == ch) {
					cnt++;
				}
				
			}
			
			sb.append(ch + " " + cnt + "\n");
			
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