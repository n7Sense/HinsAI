/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hinsai.ns.cmd;

import com.sun.xml.internal.ws.util.StringUtils;
import hinsai.help.Help;
import hinsai.ns.create.CreateController;
import hinsai.ns.create.CreateModel;
import hinsai.ns.msg.Message;
import java.io.IOException;

/**
 *
 * @author nSense
 */
public class Command {
    //Commands
    private final static String create = "create";
    private final static String edit = "edit";
    private final static String add = "add";
    
    //Options
    private final static String newApp = "newApp";
    private final static String controller = "controller-class";
    private final static String domain = "domain-class";
    
    //arguments
    final static String generateAll = "-generate-all";
    

    public static String searchCommand(String input) throws IOException {
        String[] command = input.split("\\s+");
        String message=null;
        switch(command.length){
            case 1:
                if (command[0].equals("-h") || command[0].equals("-help")) {
                    message = Help.help();
                } else {
                    message = Message.commandNotFound + command[0];
                }
                break;
                
            case 2:
                if (command[0].equals(create) && (command[1].equals("-h") || command[1].equals("-help"))) {
                    message = Help.helpCreate();
                } else if (command[0].equals(edit) && (command[1].equals("-h") || command[1].equals("-help"))) {
                    message = Help.helpEdit();
                } else if (command[0].equals(add) && (command[1].equals("-h") || command[1].equals("-help"))) {
                    message = Help.helpAdd();
                } else {
                    message = Message.commandNotFound + command[0] + " " + command[1];
                }
                break;
                
            case 3:
                if (command[0].equals(create) && (command[1].equals(controller) || command[1].equals(domain)) && Character.isAlphabetic(command[2].charAt(0))) {
                    if (command[1].equals(domain)) {
                        message = CreateModel.createModel(StringUtils.capitalize(command[2]));
                    } else if (command[1].equals(controller)) {
                        message = CreateController.createController(StringUtils.capitalize(command[2]));
                    }
                } else if (command[0].equals(create) && command[1].equals(newApp) && Character.isAlphabetic(command[2].charAt(0))) {

                } else {
                    message = Message.commandNotFound + command[0] + " " + command[1] + " " + command[2];
                }
                break;
                
            case 4:
                if (command[0].equals(create) && command[1].equals(domain) && Character.isAlphabetic(command[2].charAt(0)) && command[3].equals(generateAll)) {

                } else {

                }
                break;
            
            default: message = Message.commandNotFound + input;
            break;
        }
        
        return message+"\n";
    }    
}
