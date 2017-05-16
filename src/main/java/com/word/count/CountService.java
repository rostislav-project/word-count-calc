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

    public CountService(String fileName) {
        this.fileName = fileName;
        bf = ByteBuffer.allocate(BUFF_SIZE);
        encoding = System.getProperty("file.encoding");
        wordMap = new WordMap();
        converter = new WordConverter();
    }

    public void runService() throws FileNotFoundException, IOException {
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

    public void printServiceByLimit(int limit){
        Map<String, Integer> result = wordMap.sortByName()
                .sortByValue()
                .getWordMap();

        for(Map.Entry<String, Integer> entry : result.entrySet()){
            if (limit <= 0)
                break;

            System.out.println(entry.getKey() + " = " + entry.getValue());
            limit --;
        }
    }
}
