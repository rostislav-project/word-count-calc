package com.word.count;


import java.util.*;

public class WordMap {

    private Map<String, Integer> wordMap;

    public WordMap() {
        wordMap = new LinkedHashMap<String, Integer>();
    }

    public void caluclateWordCount(String word) {
        Integer count = null;
        if (null != (count = wordMap.get(word))) {
            count++;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }

    public WordMap sortByName() {
        Map<String,Integer>treeMap = new TreeMap<>(wordMap);
        wordMap.clear();
        wordMap.putAll(treeMap);
        return this;
    }

    public WordMap sortByValue() {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        wordMap.clear();

        for (Map.Entry<String, Integer> entry : list) {
            wordMap.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }
}
