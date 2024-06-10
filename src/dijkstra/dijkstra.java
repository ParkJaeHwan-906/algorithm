package dijkstra;

import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other){
        if(this.distance < other.distance) return -1;
        return 1;
    }
}

public class dijkstra {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] d;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).distance;
                if(cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        d = new int[N+1];
        Arrays.fill(d, 999999999);

        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<Node>());
        }
        for(int[] arr : road){
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            // 양방향 통행
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra(1);

        for(int i = 1; i<=N; i++){
            System.out.println(d[i]);
        }

    }
}