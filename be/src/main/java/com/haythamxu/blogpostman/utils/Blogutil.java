package com.haythamxu.blogpostman.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.haythamxu.blogpostman.dto.BlogDTO;

public class Blogutil {

    public static Collection<BlogDTO> blogDTOCollection = new ArrayList<>();

    public static Collection<BlogDTO> getFiles(String basePath, String [] ignoreFile, String path) {
        File[] files = new File(path).listFiles();
        BlogDTO blogDTO;
        for (int i=0; i< files.length; i++) {
            if(!Arrays.asList(ignoreFile).contains(files[i].getName())) {
                if(files[i].isDirectory()) {
                    Blogutil.getFiles(basePath, ignoreFile, files[i].getPath());
                } else {
                    blogDTO = new BlogDTO();
                    blogDTO.setTitle(files[i].getName());
                    blogDTO.setRelativePath(Blogutil.getFolderPath(basePath, files[i].getPath(), files[i].getName()));
                    Blogutil.blogDTOCollection.add(blogDTO);
                }
            }
        }
        return Blogutil.blogDTOCollection;
    }

    public static String getBlogContent(String path, String blogName) {
        String blogContent = null;
        try {
            File file = new File(path + blogName);
            FileInputStream fip = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            blogContent = sb.toString();
            reader.close();
            fip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blogContent;
    }

    private static String getFolderPath(String basePath, String fullPath, String fileName) {
        return fullPath.substring(basePath.length(), fullPath.length()-fileName.length());
    }
}
