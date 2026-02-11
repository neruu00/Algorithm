import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 2; i < N+2; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			for(int i = 2; i < N+2; i++) {
				int high = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+1], arr[i+2]));
				int diff = arr[i] - high;
				ans += diff > 0 ? diff : 0;
			}
			sb.append("#").append(tc).append(' ').append(ans).append(' ');
		}
		System.out.println(sb);
	}
}
