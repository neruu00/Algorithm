import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11055 {
	static int N;
	static int arr[], vis[];
	
	static int dp(int start) {		
		if(vis[start] != 0) return vis[start];
		
		vis[start] = arr[start];
		
		for(int i = start+1; i < N; i++) {
			if(arr[i] > arr[start]) {
				vis[start] = Math.max(vis[start], arr[start] + dp(i));
			}
		}
		
		return vis[start];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		vis = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, dp(i));
		}
		
		System.out.println(ans);
	}
}
