package org.lv.ipractices.dynamicprogramming;

public class MinimumToOne {


    public static int minimumStepsToOneMemoization(int n){

        int memo[] = new int[n+1];
        for(int i=1; i<=n; i++) {
            memo[i]=-1;
        }
        return minimumStepsToOne(n, memo);

    }


    public static int minimumStepsToOne(int n, int[] memo){

        if(n<=1)
            return 0;

        if(memo[n]>-1) {
            System.out.println("Memo found :"+memo[n]);
            return memo[n];
        }

        int r= 1+minimumStepsToOne(n-1, memo);

        if( n%2 == 0 )
            r  =  Math.min( r , 1 + minimumStepsToOne( n / 2 , memo) ) ;

        if( n%3 == 0 )
            r  =  Math.min( r , 1 + minimumStepsToOne( n / 3 , memo) ) ;

        memo[n]=r;

        return r;

    }


    public static int minimumStepsToOneDynamicProgramming(int n){

        int dp[] = new int[n+1];
        int i;

        dp[1] = 0;  // trivial case

        for( i = 2 ; i <= n ; i ++ ) {

            dp[i] = 1 + dp[i-1];

            if(i%2==0) dp[i] = Math.min( dp[i] , 1+ dp[i/2] );

            if(i%3==0) dp[i] = Math.min( dp[i] , 1+ dp[i/3] );

        }

        return dp[n];

    }


    public static void main(String[] args){

        //int result = minimumStepsToOneMemoization(4);
        //minimumStepsToOneDynamicProgramming
        int result = minimumStepsToOneDynamicProgramming(5);
        System.out.println(result);

    }
}
