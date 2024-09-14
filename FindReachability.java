import java.util.*;

public class FindReachability {
    static Set<Integer> vs;
    public static void main(String[] args){
        vs = new HashSet<Integer>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Map<Integer,List<Integer>> adj = new HashMap<Integer,List<Integer>>();
        for(int i = 0;i<num;i++){
            List<Integer> temp = new ArrayList<Integer>();
            int node = sc.nextInt();
            adj.put(node,temp);
        }
       int edgcount = sc.nextInt();
       for(int i = 0;i<edgcount;i++){
        int node1 = sc.nextInt();
        int node2 = sc.nextInt();
        List<Integer> nlist1 = adj.get(node1);
        nlist1.add(node2);
        List<Integer> nlist2 = adj.get(node2);
        nlist2.add(node1);
       }
       
       int src = sc.nextInt();
       int dec = sc.nextInt();
       int res = dfs(adj,src,dec);
       System.out.println(res);

    }
    public static int dfs(Map<Integer,List<Integer>> adj,int src,int dec){
        List<Integer> nodes = adj.get(src);
        for(Integer n : nodes){
            if(n == dec){
                return 1;
            }else if (!vs.contains(n)){
                vs.add(n);
                if(dfs(adj,n,dec) == 1){
                    return 1;
                }
                vs.remove(n);
            }
            vs.add(n);
        }
        return -1;
    }
    
}