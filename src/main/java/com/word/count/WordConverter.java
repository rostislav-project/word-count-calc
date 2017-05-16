package com.word.count;

import java.util.ArrayList;
import java.util.List;

public class WordConverter {

    public List<String> getWordFromText(String text) {
        List<String> result = new ArrayList<>();

        if (text == null) return result;

        String[] words = text.toLowerCase()
                .replaceAll("[,.!?\"-]", "")
                .replaceAll("\\n", " ")
                .split(" ");

        for (String word : words) {
            if (word.compareTo(" ") != 0 && word.compareTo("") != 0)
                result.add(word);
        }
        return result;
    }
}
