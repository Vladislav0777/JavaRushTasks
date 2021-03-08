package com.javarush.task.task31.task3111;

import com.javarush.task.task31.task3101.Solution;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String name = null;
    private String partOfContent = null;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> result = new ArrayList<>();

    public void setPartOfName(String amigo) { this.name = amigo; }
    public void setPartOfContent(String programmer) { this.partOfContent = programmer;}
    public void setMinSize(int i) { this.minSize = i; }
    public void setMaxSize(int i) { this.maxSize = i; }
    public List<Path> getFoundFiles() {
        return result;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] contentSize = Files.readAllBytes(file); // размер файла: content.length

        boolean containsSizeMin = true;
        if (contentSize.length < 500) {
            containsSizeMin = false;
            if (minSize==-1) {
                containsSizeMin = false;
            }
        }

        boolean containsSizeMax = true;
        if (contentSize.length > 10000) {
            containsSizeMax = false;
        }

        boolean containsName = true;
        if (name != null && !file
                .getFileName()
                .toString()
                .contains(name)) {
            containsName = false;
        }

        String contentFile = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if(partOfContent!=null && !contentFile.contains(partOfContent)) {
            containsContent = false;
        }

        if(containsName && containsContent && containsSizeMin && containsSizeMax) {
            result.add(file);
        }
        return super.visitFile(file, attrs);
    }

}
