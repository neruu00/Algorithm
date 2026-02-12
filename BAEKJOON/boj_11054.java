import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, dp[][], arr[];
	
	static void incPerm(int index, int last, int count) {
		if(count + N - index + 1 < dp[0][index]) return; 
		if(index > N) return;
		
		dp[0][index] = Math.max(dp[0][index-1], dp[0][index]);
		
		if(arr[index] > last) {
			dp[0][index] = Math.max(dp[0][index], count+1);
			incPerm(index+1, arr[index], count+1);
		}
		
		incPerm(index+1, last, count);
	}
	
	static void decPerm(int index, int last, int count) {
		if(count + index - 1 < dp[1][index]) return; 
		if(index < 1) return;
		
		dp[1][index] = Math.max(dp[1][index+1], dp[1][index]);
		
		if(arr[index] > last) {
			dp[1][index] = Math.max(dp[1][index], count+1);
			decPerm(index-1, arr[index], count+1);
		}
		
		decPerm(index-1, last, count);
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		dp = new int[2][N+2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		incPerm(1, 0, 0);
		decPerm(N, 0, 0);
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[0][i] + dp[1][i] - 1);
		}
		System.out.println(ans);
	}
}
