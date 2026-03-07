import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공정한_팀_나누기 {
	static int N, K, ans=Integer.MAX_VALUE;
	static int map[][];
	static boolean team[];
	
	static void simulate(int index, int countA, int sumA, int countB, int sumB) {
		if(index == N) {
			ans = Math.min(ans, Math.abs(sumA-sumB));
			return;
		}
		
		int remain = N - index;	
		if(countA + remain < K || countB + remain < K) return;
		
		team[index] = true;
		int nextSumA = sumA;
		for(int i = 0; i < index; i++) {
			if(team[i]) nextSumA += map[index][i] + map[i][index];
		}
		
		simulate(index+1, countA+1, nextSumA, countB, sumB);
		
		team[index] = false;
		int nextSumB = sumB;
		for(int i = 0; i < index; i++) {
			if(!team[i]) nextSumB += map[index][i] + map[i][index];
		}
		
		simulate(index+1, countA, sumA, countB+1, nextSumB);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		team = new boolean[N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulate(0, 0, 0, 0, 0);
		
		System.out.println(ans);
	}
}
