/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hinsai;

import hinsai.ns.cmd.Command;
import hinsai.ns.create.CreateProject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import hinsai.ns.msg.Message;

/**
 *
 * @author nSense
 */
public class HinsAI {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if(args.length>1){
            if( (args.length>=3 && args.length<=4) && (args[0].equals("create") && args[1].equals("newApp") && Character.isAlphabetic(args[2].charAt(0)) && (args[3].equals("-intellij") || args[3].equals("-eclipse") || args[3].equals("-netbeans")) ) ){
                String message = CreateProject.createProject(args[2]);
                if(message.equals("1")){
                        System.out.println("Creating app :"+args[2]+" Status : Success");
                    }else{
                        System.err.println(message);
                    }
            }else{
                System.err.print(Message.commandNotFound);
                System.exit(0);
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        if(args.length<1){
            System.out.print("hins>");
            while((input = br.readLine())!=null){
                
                if(input.equals("exit")){
                    br.close();
                    break;
                }
                else if(input.equals(""))
                    System.out.print("hins>");
                else if(Character.isDigit(input.charAt(0))){
                    System.err.println(Message.commandNotFound+input);
                    System.out.print("hins>");
                }else{
                   System.err.print(Command.searchCommand(input));
                   System.out.print("hins>");
                }
            }
        }
    }
}
