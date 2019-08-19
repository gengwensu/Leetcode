import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summingInt;

public class Solution {
    public static void main(String[] args) {
        int[] ingas={1,2,3,4,5};
        int[] incosts={3,4,5,1,2};
        System.out.println(canCompleteCircuit(ingas, incosts));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas= IntStream.of(gas).sum();
        int totalCost=IntStream.of(cost).sum();
        if (totalGas < totalCost) return -1;
        int N=gas.length;
        int[] diff = new int[N];
        for(int i=0;i<N;i++){
            diff[i]=gas[i]-cost[i];
        }
        //IntStream.of(diff).forEach(System.out::println);

        int ans=-1;
        for(int i=0;i<N;i++){
            int sum=0;
            boolean flag=true;
            for(int j=i;j<i+N;j++){
                int k=j%N;
                sum+=diff[k];
                //System.out.printf("i - %d, j - %d, k - %d, sum - %d, diff - %d\n",i,j,k,sum,diff[k]);
                if (sum<0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans=i;
                break;
            }
        }
        return ans;
    }
}
