package com.vineethds.arrays;

class ShortestWindowSort {

    public static int sort(int[] arr) {
        int low = 0;
        int right = arr.length-1;
        while(low < arr.length-1 && arr[low] <= arr[low+1])
            low++;

        if(low == arr.length-1)
            return 0;

        while(right > 0 && arr[right] >= arr[right-1])
            right--;

        int submin = Integer.MAX_VALUE;
        int submax = Integer.MIN_VALUE;
        for(int i = low; i <= right;i++){
            submin = Math.min(submin,arr[i]);
            submax = Math.max(submax,arr[i]);
        }
        while(low > 0 && arr[low -1] > submin)
            low--;

        while(right < arr.length-1 && arr[right + 1] < submax)
            right++;

        return right - low +1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
