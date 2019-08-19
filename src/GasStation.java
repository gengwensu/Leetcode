/*[LeetCode]134 Gas Station 加油站问题



        There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

        Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

        Note:
        The solution is guaranteed to be unique.*/

public class GasStation {
    public static void main(String[] args) {
        int[] ingas = {1, 2, 3, 4, 5};
        int[] incosts = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(ingas, incosts));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, runningSum = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            runningSum += gas[i] - cost[i];
            if (runningSum < 0) {
                start = i + 1;
                runningSum = 0;
            }
        }
        return (total < 0) ? -1 : start;
    }
}
