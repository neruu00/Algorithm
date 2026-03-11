import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_2382_live2 {
	static class Micro implements Comparable<Micro>{
		int r, c, cnt, dir;
		
		Micro(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
		
		@Override
		public int compareTo(Micro o) {
			return Integer.compare(o.cnt, this.cnt);
		}
	}
	
	static int N, M, K;
	static int dr[] = {0, -1, 1, 0, 0};
	static int dc[] = {0, 0, 0, -1, 1};
	static PriorityQueue<Micro> pq;
	static Micro map[][]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<>();
			map = new Micro[N][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new Micro(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			
			System.out.println("#"+tc+" "+solve());
		}
	}
	
	static int solve() {
		int time = M, nr, nc, remainCnt = 0;
		
		while(--time >= 0) {
			while(!pq.isEmpty()) {
				Micro cur = pq.poll();
				nr = cur.r += dr[cur.dir];
				nc = cur.c += dc[cur.dir];
				
				if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
					cur.cnt =  cur.cnt/2;
					if(cur.cnt == 0) continue;
					
					if(cur.dir % 2 == 1) cur.dir++;
					else cur.dir--;
				}
				
				if(map[nr][nc] == null) {
					map[nr][nc] = cur;
				} else {
					map[nr][nc].cnt += cur.cnt;
				}
			}
			remainCnt = reset();
		}
		return remainCnt;
	}
	
	static int reset() {
		int result = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == null) continue;
				
				result += map[r][c].cnt;
				pq.offer(map[r][c]);
				map[r][c] = null;
			}
		}
		return result;
	}
}
