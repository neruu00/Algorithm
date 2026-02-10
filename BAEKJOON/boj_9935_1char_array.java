import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9935_1char_array {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] boom = br.readLine().toCharArray();
		char[] stack = new char[str.length];
		int len = boom.length;
		int top = 0;
		
		for(char ch:str) {
			stack[top++] = ch;
			
			if(top >= len) {
				int idx = 1;
				while(true) {
					if(stack[top-idx] == boom[len-idx]) idx++;
					else break;
					if(idx > len) {
						top -= len;
						break;
					}
				}
			}
		}
		if(top > 0) System.out.println(new String(stack, 0, top));
		else System.out.println("FRULA");
	}
}
