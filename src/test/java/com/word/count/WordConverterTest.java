package com.word.count;

import org.junit.Test;

import static org.junit.Assert.*;


public class WordConverterTest {


    @Test
    public void getWordFromTextEmptyString() throws Exception {
        WordConverter converter = new WordConverter();

        assertEquals(0, converter.getWordFromText("").size());
    }

    @Test
    public void getWordFromTextNullInput() throws Exception {
        WordConverter converter = new WordConverter();

        assertEquals(0, converter.getWordFromText(null).size());
    }

    @Test
    public void getWordFromTextSize() throws Exception {
        WordConverter converter = new WordConverter();
        String str = "Over hill and dale, telling their tale";

        assertEquals(7, converter.getWordFromText(str).size());
    }

}