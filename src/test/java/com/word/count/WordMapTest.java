package com.word.count;

import org.junit.Test;

import static org.junit.Assert.*;


public class WordMapTest {


    @Test
    public void caluclateWordCountCheckAfterAdd() throws Exception {

        WordMap wordMap = new WordMap();
        wordMap.caluclateWordCount("bang");
        assertNotEquals(0, wordMap.getWordMap().size() );
    }

    @Test
    public void caluclateWordCountSize(){
        WordMap wordMap = new WordMap();
        wordMap.caluclateWordCount("one");
        wordMap.caluclateWordCount("two");
        wordMap.caluclateWordCount("three");

        assertEquals(3, wordMap.getWordMap().size() );

        for(int i = 0; i < 5; i++)
            wordMap.caluclateWordCount("mix");

        assertEquals(4, wordMap.getWordMap().size() );
    }

    @Test
    public void caluclateWordCountCurrVal(){
        WordMap wordMap = new WordMap();
        for(int i = 0; i < 10; i++)
            wordMap.caluclateWordCount("some");

        assertEquals((Integer)10, wordMap.getWordMap().get("some"));
    }

    @Test
    public void caluclateWordCountCheckKeyExists(){
        WordMap wordMap = new WordMap();
        for(int i = 0; i < 10; i++)
            wordMap.caluclateWordCount("some");

        assertEquals(null, wordMap.getWordMap().get("any"));
    }

}