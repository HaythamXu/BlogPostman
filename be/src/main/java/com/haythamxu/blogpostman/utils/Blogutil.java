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

    public static Collection<BlogDTO> getFiles(String basePath, String [] ignoreFile, String path) {
        final File files = new File(path);
        Collection<BlogDTO> blogDTOCollection = new ArrayList<>();
        Arrays.stream(files.listFiles()).forEach(file -> {
            if(!Arrays.asList(ignoreFile).contains(file.getName())) {
                if (file.isDirectory()) {
                    getFiles(basePath, ignoreFile, file.getPath());
                } else {
                    BlogDTO blogDTO = new BlogDTO();
                    blogDTO.setTitle(file.getName());
                    blogDTO.setRelativePath(Blogutil.getFolderPath(basePath, file.getPath(), file.getName()));
                    blogDTOCollection.add(blogDTO);
                }
            }
        });
        return blogDTOCollection;
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
