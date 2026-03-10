import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2382 {
	static class Node {
		int size, dir, total;
		Node(int size, int dir) {
			this.size = size;
			this.dir = dir;
			this.total = size;
		}
	}
	
	static int N, M, K;
	static int map[][], tempMap[][];
	static Node nodes[];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void move(int r, int c) {
		int start = map[r][c];
		Node sNode = nodes[start];
		map[r][c] = 0;
		
		int nr = r + dr[sNode.dir];
		int nc = c + dc[sNode.dir];
		
		int end = tempMap[nr][nc];
		
		if(end == 0) {
			tempMap[nr][nc] = start;
			return;
		}

		Node eNode = nodes[end];
		
		if(sNode.size > eNode.size) {
			sNode.total += eNode.total;
			eNode.size = 0;
			tempMap[nr][nc] = start;
		} else {
			eNode.total += sNode.total;
			sNode.size = 0;
		}
	}
	
	static void apply(int r, int c) {
		Node node = nodes[tempMap[r][c]]; 
		
		map[r][c] = tempMap[r][c];
		tempMap[r][c] = 0;
		
		if(r == 0 || r == N-1 || c == 0 || c == N-1) {
			node.size = node.total/2;
			if(node.dir == 0) node.dir = 1;
			else if (node.dir == 1) node.dir = 0;
			else if (node.dir == 2) node.dir = 3;
			else node.dir = 2;
		} else node.size = node.total;
		node.total = node.size;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			tempMap = new int[N][N];
			nodes = new Node[K+1];
			
			for(int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				map[r][c] = i;
				nodes[i] = new Node(size, dir-1);
			}
			
			
			for(int i = 0; i < M; i++) {
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(map[r][c] > 0) move(r, c);
					}
				}
				
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(tempMap[r][c] > 0) apply(r, c);
					}
				}
			}
			
			int ans = 0;
			for(int i = 1; i <= K; i++) {
				ans += nodes[i].size;
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
