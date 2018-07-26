/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hinsai.help;

/**
 *
 * @author nSense
 */
public class Help {
       
    public static String helpCreate(){
        System.out.println("Usage: create <options> <source files i.e class-name-arguments>");
        System.out.println("where possible options include:");
        System.out.println("newApp              create a new new App for your project");
        System.out.println("                    example: create newApp <app-name> '-intellij' or '-eclipse' or '-netbeans'");
        System.out.println("                    the end of the 3 argument choos any one of them this will create the project based on the specified IDE");
        System.out.println("controller-class    create a new Controller class");
        System.out.println("domain-class        create a new Domain class i.e your Model class");
        System.out.println("service-class       create a new Service class");
        System.out.println("dao-class           create a new DAO class i.e your Data Access Object class");
        System.out.println("repository-class    create a new Repository class");
        return "";
    }
    
    public static String helpEdit(){
        System.out.println("Usage: edit <options> <source files>");
        System.out.println("where possible options include:");
        System.out.println("-veriable           edit specified member veriables of your class  hit 'add -veriable -help' for more details");
        System.out.println("-methods            edit aspecified methods of your class hit 'add -methods -help' for more details");
        return "";
    }
    
    public static String helpAdd(){
        System.out.println("Usage: add <options> <source files i.e class-name-arguments>");
        System.out.println("where possible options include:");
        System.out.println("-veriable           add a new member veriables into your class  hit 'add -veriable -help' for more details");
        System.out.println("-methods            add a new methods into your class hit 'add -methods -help' for more details");
        return "";
    }
    
    public static String help(){
        helpCreate();
        System.out.println();
        helpEdit();
        System.out.println();
        helpAdd();
        return "";
    }
}
