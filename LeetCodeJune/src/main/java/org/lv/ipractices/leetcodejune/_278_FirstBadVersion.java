package org.lv.ipractices.leetcodejune;

public class _278_FirstBadVersion {

    public static int firstBadVersion(int n) {

        int first = 1;
        int last = n;

        while(first<=last){
            int mid = first+(last-first)/2;
            boolean isBad = isBadVersion(mid);
            if(isBad){
                //if mid- 1 is not bad
                if(mid==1 || (mid>1 && !isBadVersion(mid-1))){
                    return mid;
                }

                last = mid;

            }else{
                first = mid+1;
            }
        }

        return -1;

    }

    static boolean  isBadVersion(int n){
        if(n==1){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        int v = firstBadVersion( 1);
    }
}
