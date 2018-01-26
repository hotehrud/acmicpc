package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int n = sc.nextInt();
		int[] long_dp = new int[n+1];
		int[] short_dp = new int[n+1];
		int[] array = new int[n+1];
		
		// 가장 긴 증가하는 수열 + 가장 긴 감소하는 수열 - 중복하는 경우(1)
		
		for(int i=1;i<=n;i++) {
			int value = sc.nextInt();
			array[i] = value;
		}
		
		// 가장 긴 증가하는 수열.
		// long_dp[j] + 1 > long_dp[i] => 내부 반복문에서 i전까지 무조건 돌기 때문에 덮어씌여질 수 있음으로.
		long_dp[1] = 1;
		short_dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			long_dp[i] = 1;
			
			for(int j=1;j<i;j++) {
				
				if (array[i] > array[j] && long_dp[j] + 1 > long_dp[i]) {
					long_dp[i] = long_dp[j] + 1;
				}
				
			}
			
		}
		
		// 가장 긴 감소하는 수열.
		// 크기 10 - 증가수열 인덱스 4 라면 감소수열은 인덱스 5부터라는 말.
		// 1~4 증가수열 길이만 구하면 되고 5~10 감소수열의 길이만 구하면 된다.
		// 거꾸로 시작함으로써 증가수열과 감소수열이 정확히 나누어져 계산될 수 있다.
		
		for(int i=n;i>0;i--) {
			short_dp[i] = 1;
			
			for(int j=i+1;j<=n;j++) {
				
				if (array[i] > array[j] && short_dp[j] + 1 > short_dp[i]) {
					short_dp[i] = short_dp[j] + 1;
				}
				
			}
			
		}
		
		int max = 1;
		for(int i=1;i<=n;i++) {
			if (max < long_dp[i] + short_dp[i] - 1) {
				max = long_dp[i] + short_dp[i] - 1;
			}
		}
		System.out.println(max);
	}
	
	public int max(int a, int b) {
		if (a > b) {
			return a; 
		} else {
			return b;
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