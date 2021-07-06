package com.vineethds.others;

public class StarPattern1 {
/*

                        Input n = 6
                        Output:
                        *
                        **
                        ***
                        ****
                        *****
                        ******
                        ******
                        *****
                        ****
                        ***
                        **
                        *
 */
    public static void createStarPattern(int n ){
        // print first n lines
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j <= i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        //print next n lines
        for(int i = n-1;i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(j <= i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int n  = 6;
        createStarPattern(n);
    }
}
