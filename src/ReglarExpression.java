/*[LeetCode]134 Gas Station 加油站问题



        There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

        Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

        Note:
        The solution is guaranteed to be unique.*/

public class ReglarExpression {
    public static void main(String[] args) {
        //String input = "aa", pattern = "a*";
        //String input = "aa", pattern = "a";
        //String input = "ab", pattern = ".*";
        //String input = "aab", pattern = "c*a*b";
        //String input = "mississippi", pattern = "mis*is*p*.";
        String input = "ab", pattern = ".*c";

        System.out.println(isMatch(input, pattern));
    }

    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        if(p.length()>1 && p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))
                    || (!s.isEmpty() && (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.') && isMatch(s.substring(1),p));
        } else return !s.isEmpty() && (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.') && isMatch(s.substring(1),p.substring(1));
    }
}
