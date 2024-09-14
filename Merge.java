import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge {
    public static void main(String[] args){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> res = mergeKArrays(arr, 0);
        System.out.println(res);
        

    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        
            PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
            for(int i = 0;i<arr.length;i++){
                for(int j = 0;j<arr[i].length;j++){
                    qu.add(arr[i][j]);
                }
            }
            ArrayList<Integer> res = new ArrayList<Integer>();
            while(!qu.isEmpty()){
                res.add(qu.poll());
            }
        return res;
    }
}
