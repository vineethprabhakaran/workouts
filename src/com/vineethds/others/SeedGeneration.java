package com.vineethds.others;

public class SeedGeneration {
    public static void main(String[] args) {
        int[][] gen = new int[10][5];
        gen[2][2] = 1;
        gen[3][2] = 1;
        gen[3][3] = 1;
        gen[4][1] = 1;
        gen[4][2] = 1;
        gen[6][0] = 1;

        int[][] result = findNextGen(gen);

        displayResult(result);

    }

    public static int[][] findNextGen(int[][] gen){
        int row = gen.length;
        int col = gen[0].length;
        int[][] result = new int[row][col];
        int[] offset = {0, -1, 1};

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                int noOfCellsAlive = 0;

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(offset[i] ==0 && offset[j] == 0)
                            continue;

                        int x = r + offset[i];
                        int y = c + offset[j];
                        if(x >= 0 && y >= 0 && x < row && y < col && gen[x][y] == 1){
                            noOfCellsAlive++;
                        }

                    }
                }
                if((noOfCellsAlive == 2 || noOfCellsAlive == 3 ) && gen[r][c] == 1){
                   result[r][c] = 1;
                }else if(noOfCellsAlive == 3 && gen[r][c] == 0){
                    result[r][c] = 1;
                }
            }
        }
        return result;
    }

    public  static void displayResult(int[][] result){
        for(int i = 0 ; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] +" ");
            }
            System.out.println("");
        }
    }

}
