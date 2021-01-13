package com.haythamxu.blogpostman.utils;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class OsUtil {

    public static void executeShell(String path, String shStr) {
        String command = "cd " + path + " && " + shStr;
        System.out.println(command);
        List<String> strList = new ArrayList<String>();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c", command},null,null);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            process.waitFor();
            while ((line = input.readLine()) != null){
                strList.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println(strList);
    }

}
