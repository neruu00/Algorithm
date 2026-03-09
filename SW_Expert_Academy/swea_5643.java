package offline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5643 {
	static int N, M;
	static ArrayList<Integer>[] graph, reverseGraph;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());

			graph = new ArrayList[N+1];
			reverseGraph = new ArrayList[N+1];
			
			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<Integer>();
				reverseGraph[i] = new ArrayList<Integer>();
			}
		
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				reverseGraph[b].add(a);	
			}

			int ans = 0;

			for (int i = 1; i <= N; i++) {
				int tmp = bfs(i, graph) + bfs(i, reverseGraph);
				if(tmp + 1 == N) ans++;
			}
			System.out.println("#"+tc+" "+ans);

		}
	}
	
	static int bfs(int start, ArrayList<Integer>[] graph) {
		int count = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int node : graph[cur]) {
				if(!visited[node]) {
					visited[node] = true;
					q.offer(node);
					count++;
				}
			}
		}
		return count;
	}

}
