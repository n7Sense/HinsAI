/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hinsai.ns.create;

import com.sun.xml.internal.bind.v2.schemagen.Util;
import hinsai.ns.cmd.Command;
import static hinsai.ns.create.CreateProject.getIndex;
import hinsai.ns.msg.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.FileUtils;
import hinsai.ns.field.AddVeriables;

/**
 *
 * @author nSense
 */
public class CreateModel {
     
    private static File modelFile;
    public static String createModel(String capitalize) throws IOException{
        String cl = "package hins.domain;\n/**\n*\n* @author Hins-AI\n*\n*/\npublic class "+capitalize+"Domain {\n\n\t//@Hins-Fileds\n\n\t//@Hins-Constructor\n\t"+capitalize+"Domain(){\n\t\tsuper();\n\t}\n\n\t"+"//@Hins-Methods\n}";
        modelFile = new File(System.getProperty("user.dir")+"\\keshav\\src\\main\\java\\hins\\domain\\"+capitalize+"Domain.java");
        if(modelFile.createNewFile()){
            FileUtils.write(modelFile, cl, "UTF-8");
            AddVeriables.addVeriable(modelFile);
        }else{
            return Message.file3+capitalize+"Domain.java";
        }
       return Message.file4+capitalize+"Domain.java";
    }
}
