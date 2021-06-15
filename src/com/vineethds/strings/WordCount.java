package com.vineethds.strings;

import java.util.regex.Pattern;

public class WordCount {

    public static int howMany(String sentence) {
        if(sentence.equals(""))
            return 0;

        String[] words = sentence.split(" ");
        int wordCount = 0;
        for(String word : words){
            if(word.contains(".")){
                word = word.replace(".", "");
            }
            if(word.contains(",")){
                word = word.replace(",", "");
            }
            if(word.contains("?")){
                word = word.replace("?", "");
            }
            if(word.contains("!")){
                word = word.replace("!", "");
            }
            if(word.contains("-")){
                word = word.replace("-", "");
            }
            if(Pattern.matches("[a-zA-Z]+", word)){
                wordCount++;
            }
        }

        return wordCount;

    }


    public static void main(String[] args) {
        String s = "he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?";
        int count = howMany(s);
        System.out.print(count);
    }
}
