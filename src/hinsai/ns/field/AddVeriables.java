/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hinsai.ns.field;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author nSense
 */
public class AddVeriables {
    private static AddVeriables addVeriables = new AddVeriables();
    
    public static void addVeriable(File modelFile) throws IOException{
        System.out.println("Do you want to add fields in your model(domain) class. ?\nYou can do this by manully declearing veriables in your model class.\nPress 'Y' for Yes and 'N' for No");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("hins>");
        if(br.readLine().equalsIgnoreCase("y")){
            System.out.println("Write in this form just like in java identifier. {access-specifier kewords data-typ field-name = values;}");
            System.out.println("example: private static int fieldname = 100 or int empid = 100");
            System.out.println("according to your veriables the system will generate 'View' and 'Columns' of your tables, so after declaring veriables you can specify the 'Constraints' for your member");
            System.out.println("example: private static int fieldname; {unique, primary, one-to-one, one-to-many, many-to-one, }");
            System.out.println("OR: private static int fieldname; {You can specify in your way 'i.e your way of Word-Of-Mouth', but make sure that must be specify in curly braces '{--your-specification--}' }");
            System.out.println("enter 'exit' or 'done' to finished your declearing fields.");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FileUtils.readFileToString(modelFile, "UTF-8"));
            String input;
            System.out.print("hins>");
            while((input = br.readLine())!=null){
                int index = stringBuilder.indexOf("//@Hins-Constructor");
                if(input.equals("done")||input.equals("exit")){
                    break;
                }
                else if(input.equals(""))
                    System.out.print("hins>");
                else if(Character.isAlphabetic(input.charAt(0))) {
                    String identifier = null;
                    if(input.contains("{")){
                        if(input.contains(";")){
                            identifier = input.substring(0, input.indexOf(";"));
                            stringBuilder.replace(index-2, index-2, "\t"+identifier+"\n");
                            FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
                            
                        }else{
                            identifier = input.substring(0, input.indexOf("{"));
                            stringBuilder.replace(index-2, index-2, "\t"+identifier+"\n");
                            FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
                            System.out.print("hins>");
                        }
                        String constraints[] = input.substring(input.indexOf('{')+1, input.indexOf('}')).split("\\s+");
                        addVeriables.searchParameter(stringBuilder, constraints, index, modelFile);
                    }
                    else{
                        stringBuilder.replace(index-2, index-2, "\t"+input+"\n");
                        FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
                        System.out.print("hins>");
                    }
                }
            }
        }
    }
    
    public void searchParameter(StringBuilder stringBuilder, String constraints[], int index, File modelFile)throws IOException {
        int i = 0;
        while(i<constraints.length){
            if(constraints[i].toLowerCase().contains("primary")){
                stringBuilder.replace(index-2, index-2, "\t@ID\n");
                FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
            }
            else if(constraints[i].toLowerCase().contains("unique")){
                stringBuilder.replace(index-2, index-2, "\t@UNIQUE\n");
                FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
            }
            else if(constraints[i].toLowerCase().contains("notnull")){
                stringBuilder.replace(index-2, index-2, "\t@NOTNULL\n");
                FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
            }
            else if(constraints[i].toLowerCase().contains("not") && constraints[i+1].toLowerCase().contains("null")){
                stringBuilder.replace(index-2, index-2, "\t@NOTNULL\n");
                FileUtils.write(modelFile, stringBuilder.toString(), "UTF-8");
            }
            i++;
        }
        System.out.print("hins>");
    }
}