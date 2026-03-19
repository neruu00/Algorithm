import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1854 {
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;
		Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return (int)(this.weight - o.weight);
		}
	}
	
	static int N, M, K;
	static long minDist[];
	static int minCount[];
	static int offerCount[];
	static long offerMax[];
	static List<Edge> list[];
	
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge p = pq.poll();
			
			if(minCount[p.to] == K) continue;
			minDist[p.to] = p.weight;
			minCount[p.to]++;
			
			for(Edge edge : list[p.to]) {
				if(minCount[edge.to] == K) continue;
				long nextWeight = p.weight + edge.weight;
				if(offerCount[edge.to] < K) {
					offerCount[edge.to]++;
					offerMax[edge.to] = Math.max(offerMax[edge.to], nextWeight);
					pq.offer(new Edge(edge.to, nextWeight));
				} else if(offerMax[edge.to] > nextWeight){
					pq.offer(new Edge(edge.to, nextWeight));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		minDist = new long[N+1];
		Arrays.fill(minDist, Long.MAX_VALUE);
		minCount = new int[N+1];
		offerCount = new int[N+1];
		offerMax = new long[N+1];
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, c));
		}
		
		dijkstra();
		
		for(int i = 1; i <= N; i++) {
			sb.append(minCount[i] == K ? minDist[i] : -1).append('\n');
		}
		System.out.println(sb);
	}
}