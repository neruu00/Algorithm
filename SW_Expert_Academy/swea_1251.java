import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1251 {
	static class Edge{
		int a, b;
		double w;
		Edge(int a, int b, double w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	
	static Edge edgeList[];
	static int parents[];
	static int x[], y[];
	static int N;
	static double E;
	
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
			N = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[(int)(N*(N-1)/2)];
			parents = new int[N];
			x = new int[N];
			y = new int[N];
			
			for(int i = 0; i < N; i++) parents[i] = i;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			int index = 0;
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					double dist = Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2);
					edgeList[index++] = new Edge(i, j, dist);
				}
			}
			
			Arrays.sort(edgeList, (e1, e2)-> (e1.w - e2.w < 0) ? -1 : 1);
			
			int count = 0;
			double sum = 0;
						
			for(Edge edge : edgeList) {
				if(union(edge.a, edge.b)) {
					sum += edge.w;
					if(++count == N-1) break;
				}
			}
			
			long ans = (long)(sum * E + 0.5);
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
