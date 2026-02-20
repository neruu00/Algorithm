import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {
	static List<Integer> list[] = new List[101];
	static int N, S;
	
	static int BFS() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[101];
		int size = 1;
		int max = Integer.MIN_VALUE;
		
		visited[S] = true;
		queue.offer(S);	

		while(!queue.isEmpty()) {
			if(size == 0) {
				size = queue.size();
				max = Integer.MIN_VALUE;
			}
			
			int node = queue.poll();
			
			max = Math.max(max, node);
			
			for(int n:list[node]) {
				if(visited[n] == true) continue;
				visited[n] = true;
				queue.offer(n);
			}
			
			size--;
		}
		
		return max; 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}
			
            sb.append("#").append(tc).append(" ").append(BFS()).append('\n');
		}
		System.out.println(sb);
	}
}
