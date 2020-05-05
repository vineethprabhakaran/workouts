package com.vineethds.others;
/*
Problem Statement;
- Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.
- You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    public boolean isBadVersion(int n){
        return (n >= 5);
    }
    /*
    This binary search makes minimized number of calls to the isBadVersion method
     */
    public int findBadVersion(int n ){
        int start = 1;
        int end = n;
        int mid = 0;
        while(start <= end){
            mid = start + (end-start)/2;
            if(start == end && isBadVersion(mid)) return start;
            if (isBadVersion(mid)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FirstBadVersion fv = new FirstBadVersion();
        int result = fv.findBadVersion(5);
        System.out.println(result);
    }
}
