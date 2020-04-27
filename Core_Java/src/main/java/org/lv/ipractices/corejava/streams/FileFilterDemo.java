package org.lv.ipractices.corejava.streams;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {

    class JavaFileFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return false;
        }
    }


    public static void demo(){

    }
}
