import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class swea_1767 {
	static int totalCnt, max, min;
	static List<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			totalCnt = list.size();
		}
	}
	
	static void setPower(int index, int coreCnt, int lineCnt) {
		if(totalCnt-index+coreCnt < max) return; 
		if(index == totalCnt) {
			 if(max <coreCnt) {
				 max = coreCnt;
				 min = lineCnt;
			 } else if(max == coreCnt) {
				 min = Math.min(min, lineCnt);
			 }
			 return;
		}
		
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		
		// 해당 코어를 4방향으로 전선 놓기 시도
		for(int d = 0; d < 4; d++) {
			// 해당 코어를 d방향으로 놓는 것이 가능한지 체크
			if(!isAvailable(r,c,d)) continue;
			
			// 해당 코어를 d방향으로 전선 놓기
			int cnt = setStatus(r, c, d, 2);
			
			// 해당 코어로 넘어가기
			setPower(index+1, coreCnt+1, lineCnt+cnt);
			
			// 해당 코어를 d방향으로 전선 지우기
		}
		
		// 해당 코어를 전선 놓기 하지 않음
	}

	static int setStatus(int r, int c, int d, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	static boolean isAvailable(int r, int c, int d) {
		return false;
	}
}
