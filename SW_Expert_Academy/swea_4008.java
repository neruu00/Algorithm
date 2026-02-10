import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4008 {
	static int N, M;
	static int numbers[];
	static char calc[];
	static char operators[] = { '+', '-', '*', '/' };
	static int max, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = N - 1;

			calc = new char[M];
			st = new StringTokenizer(br.readLine());
			int calcIndex = 0;
			for(int i = 0; i < 4; i++) {
				int num = Integer.parseInt(st.nextToken());
				for(int j = 0; j < num; j++) {
					calc[calcIndex] = operators[i];
					calcIndex++;
				}
			}

			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(0, numbers[0], 0);
			sb.append('#').append(tc).append(' ').append(max-min).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int result, int bits) {
		if (depth == M) {
			if(result > max) max = result;
			if(result < min) min = result;
			return;
		}

		char prev = ' ';
		for (int i = 0; i < M; i++) {
			if((bits & 1 << i) != 0 || calc[i] == prev) continue;
			prev = calc[i];
			int nextResult = result;
			switch (calc[i]) {
			case '+':
				nextResult += numbers[depth + 1];
				break;
			case '-':
				nextResult -= numbers[depth + 1];
				break;
			case '*':
				nextResult *= numbers[depth + 1];
				break;
			case '/':
				nextResult /= numbers[depth + 1];
				break;
			default:
			} 
			dfs(depth+1, nextResult, bits | 1 << i);
		}
	}
}
