import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] array = new int[n];
		int max = 1;
		
		// LIS
		Arrays.fill(dp, 1);
		
		for(int i=0;i<n;i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i=1;i<n;i++) {
			
			// 해당 상자보다 앞 쪽에 위치하고 값이 작은 것을 찾는다.			
			for(int j=0;j<i;j++) {
				
				if (array[i] > array[j] && dp[j]+1 > dp[i] ) {
					dp[i] = dp[j] + 1;
					
					if (max < dp[i]) {
						max = dp[i];
					}
				}
			}
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