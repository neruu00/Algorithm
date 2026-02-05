import java.util.Scanner;
public class codetree_921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int x = 0, y = 0;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            if(direction == 'N') {
                x += dx[0] * distance;
                y += dy[0] * distance;
            } else if(direction == 'E') {
                x += dx[1] * distance;
                y += dy[1] * distance;
            } else if(direction == 'S') {
                x += dx[2] * distance;
                y += dy[2] * distance;
            } else if(direction == 'W') {
                x += dx[3] * distance;
                y += dy[3] * distance;
            }
        }
        System.out.println(x+" "+y);
    }
}
