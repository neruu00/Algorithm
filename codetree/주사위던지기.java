import java.util.Scanner;

public class 주사위던지기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[] directions = new char[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next().charAt(0);
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[] dirMap = new int[128];
        dirMap['L'] = 1;
        dirMap['R'] = 3;
        dirMap['U'] = 0;
        dirMap['D'] = 2;
        
        int[] dice = {1, 2, 3, 5, 4, 6};
        int[][] dirIdx = {
            {0, 1, 5, 3},
            {0, 2, 5, 4},
            {0, 3, 5, 1},
            {0, 4, 5, 2}
        };

        int[][] board = new int[n][n];
        int x = r - 1, y = c - 1;
        board[x][y] = 6;
        for (int i = 0; i < m; i++) {
            int dir = dirMap[directions[i]];
            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;

            int[] newDice = new int[4];
            for (int j = 0; j < 4; j++) {
                newDice[j] = dice[dirIdx[dir][(j + 1) % 4]];
            }
            for (int j = 0; j < 4; j++) {
                dice[dirIdx[dir][j]] = newDice[j];
            }
            x = nx;
            y = ny;
            board[x][y] = dice[5];
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += board[i][j];
            }
        }
        
        System.out.println(answer);
    }
}

