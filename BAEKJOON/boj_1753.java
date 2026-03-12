import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 메모리: 126,804kb, 시간: 1,052ms
 *
 */

public class boj_1753 {
	static class Node {
		int vertex, weight;
		Node next;
		
		Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine()) - 1;
		
		Node list[] = new Node[V];
		boolean visited[] = new boolean[V];
		int[] minDist = new int[V];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list[from] = new Node(to, weight, list[from]);
		}
		
		final int INF = Integer.MAX_VALUE;
		
		Arrays.fill(minDist, INF);
		
		minDist[start] = 0;
		
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int p[] = pq.poll();
			int cur = p[0];
			int min = p[1]; 
			
			if(visited[cur] || min > minDist[cur]) continue;
						
			visited[cur] = true;
			
			for(Node temp = list[cur]; temp != null; temp = temp.next) {
				if(visited[temp.vertex] || min + temp.weight > minDist[temp.vertex]) continue;
				minDist[temp.vertex] = min + temp.weight;
				pq.offer(new int[]{temp.vertex, minDist[temp.vertex]});
			}
		}
		
		for(int n:minDist) {
			System.out.println(n != INF ? n : "INF");
		}
	}
}