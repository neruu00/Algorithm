import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14938 {
	static int n, m, r, ans;
	static int map[][];
	static int items[];
	
	static void simulate(int index) {
		Queue<int[]> pq = new ArrayDeque<int[]>();
		boolean visited[] = new boolean[n+1];
		
		pq.offer(new int[] {index, 0});

		int sum = items[index];
		visited[index] = true;
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
						
			for(int i = 1; i <= n; i++) {				
				int len = map[tmp[0]][i];
				
				if(len == 0 || tmp[1] + len > m) continue;	
				
				if(!visited[i]) {
					visited[i] = true;
					sum += items[i];
				}
				
				pq.offer(new int[] {i, tmp[1]+len});
			}
		}
		ans = Math.max(ans, sum);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		items = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = l;
		}
		
		for(int i = 1; i <= n; i++) simulate(i);
		
		System.out.println(ans);
	}
}