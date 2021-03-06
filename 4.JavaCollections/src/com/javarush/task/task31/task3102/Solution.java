package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> fileList = new ArrayList<>();
        Queue<File> fileQueue = new PriorityQueue<>();
        Collections.addAll(fileQueue, file.listFiles());

        while (!fileQueue.isEmpty()) {
            File currentFile  = fileQueue.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileQueue, currentFile.listFiles());
            } else if (!currentFile.isDirectory()) {
                fileList.add(currentFile.toString());
            }
        }
        return fileList;

    }

    public static void main(String[] args) {

    }
}
