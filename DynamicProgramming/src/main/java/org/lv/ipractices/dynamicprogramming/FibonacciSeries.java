package org.lv.ipractices.dynamicprogramming;

public class FibonacciSeries {

    static int count = 0;

    /**
     * FibonacciRecursion
     * @param n
     * @return
     */
    public static int fibonacciRecursion(int n){

        count++;

        if(n==0 || n==1){
            return n;
        }

        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }

    /**
     * Fibonacci memoized
     * @param n
     * @return
     */
    public static int fibonacciMemoized(int n){
        int[] memo = new int[n+1];
        for(int i=0; i<=n; i++){
           memo[i]= -1;
        }
        return fibonacciMemoized(n, memo);
    }

    public static int fibonacciMemoized(int n, int[] memo){
        count++;

        if(n==0 || n==1){
            return n;
        }

        if(memo[n]>-1){
                return  memo[n];
        }

        int result = fibonacciMemoized(n-1, memo) + fibonacciMemoized(n-2, memo);
        memo[n]=result;

        return result;
    }

    /**
     * FibonacciRecursion
     * @param n
     * @return
     */
    public static int fibonacciDP(int n){

        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];

    }

    public static void main(String[] args){
        //System.out.println("Fibonacci is  : "+fibonacciRecursion(10));

       // System.out.println("Fibonacci is  : "+fibonacciMemoized(10));

        System.out.println("Fibonacci is  : "+fibonacciDP(10));
        //fibonacciDP

        //fibonacciMemoized
        System.out.println("The count is :"+count);

    }
}

//13
//8 -> 21
//9 --> 34
//10 -> 55