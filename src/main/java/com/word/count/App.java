package com.word.count;


import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) {

        args = new String[]{"/home/dn021092trd/IdeaProjects/words-calc/src/main/resources/demo.txt", "3"};

        if(args.length < 2){
            System.out.println("One of parameters is not specified\n[java -jar wordCount.jar $fileName $limit]");
            exit(1);
        }

        String fileName = args[0];
        int limit = Integer.parseInt(args[1]);
        CountService service = new CountService(fileName);

        try{
            service.runService();
            service.printServiceByLimit(limit);

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            exit(1);
        } catch (IOException e) {
            System.out.printf("Failed to calculate words count [%s]",e.getMessage());
            exit(1);
        }
    }
}
