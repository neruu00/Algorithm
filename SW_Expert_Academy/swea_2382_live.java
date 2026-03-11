import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2382_live {
	static class Micro {
		int r, c, cnt, dir, total;
		
		Micro(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.total = this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	static int N, M, K;
	static int dr[] = {0, -1, 1, 0, 0};
	static int dc[] = {0, 0, 0, -1, 1};
	static Micro list[];
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
			
			list = new Micro[K];
			map = new Micro[N][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new Micro(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#"+tc+" "+solve());
		}
	}
	
	static int solve() {
		int time = M, nr, nc, remainCnt = 0;
		
		while(--time >= 0) {
			for(Micro cur: list) {
				if(cur.cnt == 0) continue;
				nr = cur.r += dr[cur.dir];
				nc = cur.c += dc[cur.dir];
				
				if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
					cur.total = cur.cnt =  cur.cnt/2;
					if(cur.cnt == 0) continue;
					
					if(cur.dir % 2 == 1) cur.dir++;
					else cur.dir--;
				}
				
				if(map[nr][nc] == null) {
					map[nr][nc] = cur;
				} else {
					if(map[nr][nc].cnt > cur.cnt) {
						map[nr][nc].total += cur.cnt;
						cur.cnt = 0;
					} else {
						cur.total += map[nr][nc].total;
						map[nr][nc].cnt = 0;
						map[nr][nc] = cur;
					}
				}
			}
			remainCnt = reset();
		}
		return remainCnt;
	}
	
	static int reset() {
		int result = 0;
		for(Micro cur : list) {
			if(cur.cnt == 0) continue;
			
			if(map[cur.r][cur.c] == cur) {
				cur.cnt = cur.total;
				map[cur.r][cur.c] = null;
			}
			result += cur.cnt;
		}
		return result;
	}
}
