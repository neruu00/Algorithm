import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12851 {
	static Queue<Integer> queue = new ArrayDeque<>();
	static int visited[] = new int[100_001];
	static int N, K, cnt, time;
	
	static void validate(int x) {
		if(x < 0 || x > 100000) return;
		if(visited[x] != 0 && visited[x] < time) return;
		visited[x] = time;
		queue.offer(x);
	}
	
	static void simulate() {
		queue.offer(N);
		
		int s;
		int next;
		
		while(!queue.isEmpty() && cnt == 0) {
			s = queue.size();
			time++;
			
			while(s-- > 0) {
				int p = queue.poll();
				
				next = p+1;
				if(next == K) cnt++;
				else validate(next);
				
				next = p-1;
				if(next == K) cnt++;
				else validate(next);

				
				next = p*2;
				if(next == K) cnt++;
				else validate(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N != K) {
			simulate();
			System.out.println(time+"\n"+cnt);
		} else System.out.println("0\n1");
	}
}
