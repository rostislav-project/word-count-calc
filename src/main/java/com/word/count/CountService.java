package com.word.count;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class CountService {
    public static final int BUFF_SIZE = 4096;

    private String fileName;
    private FileChannel ch;
    private ByteBuffer bf;
    private String encoding;

    private WordMap wordMap;
    private WordConverter converter;

    public CountService(WordMap wordMap, WordConverter converter) {
        bf = ByteBuffer.allocate(BUFF_SIZE);
        encoding = System.getProperty("file.encoding");
        this.wordMap = wordMap;
        this.converter = converter;
    }

    public void runService(String fileName) throws FileNotFoundException, IOException {
        this.fileName = fileName;
        ch = new FileInputStream(fileName).getChannel();
        String text = null;
        List<String> words;

        try{
            while ((ch.read(bf)) != -1) {
                bf.flip();
                text = Charset.forName(encoding)
                        .decode(bf)
                        .toString();

                words = converter.getWordFromText(text);
                for (int i = 0; i < words.size(); i++)
                    wordMap.caluclateWordCount(words.get(i));
                bf.clear();
            }
        }catch (IOException e){
            throw  e;
        }finally {
            ch.close();
        }
    }

    public Map<String, Integer> getSortResult(){
        return wordMap.sortByName()
                .sortByValue()
                .getWordMap();
    }


}
