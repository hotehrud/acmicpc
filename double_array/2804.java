package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		String A = sc.next();
		String B = sc.next();
		StringBuilder sb = new StringBuilder();
		
		int N = A.length();
		int M = B.length();
		int indexA = 0;
		int indexB = 0;
		char[][] array = new char[M][N];
		
		// A 문자열을 기준으로 B 문자열에서 동일한 문자 찾기
		
		for(int i=0;i<N;i++) {
			if (B.indexOf(A.charAt(i)) > - 1) {
				indexA = i;
				indexB = B.indexOf(A.charAt(indexA));
				break;
			}
		}
		
		for(int i=0;i<M;i++) {
			array[i][indexA] = B.charAt(i);
		}
		
		for(int i=0;i<N;i++) {
			array[indexB][i] = A.charAt(i);
		}
		
		for(int i=0;i<M;i++) {
			
			for(int j=0;j<N;j++) {
				if (array[i][j] != 0) {
					sb.append(array[i][j]);					
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
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