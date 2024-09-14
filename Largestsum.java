public class Largestsum {
    static int[] par;
    static boolean[] vs;
    static int sum;
    public static void main(String[] arg){
        int[] adj = {4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1, 10, 15, 22, 22, 22, 22, 22, 21};
        long result = largesSumCycle(23,adj);
        System.out.println(result);
    }
    public static long largesSumCycle(int N, int Edge[]){
        sum = 0;
       par = new int[N];
       vs = new boolean[N];
       for(int i = 0;i<N;i++){
           par[i] = -1;
            
       }
       for(int i = 0;i<N;i++){
           if(vs[i] == false){
           dfs(Edge,i);
           }
       }
       if(sum == 0){
           return -1;
       }
       return sum;
    }
    public static void dfs(int[] Edge,int node){
      if(node == -1){
          return;
      }
      if(vs[node]){
          return;
      }
       if(Edge[node] == -1){
           return;
       }
       
       par[node] = Edge[node];
       if(par[Edge[node]] != -1){
           sum = Math.max(sum,findSum(Edge[node],node));
            par[node] = -1;
           return;
       }
       
       vs[node] = true;
       dfs(Edge,Edge[node]);
       par[node] = -1;
       return;
      
    }
    public static int findSum(int node,int tar){
      
        
       if(node == -1){
            return 0;
        }
        if(par[node] == -1){
            return 0;
        }
        if(node == tar){
            return 1;
        } 
        return 1 + findSum(par[node],tar);
       // return 0;
      
        
    }
}
