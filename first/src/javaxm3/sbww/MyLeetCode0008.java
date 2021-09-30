package javaxm3.sbww;

public class MyLeetCode0008 {
    public static void main(String[] args) {
        String a="rrryyyrryyyrr";
        System.out.println(minimumOperations(a));
    }
    public static int minimumOperations(String leaves)
    {
        int[][] dp=new int[leaves.length()][3];
        dp[0][0]=leaves.charAt(0)=='y'?1:0;
        dp[0][1]=dp[0][2]=dp[1][2]=Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            int isRead = leaves.charAt(i)=='r'?1:0;
            int isYellow=leaves.charAt(i)=='y'?1:0;
            dp[i][0] = dp[i-1][0]+isYellow;
            dp[i][1] =Math.min(dp[i-1][0],dp[i-1][1])+isRead;
            if(i>=2)
            {
                dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2])+isYellow;
            }
        }
        return dp[leaves.length()-1][2];
    }
}
