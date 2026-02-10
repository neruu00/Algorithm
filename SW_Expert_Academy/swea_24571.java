import java.util.Scanner;

public class swea_24571 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int[][] map = new int[r][c];
			boolean[][] visited = new boolean[r][c];
			int sum = 0;
			
			for(int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(map[i][j] != 0) continue;
					for(int d = 0; d < 4; d++) {
						int nr = dr[d] + i;
						int nc = dc[d] + j;
						if(nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc]) continue;
						sum += map[nr][nc];
						visited[nr][nc] = true;
					}
				}
			}
			System.out.println(sum);
		}
	}
}

