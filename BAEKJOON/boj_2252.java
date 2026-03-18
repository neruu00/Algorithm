import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2252 {
	static int N, M, count;
	static List<Integer> prev[];
	static List<Integer> next[];
	static boolean checked[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		prev = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			prev[i] = new ArrayList<>();
		}
		next = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			next[i] = new ArrayList<>();
		}
		checked = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			prev[a].add(b);
			next[b].add(a);
		}
		
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(next[i].size() != 0) continue;
			checked[i] = true;
			sb.append(i).append(' ');
			for(int j : prev[i]) {
				queue.offer(j);
			}
		}
		
		A : while(!queue.isEmpty()) {
			int p = queue.poll();
			
			if(checked[p]) continue;
			
			for(int i : next[p]) {
				if(!checked[i]) continue A;
			}
			
			checked[p] = true;
			sb.append(p).append(' ');
			
			for(int i : prev[p]) {
				queue.offer(i);
			}
		}
		
		System.out.println(sb);
	}
}
