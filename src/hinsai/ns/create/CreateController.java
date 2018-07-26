/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hinsai.ns.create;

import hinsai.ns.msg.Message;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author nSense
 */
public class CreateController {
    private static File controllerlFile;
    public static String createController(String capitalize) throws IOException {
        String cl = "package hins.controller;\n/**\n*\n* @author Hins-AI\n*\n*/\npublic class "+capitalize+"Controller {\n\t\n}";
        controllerlFile = new File(System.getProperty("user.dir")+"\\keshav\\src\\main\\java\\hins\\controller\\"+capitalize+"Controller.java");
        if(controllerlFile.createNewFile()){
            FileUtils.write(controllerlFile, cl, "UTF-8");
        }else{
            return Message.file3+capitalize+"Controller.java";
        }
        return Message.file5+capitalize+"Controller.java";
    }
}
