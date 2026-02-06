import java.util.Scanner;

public class swea_24574 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int[] dr = { 1, 1, 1, 0, -1, -1, -1, 0 };
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			char[][] map = new char[r][c];
			int sum = 0;
			
			for(int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(map[i][j] == 'X') continue;
					for(int d = 0; d < 8; d++) {
						int ndr = dr[d] + i;
						int ndc = dc[d] + j;
						if(ndr < 0 || ndr >= r || ndc < 0 || ndc >= c) continue;
						if(map[ndr][ndc] == 'X') {
							sum += (int)(map[i][j] - '0');
							break;
						}
					}
				}
			}
			System.out.println(sum);
		}
	}
}
