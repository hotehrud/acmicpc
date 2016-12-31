package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		StringBuilder sb = new StringBuilder();
		String s = "";
		
		while((s = sc.readLine()) != null) {
			int n = Integer.parseInt(s);
			BigInteger[] dp = new BigInteger[n+1];

			if (n == 0) {
				sb.append("1\n");
			} else {
				dp[0] = BigInteger.ONE;
				dp[1] = BigInteger.ONE;
				
				for(int i=2;i<=n;i++) {
					
					dp[i] = dp[i-1].add(new BigInteger("2").multiply(dp[i-2]));
					
				}
				sb.append(dp[n] + "\n");	
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