import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_23659 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, P, arr[][];

	public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

			arr = new int[2][N];

        	st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[0][i] = Integer.parseInt(st.nextToken());
			
        	st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[1][i] = Integer.parseInt(st.nextToken());

			int ans = (int)Math.max(solve(0, 0, 0), solve(1, 0, 0));
			
			sb.append("#").append(tc).append(" ").append(ans).append('\n');
		}
        System.out.println(sb);
	}
	
	
	static int solve(int type, int seq, int index) {
		if(index == N) return 0;
		int a = solve(type, 1, index+1);
		int b = solve(type == 0 ? 1 : 0, 0, index+1);
		return arr[type][index] - seq * P + (int)Math.max(a, b);
	}

}