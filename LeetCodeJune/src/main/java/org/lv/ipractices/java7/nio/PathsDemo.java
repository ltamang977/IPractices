package org.lv.ipractices.java7.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathsDemo {


    public static void demo(){

        Path path = Paths.get("Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/nio/java7_demo.txt");


        //Path path = Paths.get("java7_demo.txt");

        System.out.println(path.toString());
        System.out.println(path.getFileName());
        System.out.println(path.getNameCount());
        System.out.println(path.getName(0)+ " "+path.getName(path.getNameCount()-1));
        ///Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/nio/java7_demo.txt

    }

    public static void moveDemo() throws IOException {

        Path src = Paths.get("Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/nio/java7_demo.txt");

        Path dest = Paths.get("Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/nio/temp_dest.txt");


        Files.copy(src, dest, StandardCopyOption.COPY_ATTRIBUTES);
        //Path path = Paths.get("java7_demo.txt");
        ///Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/nio/java7_demo.txt

    }

    public static void createDir() throws IOException {

        Path path = Paths.get("temp");
        Files.createDirectory(path);


    }

    public static void readerDemo()   {

        Path path = Paths.get("Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/nio/java7_demo.txt");

        try(BufferedReader reader = Files.newBufferedReader(path)){

            String s = null;
            while(( s = reader.readLine())!=null){
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {

        //demo();
       // moveDemo();
       // createDir();
        readerDemo();

    }
}
