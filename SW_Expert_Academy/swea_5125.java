import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 메모리:25,600kb, 시간:86ms
 *
 */

public class swea_5125 {
	static int N, L, ans;
	static int[][] items;
	static int[] scoreSum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			items = new int[N][L];
			scoreSum = new int[N+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				items[i][0] = Integer.parseInt(st.nextToken());
				items[i][1] = Integer.parseInt(st.nextToken());
				scoreSum[i+1] = scoreSum[i] + items[i][0];
			}
			
			ans = 0;
			subset(0, 0, 0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void subset(int idx, int score, int kcal) {
		if(kcal > L) return;
		if(idx == N) {
			if(score > ans) ans = score;
			return;
		}
		
		if(ans > score + scoreSum[N] - scoreSum[idx]) return;
		
		
		subset(idx+1, score+items[idx][0], kcal+items[idx][1]);
		subset(idx+1, score, kcal);
	}
}
