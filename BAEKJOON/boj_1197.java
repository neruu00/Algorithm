import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class boj_1197 {
    static class Node implements Comparable<Node>{
        int vertex, weight;
        Node next;
                 
        Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
         
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
     
    static int V, E;
    static long ans = 0;
    static Node list[];
     
    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
        int edges[] = new int[V];
         
        pq.offer(new Node(0, 0, null));
        Arrays.fill(edges, Integer.MAX_VALUE);
        edges[0] = 0;
         
        while(!pq.isEmpty()) {
            Node node = pq.poll();
             
            int vertex = node.vertex;
            if(visited[vertex]) continue;
                         
            visited[vertex] = true;
            int edge = node.weight;
            ans += edge;
             
            for(Node tmp = list[vertex]; tmp != null; tmp = tmp.next) {
                if(visited[tmp.vertex] || tmp.weight > edges[tmp.vertex]) continue;
                edges[tmp.vertex] = tmp.weight;
                pq.offer(tmp);
            }
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new Node[V];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            list[a] = new Node(b, c, list[a]);
            list[b] = new Node(a, c, list[b]);
        }

        prim();
        System.out.println(ans);
    }
}