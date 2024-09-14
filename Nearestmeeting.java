/**
 * Nearestmeeting
 */
public class Nearestmeeting {
    static int[] path;
    static int[] path2;
    public static void main(String []arg){
        int[] edg = {4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
        path = new int[edg.length];
        path2 = new int[edg.length];
        for(int i = 0;i<edg.length;i++){
            path[i] = -1;
            path2[i] = -1;
        }
        int a = 2;
        int b = 2;
        path[a] = 1;
        path[b] = 2;        
        int res = dfs(edg,a,b);
        System.out.println(res);
    }
    public static int dfs(int[] edg,int a,int b){
       if(edg[a] == -1){
            if(path2[b] == 1 || edg[b] == -1){
                return -1;
            }
       }
       if(path[a] == 1){
            if(edg[b] == -1 || path2[b] == 1){
                return -1;
            }
       }

       if(path[b] == 1 || a == b){
        return b;
       }
       if(path2[a] == 1){
        return a;
       }

        path[a] = 1;
        path2[b] = 1;
       
        if(edg[a] == -1 && b != -1){
            return dfs(edg,a,edg[b]);
        }else if(edg[b] == -1 && a != -1){
            return dfs(edg,edg[a],b);
        }

        return dfs(edg,edg[a],edg[b]);
        
        // return -1;
        
    }
    
}