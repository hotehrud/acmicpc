package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		String a = sc.readLine();
		String b = sc.readLine();
		
		// 순서 상관없이 서로 다른 것들은 다 버린다.
		// 각 알파벳의 갯수를 해당하는 인덱스에 넣은 후 A,B 배열의 각 인덱스의 값의 차이가 제거 해야하는 수 
		
		int[] A = new int[26];
		int[] B = new int[26];
		int ans = 0;
		
		for (int i=0;i<a.length();i++) {
			A[a.charAt(i) - 'a']++;
		}
		
		for (int i=0;i<b.length();i++) {
			B[b.charAt(i) - 'a']++;
		}
		
		for(int i=0;i<26;i++) {
			
			if (B[i] != A[i]) {
				ans += Math.abs(B[i]-A[i]);
			}
			
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