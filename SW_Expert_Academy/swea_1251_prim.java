import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_1251_prim {
	static class Node implements Comparable<Node>{
		int vertex;
		double weight;
		Node next;
				
		Node(int vertex, double weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight < 0 ? -1 : 1;
		}
	}
	
	static Node list[];
	static int x[], y[];
	static int N;
	static double E;
	static long ans;
	
	static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[N];
		double edges[] = new double[N];
	
		pq.offer(new Node(0, 0, null));
		Arrays.fill(edges, Double.MAX_VALUE);
		edges[0] = 0;
		
		double sum = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int vertex = node.vertex;
			if(visited[vertex]) continue;
						
			visited[vertex] = true;
			double edge = node.weight;
			sum += edge;
			
			for(Node tmp = list[vertex]; tmp != null; tmp = tmp.next) {
				if(visited[tmp.vertex] || tmp.weight > edges[tmp.vertex]) continue;
				edges[tmp.vertex] = tmp.weight;
				pq.offer(tmp);
			}
		}
		
		ans = (long)(sum * E + 0.5);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			list = new Node[N];
			x = new int[N];
			y = new int[N];
						
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					double dist = Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2);
					list[i] = new Node(j, dist, list[i]);
					list[j] = new Node(i, dist, list[j]);
				}
			}
			
			prim();			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
