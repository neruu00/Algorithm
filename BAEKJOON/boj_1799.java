import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1799 {
    static int N;
    static int[][] board;
    static boolean[] diag1; 
    static boolean[] diag2; 
    static int[] maxCount = new int[2]; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0, 0);
        dfs(0, 0, 1);
        
        System.out.println(maxCount[0] + maxCount[1]);
    }
    
    static void dfs(int index, int count, int color) {
        if (index >= N * N) {
            maxCount[color] = Math.max(maxCount[color], count);
            return;
        }
        
        int r = index / N;
        int c = index % N;
        
        if ((r + c) % 2 != color || board[r][c] == 0) {
            dfs(index + 1, count, color);
            return;
        }
        
        if (!diag1[r + c] && !diag2[r - c + N - 1]) {
            diag1[r + c] = true;
            diag2[r - c + N - 1] = true;
            
            dfs(index + 1, count + 1, color);
            
            diag1[r + c] = false;
            diag2[r - c + N - 1] = false;
        }
        
        dfs(index + 1, count, color);
    }
}