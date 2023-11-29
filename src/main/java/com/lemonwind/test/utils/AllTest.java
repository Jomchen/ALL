package com.lemonwind.test.utils;

import java.io.File;

/**
 * create by lemonwind on 2018/12/26
 */
public class AllTest {

    public static void main(String[] args) {
        File file = new File("/WORK_MESSAGE/");
        String[] fileNames = file.list();
        File[] files = file.listFiles();


        printAllFiles(files);

    }

    public static void printAllFileNames(String ... paths) {
        for (int i = 0; i < paths.length; i ++) {
            System.out.println("------------------>" + paths[i]);
        }
    }

    public static void printAllFiles(File ... paths) {
        for (int i = 0; i < paths.length; i ++) {
            File file = paths[i];
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                printAllFiles(files);
            } else {
                String name = file.getName();
                if (name.endsWith(".jar")) {
                    /*System.out.println("*******************>" + name);*/
                    System.out.println("------------------->" + file.getAbsolutePath());
                }
                file.delete();
            }
        }
    }

}
