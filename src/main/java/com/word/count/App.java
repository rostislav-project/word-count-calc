package com.word.count;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static java.lang.System.exit;

public class App {

    public void printServiceByLimit(int limit, Map<String, Integer> result){
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            if (limit <= 0)
                break;

            System.out.println(entry.getKey() + " = " + entry.getValue());
            limit --;
        }
    }

    public static void main(String[] args) {

        if(args.length < 2){
            System.out.println("One of parameters is not specified\n[java -jar wordCount.jar $fileName $limit]");
            exit(1);
        }

        String fileName = args[0];
        int limit = Integer.parseInt(args[1]);
        CountService service = new CountService(new WordMap(), new WordConverter());
        App app = new App();

        try{
            service.runService(fileName);
            app.printServiceByLimit(limit,service.getSortResult());

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            exit(1);
        } catch (IOException e) {
            System.out.printf("Failed to calculate words count [%s]",e.getMessage());
            exit(1);
        }
    }
}
