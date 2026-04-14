import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2383_점심식사시간 {
	static class Person {
		int r, c, dist[];
		Person(int r, int c) {
			this.r = r;
			this.c = c;
			dist = new int[2];
		}
	}
	
	static int N, stairCount, personCount;
	static int stairR[] = new int[2];
	static int stairC[] = new int[2];
	static int stairK[] = new int[2];
	static Person persons[] = new Person[10];
	
	static void simulate(int index) {
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			N = Integer.parseInt(br.readLine());
			
			
			
			
			stairCount = 0;
			personCount = 0;
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 0) continue;
					if(tmp == 1) {
						persons[personCount++] = new Person(r, c);
					} else {
						stairR[stairCount] = r;
						stairC[stairCount] = c;
						stairK[stairCount++] = tmp; 
					}
				}
			}
			
			for(int i = 0; i < personCount; i++) {
				for(int j = 0; j < stairCount; j++) {
					persons[i].dist[j] = Math.abs(persons[i].r - stairR[j]) + Math.abs(persons[i].c - stairC[j]);
				}
			}
		}
		
		System.out.println(sb);
	}
}
