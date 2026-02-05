
import java.util.Scanner;

public class codetree_916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int d = 0, x = 0, y = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L') d = (d - 1) == -1 ? 3 : d - 1;
            else if (s.charAt(i) == 'R') d = (d + 1) % 4;
            else {
                x += dx[d];
                y += dy[d];
            }
        }
        System.out.println(x+" "+y);
    }
}
