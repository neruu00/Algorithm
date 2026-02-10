import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9935_2stack {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		char[] str = br.readLine().toCharArray();
		char[] boom = br.readLine().toCharArray();
		int len = boom.length;
				
		for(int i = str.length -1; i >= 0; i--) {
			stack1.push(str[i]);
			
			int idx = 0;
			while(true) {
				if(!stack1.isEmpty() && stack1.peek() == boom[idx++]) {
					stack2.push(stack1.pop());
				} else {
					while(!stack2.isEmpty()) stack1.push(stack2.pop());
					break;
				}
				if(idx == len) {
					stack2.clear();
					break;
				}
			}		
		}
		
		while(!stack1.isEmpty()) sb.append(stack1.pop());
		if(sb.length() > 0) System.out.println(sb);
		else System.out.println("FRULA");
	}
}
