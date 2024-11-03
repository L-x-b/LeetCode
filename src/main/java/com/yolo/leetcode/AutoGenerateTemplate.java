package com.yolo.leetcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoGenerateTemplate {

    public static String problemName = "binary-tree-inorder-traversal";
    public static String number = "0094";

    public static void main(String[] args) {

        // 根据路径转成包名和文件名
        List<String> strings = pathToPackageNameAndFileName(problemName, number);
        String packageName = strings.get(0);
        String fileName = strings.get(1);


        // 定义文件名和路径
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory += File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "yolo" + File.separator + "leetcode";


        // 创建文件目录
        File directory = new File(currentDirectory, packageName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // 创建文件
        File file = new File(directory, fileName);
        if (file.exists()) {
            System.out.println("文件已存在。");
            return;
        }
        try {
            file.createNewFile();
            System.out.println("文件创建成功。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 内容准备
        String content = "";
        content += "package com.yolo.leetcode." + packageName + ";\n\n";
        content += "public class " + fileName.substring(0, fileName.lastIndexOf('.')) + " {" + "\n\n}";

        // 写入内容
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            System.out.println("内容写入成功。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static List<String> pathToPackageNameAndFileName(String path, String number) {
        List<String> res = new ArrayList<>();

        // 将路径转换成packageName
        String packageName = path.replace("-", "_");
        packageName = "_" + number + "_" + packageName;

        // 将路径转换成fileName
        String[] parts = path.split("-");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(Character.toUpperCase(part.charAt(0)));
            sb.append(part.substring(1));
        }
        String fileName = sb.toString() + ".java";

        // 存入列表
        res.add(packageName);
        res.add(fileName);

        return res;

    }


}