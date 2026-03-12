import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5658_보물상자비밀번호_리스트 {
	static class Node {
		String str;
		Node next;
		
		void add(String str) {
			if(this.str == null) this.str = str;
			int compare = this.str.compareTo(str);
			if(compare < 0) {
			    Node newNode = new Node();
			    newNode.str = this.str;
			    newNode.next = this.next;
			    this.str = str;
			    this.next = newNode;
			} else if(compare > 0) {
			    if(this.next == null) {
			        this.next = new Node();
			        this.next.str = str;
			    } else {
			        this.next.add(str);
			    }
			}
		}
	}
	
	static Node list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int len = N / 4;
			list = new Node();
			
			String str = br.readLine();
			str = str + str.substring(0, len);
			
			for(int i = 0; i < N; i++) {
				list.add(str.substring(0+i, len+i));
			}
			
			Node target = list;
			for(int i = 1; i < K; i++) {
				target = target.next;
			}
			
			long sum = Long.parseLong(target.str, 16);
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}
}
