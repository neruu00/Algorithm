import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단한번의2048시도 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int map[][] = new int[4][4];

		
		for(int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 4; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		char dir = br.readLine().charAt(0);

		if(dir == 'U') {
			for(int c = 0; c < 4; c++) {
				int tmp[] = new int[4];
				int index = 0;
				for(int r = 0; r < 4; r++) {
					if(map[r][c] == 0) continue;
					if(tmp[index] == 0) tmp[index] = map[r][c];
					else if(tmp[index] == map[r][c]) tmp[index++] += map[r][c];
					else tmp[++index] = map[r][c];
				}
				for(int r = 0; r < 4; r++) {
					map[r][c] = tmp[r];
				}
			}
		} else if(dir == 'D') {
			for(int c = 0; c < 4; c++) {
				int tmp[] = new int[4];
				int index = 3;
				for(int r = 3; r >= 0; r--) {
					if(map[r][c] == 0) continue;
					if(tmp[index] == 0) tmp[index] = map[r][c];
					else if(tmp[index] == map[r][c]) tmp[index--] += map[r][c];
					else tmp[--index] = map[r][c];
				}
				for(int r = 0; r < 4; r++) {
					map[r][c] = tmp[r];
				}
			}
		} else if(dir == 'L') {
			for(int r = 0; r < 4; r++) {
				int tmp[] = new int[4];
				int index = 0;
				for(int c = 0; c < 4; c++) {
					if(map[r][c] == 0) continue;
					if(tmp[index] == 0) tmp[index] = map[r][c];
					else if(tmp[index] == map[r][c]) tmp[index++] += map[r][c];
					else tmp[++index] = map[r][c];
				}
				map[r] = tmp;
			}
		} else if(dir == 'R') {
			for(int r = 0; r < 4; r++) {
				int tmp[] = new int[4];
				int index = 3;
				for(int c = 3; c >= 0; c--) {
					if(map[r][c] == 0) continue;
					if(tmp[index] == 0) tmp[index] = map[r][c];
					else if(tmp[index] == map[r][c]) tmp[index--] += map[r][c];
					else tmp[--index] = map[r][c];
				}
				map[r] = tmp;
			}
		}
		
		for(int a[] : map) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}
