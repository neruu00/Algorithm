import java.util.Scanner;

public class swea_24566 {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
	
		int T = s.nextInt();
		int N, M;				
		int[][] map;			
	
		for (int tc=1; tc<=T; tc++) {
			N = s.nextInt();
			M = s.nextInt();
			map = new int[N][M];
	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = s.nextInt();
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
