package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// Chop Cup 컵 섞기 마술
		
		String s = sc.readLine();
		int[] array = new int[4];
		array[1] = 1;
		
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if (ch == 'A') {
				swap(array,1,2);
			} else if(ch == 'B') {
				swap(array,2,3);
			} else {
				swap(array,1,3);
			}
		}
		
		for(int i=1;i<4;i++) {
			if (array[i] == 1) {
				System.out.println(i);
				return;
			}
		}
	}

	public static void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
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