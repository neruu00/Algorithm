import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15681 {
	static int N, R, Q;
	static List<Integer> list[];
	static boolean visited[];
	static int subtree[];
	
	static int setSubtree(int index) {
		visited[index] = true;
		subtree[index] = 1;
		for(int i : list[index]) {
			if(visited[i]) continue;
			subtree[index] += setSubtree(i);
		}
		return subtree[index];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		subtree = new int[N+1];
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		setSubtree(R);
		
		for(int i = 0; i < Q; i++) {
			sb.append(subtree[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb);
	}
}
