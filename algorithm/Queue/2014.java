package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int k = sc.nextInt();
		int n = sc.nextInt();

		// http://mygumi.tistory.com/183
		// 소수 리스트, 소수와 비교하여 곱한 값 넣는 큐, 최종 리스트
		// 큐의 맨 앞 요소를 빼서 각 소수를 곱하면서 큐에 다시 넣을 것이다.

		long[] prime = new long[k];
		PriorityQueue<Long> q = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			prime[i] = sc.nextInt();
			q.add(prime[i]);
		}

		long head = 0;

		for (int i = 0; i < n; i++) {
			// n번째 뺀 값이 n번째 수가 된다.
			head = q.poll();

			// 큐를 활용하여 삽입마다 오름차순으로 정렬됨으로써 원하는 값들을 리스트에 저장 가능.
			for (int j = 0; j < k; j++) {
				long value = head * prime[j];
				q.add(value);
				
				if (head % prime[j] == 0) {
					break;
				}
			}
		}
		System.out.println(head);
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