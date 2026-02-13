import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25672 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, K, arr[], greater[], less[], max;
	
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];

			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
			}
			
			greater = new int[N-K+1];
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i <= greater.length-K; i++) {
				greater[i] = arr[i+K] - arr[i];
				greater[i] = max = Math.max(max, greater[i]);
			}
			
			less = new int[N-K+1];
			max = Integer.MIN_VALUE;
			
			for(int i = less.length - 1; i >= K ; i--) {
				less[i] = arr[i+K] - arr[i];
				less[i] = max = Math.max(max, less[i]);	
			}
			
			int ans = Integer.MIN_VALUE;
			for(int i = 0; i < N-K*2+1; i++) {
				ans = Math.max(ans, greater[i] + less[i+K]);
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
