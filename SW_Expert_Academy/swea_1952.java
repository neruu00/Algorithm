import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1952 {
	static int cost[], month[], ans, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			cost = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			month = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				int dayCost = Integer.parseInt(st.nextToken()) * cost[0];
				month[i] = Math.min(dayCost, cost[1]);
			}
			
			ans = cost[3];
			dfs(0, 0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int index, int sum) {
		System.out.println(++cnt);
		if(sum >= ans) return;
		if(index >= 12) {
			ans = sum;
			return;
		}
		
		dfs(index+1, sum+month[index]);
		dfs(index+3, sum+cost[2]);
	}
}
