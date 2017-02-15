package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[] indexArray;

	private void solve() {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int size = sc.nextInt();
			int[] array = new int[100001];
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				array[i] = sc.nextInt();
			}

			for(int num : array) {
				
				// 리스트가 비었거나 리스트의 가장 큰 값보다 num이 크다면 리스트에 넣는다
				// 그렇지 않다면 이진 탐색을 통해 위치 찾고 갱신
				// 결과적으로 list에 들어있는 수열이 정확한 증가부분수열의 수들은 아니지만 증가부분수열의 크기는 동일하다
				if (list.size() == 0 || num > list.get(list.size() - 1)) {
					list.add(num);
				} else {
					
					int i = 0;
					int j = list.size() - 1;
					
					while (i < j) {
						
						int mid = (i + j) / 2;
						
						if (list.get(mid) < num) {
							i = mid + 1;
						} else {
							j = mid;
						}
						
					}
					
					list.set(j, num);
					
				}
				
			}
			sb.append(list.size() + "\n");
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
		
		static boolean hasNext() {
			return st.hasMoreTokens();
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