import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_5639 {
	static StringBuilder sb = new StringBuilder();
	
	static class Tree {
		int data;
		Tree tail, head;

		void add(int data) {
			if (this.data == 0) {
				this.data = data;
			} else if (this.data > data) {
				if (tail == null) {
					tail = new Tree();
				}
				tail.add(data);
			} else if (this.data < data) {
				if (head == null) {
					head = new Tree();
				}
				head.add(data);
			}
		}
		
		void write() {
			if(tail != null) tail.write();
			if(head != null) head.write();
			sb.append(data).append('\n');
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
		
		String str = br.readLine();
		while (str != null) {
			tree.add(Integer.parseInt(str));
			str = br.readLine();
		}

		tree.write();
		
		System.out.println(sb);
	}
}
