package com.vineethds.others;
/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.
@Author: Vineeth
@input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
@Output: true
@Hint:
Slope = (y2-y1)/(x2-x1)
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 1) return true;
        float x = coordinates[1][0] - coordinates[0][0];
        float y = coordinates[1][1] - coordinates[0][1];
        float slope = y/x;
        for(int i = 1 ; i < n;i++){
            x = coordinates[i][0] - coordinates[i-1][0];
            y = coordinates[i][1] - coordinates[i-1][1];
            float res = y/x;
            if(res != slope) return false;
        }
        return true;
    }
    public static void main(String[] args) {
     CheckStraightLine ch = new CheckStraightLine();
     int[][] coordinates = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
     boolean result = ch.checkStraightLine(coordinates);
     System.out.println(result);
    }
}
