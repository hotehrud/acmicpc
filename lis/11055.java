import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int A = sc.nextInt();
		int[] array = new int[A];
		int[] dp = new int[A];
		
		
		for(int i=0;i<A;i++) {
			array[i] = sc.nextInt();
			dp[i] = array[i];
		}
		
		
		int max = dp[0];
		
		for(int i=1;i<A;i++) {
			
			// i 를 기준으로 인덱스 0 에서부터 i까지 체크한다 
			// 길이를 기준으로 하지 않고 합을 기준으로.
			for(int j=0;j<i;j++) {
				if (array[i] > array[j] && dp[i] < dp[j] + array[i]) {
					// 증가 수열
					
					dp[i] = dp[j] + array[i];

				}
				
			}
			
			if (max < dp[i]) {
				max = dp[i];
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