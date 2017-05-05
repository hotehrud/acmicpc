package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		int n = sc.nextInt();
		
		// http://mygumi.tistory.com/156

		int[] alphabet = new int[26];
		int ans = 0;
		int value = 9;

		for (int i = 0; i < n; i++) {
			char[] array = sc.readLine().toCharArray();
			int pos = (int) Math.pow(10, array.length - 1);

			for (int j = 0; j < array.length; j++) {
				alphabet[array[j] - 'A'] += pos;
				pos /= 10;
			}

		}

		Arrays.sort(alphabet);

		for (int i = alphabet.length - 1; i > -1; i--) {
			if (value == 0) {
				break;
			}
			
			ans += alphabet[i] * value--;
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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}