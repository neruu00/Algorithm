import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25120 {
	static int list[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append('\n');
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			list = new int[N][N];

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i < K; i++) {
				int in = Integer.parseInt(br.readLine());
				sb.append(in).append("=[");
				for(int j = 0; j < N; j++) {
					if(list[in][j] != 0) {
						sb.append(in).append(' ').append(list[in][j]).append(',');
					}
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}
