package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			String[] s = sc.readLine().split(" ");
			long a = Long.parseLong(s[0]);
			String op = s[1];
			long b = Long.parseLong(s[2]); 
			long c = Long.parseLong(s[4]);
			boolean is = true;
			
			if (op.equals("*")) {
				if ((a * b) != c) {
					is = false;
				}
			} else if (op.equals("/")) {
				if ((a / b) != c) {
					is = false;
				}
			} else if (op.equals("+")) {
				if ((a + b) != c) {
					is = false;
				}
			} else {
				if ((a - b) != c) {
					is = false;
				}
			}
			
			if (is) {
				sb.append("correct\n");
			} else {
				sb.append("wrong answer\n");
			}
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