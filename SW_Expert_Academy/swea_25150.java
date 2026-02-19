import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_25150 {
	static List<Integer> list[];
	static int N, E, S, ans;
	static boolean visited[];
	
	static class Caelifera {
		int n, time;
		Caelifera(int n, int time) {
			this.n = n;
			this.time = time;
		}
	}
	
	static void BFS() {
		Queue<Caelifera> queue = new ArrayDeque<>();
		queue.add(new Caelifera(S, 0));
		visited[S] = true;
		
		while(!queue.isEmpty()) {
			Caelifera cur = queue.poll();
			
			ans = Math.max(ans, cur.time);
			
			for(int n:list[cur.n]) {
				if(visited[n]) continue;
				visited[n] = true;
				queue.add(new Caelifera(n, cur.time+1));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			visited = new boolean[N+1];
			list = new List[N+1];
			for(int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			S = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			ans = 0;
			BFS();
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
