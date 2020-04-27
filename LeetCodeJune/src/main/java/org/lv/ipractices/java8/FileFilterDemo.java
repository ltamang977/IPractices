package org.lv.ipractices.java8;


import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

class JavaFileFilter implements FileFilter{

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}

public class FileFilterDemo {

    public static void main(String[] args){




        JavaFileFilter filter = new JavaFileFilter();
        File dir = new File("/Users/Labin/Engineering/IdeaProjects/IPractices/LeetCodeJune/src/main/java/org/lv/ipractices/java7/core");
        File[] files = dir.listFiles(filter);
        System.out.println("Files:"+ Arrays.toString(files));


        FileFilter ff = (File file) -> file.getName().endsWith(".java");

    }





}
