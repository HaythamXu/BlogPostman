package com.haythamxu.blogpostman.utils;

public class GitUtil {

    private static String REPOSITORY_PATH = "/src/main/resources/blog/";

    public static void init(String name, String email) {

    }

    public static void clone(String targetPath, String token ,String repositoryUrl) {
        String cloneCammnd = "git clone https://" + token + "@" + repositoryUrl;
        OsUtil.executeShell(targetPath, cloneCammnd);
    }

    public static void pull(String targetPath) {
        String pullCommand = "git pull";
        OsUtil.executeShell(targetPath, pullCommand);
    }

}
