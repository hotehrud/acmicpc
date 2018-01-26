package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.print.StreamPrintService;

public class Main {

	private void solve() {
		int a = sc.nextInt();
		int p = sc.nextInt();
		
		// 똑같은 수가 나오면 그 다음 수를 판단할 필요가 없슴.
		// 그렇기 때문에 똑같은 수 나오면 종료.
		// c[] 배열에는 index 삽입. 
		
		int[] c = new int[236197];
		int idx = 1;
		int pre = a;
		
		c[a] = idx++;
		
		while(true) {
			int sum = pre;
			
			sum = pow(sum,p);
			pre = sum;
			
			if (c[sum] != 0) {
				System.out.println(c[sum] - 1);
				break;
			}
			
			c[sum] = idx++;
			
		}
	}

	public static int pow(int n,int p) {
		int ans = 0;
		while(n > 0) {
			ans += (int) Math.pow((n%10), p);
			n /= 10;
		}
		return ans;
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