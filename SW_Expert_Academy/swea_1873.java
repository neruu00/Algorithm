import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {
	static char map[][];
	static char tank[] = {'^', '>', 'v', '<'};
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int H, W;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][];
			int pr = 0, pc = 0;
			
			for(int r = 0; r < H; r++) {
				map[r] = br.readLine().toCharArray();
				
				for(int c = 0; c < W; c++) {
					char p = map[r][c];
					for(int i = 0; i < 4; i++) {
						if(p == tank[i]) {
							pr = r;
							pc = c;
							break;
						}
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for(int i = 0; i < N; i++) {
				char m = str.charAt(i);
				if(m == 'S') shoot(pr, pc);
				else {
					int tmp[] = move(m, pr, pc);
					pr = tmp[0];
					pc = tmp[1];
				}
			}
			
			sb.append('#').append(tc).append(' ');
			for(int i = 0; i < H; i++) {
				sb.append(map[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

	static void shoot(int pr, int pc) {
		int d;
		char m = map[pr][pc];
		if(m == '^') d = 0;
		else if(m == '>') d = 1;
		else if(m == 'v') d = 2;
		else d = 0;
		
		while(true) {
			int r = pr + dr[d];
			int c = pc + dc[d];
			if(r < 0 || r >= H || c < 0 || c >= W) break;
			if(map[r][c] == '*') {
				map[r][c] = '.';
				break;
			}
			if(map[r][c] == '#') {
				break;
			}
			shoot(r, c);
		}
	}
	
	static int[] move(char m, int pr, int pc) {
		int d;
		if(m == 'U') d = 0;
		else if(m == 'R') d= 1;
		else if(m == 'D') d = 2;
		else d = 3;
		
		char next = tank[d];
		int r = pr + dr[d];
		int c = pc + dc[d];
		if(r < 0 || r >= H || c < 0 || c >= W || map[r][c] != '.') {
			map[pr][pc] = next;
			return new int[] {pr, pc};
		}
		map[pr][pc] = '.';
		map[r][c] = next;
		
		return new int[] {r, c};
	}
}
