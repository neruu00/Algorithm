import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class codetree_920 {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int x = 0, y = 0;
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        A : for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	char dir = st.nextToken().charAt(0);
        	int dist = Integer.parseInt(st.nextToken());
        	
        	char d;
        	if(dir == 'N') d = 0;
        	else if(dir =='E') d = 1;
        	else if(dir =='S') d = 2;
        	else d = 3;

        	for(int j = 0; j < dist; j++) {
        		x += dx[d];
        		y += dy[d];
        		count++;
        		
        		if(x == 0 && y == 0) {
        			System.out.println(count);
        			return;
        		}
        	}
        }
		System.out.println(-1);
    }
}
