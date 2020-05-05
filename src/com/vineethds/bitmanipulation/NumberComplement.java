package com.vineethds.bitmanipulation;

public class NumberComplement {

    public int findComplement(int num){
        int[] bit = new int[32];
        for(int i = 0; i < 32;i++){
            if((num & (1<<i)) != 0){
                bit[i] = 1;
            }
        }
        boolean isOneFound = false;
        for(int i =31 ; i >= 0; i--){
            if(bit[i] == 1 && !isOneFound){
                isOneFound = true;
            }
            if(isOneFound){
                if(bit[i] == 1){
                    bit[i] = 0;
                }else{
                    bit[i] = 1;
                }
            }
        }
        int complementNumber = 0;
        for(int i = 0;i < 32 ; i++){
            if(bit[i] == 1)
                complementNumber = complementNumber | (1<<i);
        }
        return complementNumber;
    }

    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        int result = nc.findComplement(5);
        System.out.println(result);
    }
}
