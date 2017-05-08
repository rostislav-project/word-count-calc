package com.word.count.math;

import java.util.HashMap;
import java.util.Map;

public class WordMath {

    private Map<String, Integer> result;
    private Integer count;

    public WordMath(){
        result = new HashMap<String, Integer>();
    }

    public void calcWordCount(String word){
        if( (count = result.get(word)) != null){
            count ++;
            result.put(word, count);
        }else
            result.put(word, 1);
    }

    public Map<String, Integer> getResult() {
        return this.result;
    }
}
