package com.word.count.readers;

import java.util.ArrayList;
import java.util.List;

public class WordReader {

    public static List<String> getWordFromText(String text){
        List<String> result = new ArrayList<>();
        String[] words = text.toLowerCase()
                .replaceAll("[,.!?\"-]","")
                .replaceAll("\\n"," ")
                .split(" ");

        for(String word: words){
            if(word.compareTo(" ") != 0 && word.compareTo("") != 0)
                result.add(word);
        }
        return result;
    }
}
