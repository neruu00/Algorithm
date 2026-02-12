import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int map[][], visited[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, -1, 0, 1};
	static int N;
	
	public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new int[N][N];
            
            for(int r = 0; r < N; r++) {
            	st = new StringTokenizer(br.readLine());
            	for(int c = 0; c < N; c++) {
            		map[r][c] = Integer.parseInt(st.nextToken());
            	}
            }
            
            int maxDist = 0;
            int maxNum = Integer.MAX_VALUE;
            for(int r = 0; r < N; r++) {
            	for(int c = 0; c < N; c++) {
            		int result = search(r, c);
            		if(result > maxDist) {
            			maxDist = result;
            			maxNum = map[r][c];
            		} else if( result == maxDist) {
            			if(map[r][c] < maxNum) maxNum = map[r][c];
            		}
            	}
            }
         
            sb.append('#').append(tc).append(' ').append(maxNum).append(' ').append(maxDist).append('\n');
        }
        System.out.println(sb);
	}
	
	static int search(int r, int c) {
		if(visited[r][c] != 0) return visited[r][c];
		
		int cur = map[r][c];
		int sum = 1;
		
		for(int i = 0; i < 4; i++) {
			int dirR = r + dr[i];
			int dirC = c + dc[i];
			if(dirR < 0 || dirR >= N || dirC < 0 || dirC >= N || cur + 1 != map[dirR][dirC]) continue;
			sum += search(dirR, dirC);
		}
		
		return visited[r][c] = sum;
	}
}
