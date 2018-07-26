/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hinsai.ns.create;

import hinsai.ns.msg.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author nSense
 */
public class CreateProject {
    static File appRootFIle;

    public static String createProject(String appName) throws IOException {

        appRootFIle = new File(appName);
        File sourceFile = new File("C:\\nSense\\resource");
        File compiler = new File(System.getProperty("user.dir") + "\\" + appName + "\\.idea\\compiler.xml");
        File pom = new File(System.getProperty("user.dir") + "\\" + appName + "\\pom.xml");
        if (!appRootFIle.exists()) {
            if (searchDirectories()<1) {
                appRootFIle.mkdir();
                if (appRootFIle.exists()) {
                    FileUtils.copyDirectory(sourceFile, appRootFIle);
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String groupId = null, artifactId = null;
                    System.out.println("This project is based on Maven \nplease spsecify the <groupId> and <artifactId> for maven");
                    System.out.println("Please enter the groupId example : org.hins.myapp ");
                    System.out.print("hins>");
                    groupId = br.readLine();
                    System.out.println("Please enter the artifactId example : may be ur project name or other\nBy default it will take ur project name.");
                    System.out.print("hins>");
                    artifactId = br.readLine();
                    br.close();

                    if (groupId.matches(".*[a-zA-Z0-9].*")) {
                        editProjectFiles(appName, compiler, artifactId, groupId);
                        editProjectFiles(appName, pom, artifactId, groupId);
                    } else {
                        groupId = "hinsai.ns";
                        artifactId = appName;
                        editProjectFiles(appName, compiler, artifactId, groupId);
                        editProjectFiles(appName, pom, artifactId, groupId);
                    }
                }
            } else {
                return Message.file2 + appName;
            }
        } else {
            return Message.file1 + appName;
        }
        return "1";
    }

    public static int searchDirectories() {
        int count = 0;
        File allFile = new File(System.getProperty("user.dir"));
        String[] allFileName = allFile.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory() || new File(current, name).isFile();
            }
        });
        for (String name : allFileName) {
            if (name.equals(".idea") || name.equals("src") || name.equals("pom.xml") || name.equals("hins.ns")) {
                count++;
            }
        }
        return count;
    }

    public static void editProjectFiles(String appName, File editFile, String artifactId, String groupId) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(editFile));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FileUtils.readFileToString(editFile));
        reader.close();
        if (editFile.getName().equals("compiler.xml")) {
            stringBuilder.replace(stringBuilder.indexOf("<module"), getIndex(stringBuilder, stringBuilder.indexOf("<module")), "<module name=\"" + appName + "\" />");
        }
        if (editFile.getName().equals("pom.xml")) {
            stringBuilder.replace(stringBuilder.indexOf("<groupId>"), getIndex(stringBuilder, stringBuilder.indexOf("</groupId")), "<groupId>" + groupId + "</groupId>");
            stringBuilder.replace(stringBuilder.indexOf("<artifactId>"), getIndex(stringBuilder, stringBuilder.indexOf("</artifactId")), "<artifactId>" + artifactId + "</artifactId>");
        }
        FileWriter fileWriter = new FileWriter(editFile);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
        return;
    }

    public static int getIndex(StringBuilder builder, int index) {
        while (builder.charAt(index) != '\n') {
            index++;
        }
        return index;
    }
}
