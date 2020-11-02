package com.vineethds.strings;
/*
M - Decreasing order
N - Increasing order

ex:
MM - 321
NM - 132
the number should me the lowest;
 */
public class SmallestNumberMatching {
    public static void main(String[] args) {
        System.out.println(findPossibleSmallestNumberMatchingPattern("NMMMNNMM"));
    }
    static String findPossibleSmallestNumberMatchingPattern(String pattern) {
        if(pattern.length() > 8){
            return"-1";
        }
        int curr_max  = 0;
        int last_entry = 0;
        int j = 0;
        String res = "";
        for(int i = 0; i < pattern.length();i++){
            int noM = 0;
            switch (pattern.charAt(i)){
                case 'N':
                    j = i+1;
                    while(j < pattern.length() && pattern.charAt(j) == 'M'){
                        noM++;
                        j++;
                    }
                    if(i == 0){
                        curr_max = noM + 2;
                        res += ""+(++last_entry)+""+curr_max;
                        last_entry = curr_max;
                    }else{
                        curr_max = curr_max + noM +1;
                        res += curr_max;
                        last_entry = curr_max;
                    }
                    for(int k = 0; k < noM ; k++){
                        res = res +""+(--last_entry);
                        i++;
                    }
                    break;
                case 'M':
                    j = i + 1;
                    while(j < pattern.length() && pattern.charAt(j) == 'M'){
                        noM++;
                        j++;
                    }
                    if(i == 0){
                        curr_max = noM + 2;
                        res  =  res +""+ curr_max +""+ (curr_max - 1 );
                        last_entry = curr_max -1;
                    }else{
                        res = res + ""+(--last_entry);
                    }
                    break;
            }
        }
        return res;
    }
}
