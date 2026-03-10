import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124 {
	static class Edge implements Comparable<Edge>{
		int a, b, w;
		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static Edge edgeList[];
	static int parents[];
	static int V, E;
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parents = new int[V];
			edgeList = new Edge[E];
			
			for(int i = 0; i < V; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i < E; i++) {
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(a, b, c);
			}
	
			Arrays.sort(edgeList);
			
			int count = 0;
			long sum = 0;
						
			for(Edge edge : edgeList) {
				if(union(edge.a, edge.b)) {
					sum += (long)edge.w;
					if(++count == V-1) break;
				}
			}
						
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		System.out.println(sb);
	}
}
