import java.util.Scanner;
public class codetree_918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int ans = 0;

        int[][] arr = new int[n+2][n+2];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int sum = 0;
                for(int d = 0; d < 4; d++) {
                    sum += arr[i+dy[d]][j+dx[d]];
                }
                if(sum >= 3) ans++;  
            }
        }

        System.out.println(ans);
    }
}
