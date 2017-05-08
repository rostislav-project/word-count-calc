package com.word.count.math;

import org.junit.Test;

import static org.junit.Assert.*;


public class WordMathTest {
    @Test
    public void calcWordCountSize() throws Exception {
        WordMath wordMath = new WordMath();
        wordMath.calcWordCount("hello");

        assertNotEquals("Checking failed size", 3, wordMath.getResult().size());
        assertEquals("Checking true size", 1, wordMath.getResult().size());
    }

    @Test
    public void calcWordCountNull() throws Exception{
        WordMath wordMath = new WordMath();
        wordMath.calcWordCount("hello");

        assertEquals("Checking not exists key", null, wordMath.getResult().get("hi"));
    }

    @Test
    public void calcWordCount() throws Exception{
        WordMath wordMath = new WordMath();
        wordMath.calcWordCount("hello");
        wordMath.calcWordCount("hello");
        wordMath.calcWordCount("hello");

        assertEquals((Integer) 3, wordMath.getResult().get("hello"));
    }

}