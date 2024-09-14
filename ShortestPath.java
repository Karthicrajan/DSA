import java.util.*;

public class ShortestPath {
    public static void main(String []arg){
        
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] res = new int[V];
        PriorityQueue<Pair> qu = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        for(int i = 0;i<res.length;i++){
            res[i] = Integer.MAX_VALUE;
        }
        res[S] = 0;
        Pair root = new Pair(S,0);
        qu.add(root);
        while(!qu.isEmpty()){
            Pair node = qu.poll();
            for(int i = 0;i<adj.get(node.node).size();i++){
                if(res[adj.get(node.node).get(i).get(0)] > node.distance + adj.get(node.node).get(i).get(1)){
                    res[adj.get(node.node).get(i).get(0)] = node.distance + adj.get(node.node).get(i).get(1);
                    Pair newNode = new Pair(adj.get(node.node).get(i).get(0) , node.distance + adj.get(node.node).get(i).get(1));
                    qu.add(newNode);
                }  
            }
        }
        return res;
    }
}
class Pair{
    int node;
    int distance;
    public Pair(int n,int d){
        this.node = n;
        this.distance = d;
    }
}

