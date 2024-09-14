public class MaximumWeightNode {
    static int[] wg;
    public static void main(String[] arg){
        int[] edg = {4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
        wg  = new int[edg.length];
        for(int i = 0;i<edg.length;i++){
            if(edg[i] != -1){
                wg[edg[i]] = wg[edg[i]] + i; 
            }
        }
        int max = -1;
        int ind = -1;
        for(int i = 0;i<edg.length;i++){
            if(max <= wg[i]){
                max = wg[i];
                ind = i;
            }

        }
        System.out.println(ind);
    }
}
