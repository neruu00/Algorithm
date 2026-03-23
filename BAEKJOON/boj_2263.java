import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2263 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] inorder;
    static int[] postorder;
    static int[] indexMap;
    
    static void solve(int is, int ie, int ps, int pe) {        
        if (is > ie || ps > pe) return;
        
        int root = postorder[pe];
        sb.append(root).append(' ');
        
        int rootIdx = indexMap[root]; 
        
        int leftSize = rootIdx - is;
        
        solve(is, rootIdx - 1, ps, ps + leftSize - 1);
        
        solve(rootIdx + 1, ie, ps + leftSize, pe - 1);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        inorder = new int[N];
        postorder = new int[N];
        
        indexMap = new int[N + 1]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            indexMap[inorder[i]] = i; 
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        
        solve(0, N - 1, 0, N - 1);
        
        System.out.println(sb);
    }
}