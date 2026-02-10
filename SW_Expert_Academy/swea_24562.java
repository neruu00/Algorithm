import java.util.Scanner;

public class swea_24562 {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
	
		int T = s.nextInt();
		int N, M;				
		char[][] map;			
	
		for (int tc=1; tc<=T; tc++) {
			N = s.nextInt();
			M = s.nextInt();
			map = new char[N][M];
	
//			for (int i = 0; i < N; i++) {
//				String tmp = s.next();
//				for (int j = 0; j < M; j++) {
//					map[i][j] = tmp.charAt(j);
//				}
//			}
			
			for (int i = 0; i < N; i++) {
				map[i] = s.next().toCharArray();
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
