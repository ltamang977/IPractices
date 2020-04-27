package org.lv.ipractices.geekforgeeks.array;

public class SearchInSortedRotatedArray {



    public static int search(int[] arr, int key){

        int pivot = findPivotGfg(arr);

        int lo = 0;
        int hi = arr.length - 1;

        if(key == arr[pivot]){
            return pivot;

        }else if (key<arr[0]){
            return binarySearch(arr, pivot+1, hi,  key);

        }else {
            return binarySearch( arr, 0, pivot-1, key);
        }

    }

    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid -1), key);
    }


    /*

     */
    public static int findPivotGfg(int[] arr){

        // 3, 4, 5, 1, 2

        int lo = 0;
        int hi = arr.length - 1;

        while(lo<hi){

            int mid = lo + (hi-lo)/2;

            if(mid<hi && arr[mid]>arr[mid+1]){
                return mid;

            }else if (mid>lo && arr[mid-1]>arr[mid]){
                return mid-1;

            }else if(arr[lo]<=arr[mid]){//left hand sorted
                lo=mid+1;
            }else{
                hi = mid - 1;
            }

        }

        return -1;

    }

    /*

     */
    public static int findPivotIc(int[] arr){

        // 3, 4, 5, 1, 2

        int lo = 0;
        int hi = arr.length - 1;

        while(lo<hi){

            int mid = lo + (hi-lo)/2;


            if(arr[mid] >= arr[0]){
                lo = mid;
            }else {
                hi=mid;
            }

            if(lo+1==hi){
                break;
            }

        }

        return hi;

    }


    public static void main(String[] args){

        int[] arr  = {4,1};//{3,4,5,1,2};

        //rotationUsingGcd(arr, d);
        int p = findPivotGfg(arr);
        int keyIndex = search(arr, 1);

        //int p = findPivotIc(arr);

        System.out.println("pivoit is :"+p);
        System.out.println("keyIndex is :"+keyIndex);
    }
}
