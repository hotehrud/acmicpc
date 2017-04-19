package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// 9876543210 MAX
		
		//	http://mygumi.tistory.com/150

		int count = 0;
		int n = sc.nextInt();
		long num = 0;

		if (n > 1022) {
			System.out.println(-1);
			return;
		}

		while (true) {
			boolean isDsc = true;
			long temp = num;
			long jump = 1;
			long before = -1;

			// 일의자리부터 한자리씩 비교
			while (temp != 0) {
				
				if (temp % 10 <= before) {
					isDsc = false;
				}

				// jump를 최대치로 늘리기 위함.
				if (!isDsc && temp % 10 > before) {
					break;
				}
				
				// jump는 어떤 자릿수에서 감소하는 수가 아닌지를 식별한다.
				jump *= 10;
				before = temp % 10;
				temp /= 10;
			}
			
			if (isDsc) {
				if (n == count++) {
					break;
				}
				num++;
			} else {
				// 불필요한 부분 점프.
				// 11 -> 20 으로 넘어가야한다. 무작정 점프 수만큼 넘어버리면 11 -> 21, 22 -> 32
				// 뒷 자리를 0으로 초기화 시켜줘야한다.
				jump /= 10;
				num += jump;
				num = num / jump * jump;
				System.out.println(num);
				continue;
			}
			
		}
		System.out.println(num);
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