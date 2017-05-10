package com.word.count;

import com.word.count.math.WordMath;
import com.word.count.readers.FileReader;
import com.word.count.readers.WordReader;
import com.word.count.util.MapUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

public class App {
    public static final int BUFF_SIZE  = 4096;

    public static void main(String[] args) throws IOException {

//        args = new String[]{"/home/dn021092trd/IdeaProjects/words-calc/src/main/resources/demo.txt", "10"};
        if(args.length < 2){
            System.out.println("One of parameters is not specified\n[java -jar wordCount.jar $fileName $limit]");
            exit(1);
        }

        String fileName = args[0];
        int limit = Integer.parseInt(args[1]);

        ByteBuffer bf = ByteBuffer.allocate(BUFF_SIZE);
        FileChannel ch = new FileReader(fileName).getCh();
        WordMath wordMath = new WordMath();

        String encoding = System.getProperty("file.encoding");
        String text = null;
        List<String> words;

        try{
            while((ch.read(bf)) != -1){
                bf.flip();
                text = Charset.forName(encoding)
                        .decode(bf)
                        .toString();

                words = WordReader.getWordFromText(text);

                for(int i = 0; i < words.size(); i++)
                    wordMath.calcWordCount(words.get(i));
                bf.clear();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            exit(1);
        }
        finally { ch.close(); }

//        TODO Decorator for sorting
        Map<String, Integer> result = MapUtil.sortByValue(MapUtil.sortByName(wordMath.getResult()));

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (limit <= 0)
                break;
            System.out.println(entry.getKey() + " = " + entry.getValue());
            limit --;
        }

    }
}
