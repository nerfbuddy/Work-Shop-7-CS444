package Project4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class aTerminal {

public static String s;
public static boolean x = true;
    public static void main (String[] args) {
        ReportWriter rp = new ReportWriter();
        boolean var = true;
        while (var) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("\nEnter 1 for provider, 2 for manager, 3 for operator or 4 for main acc pro. Type exit to end program");
            String s = myObj.nextLine();
            switch (s) {
                case "1":
                    ProviderTerminal pro = new ProviderTerminal();
                    if(pro.LoginPro())
                    {
                        pro.startTerm();
                        var = false;
                        break;
                    }
                    else
                    {
                        //System.out.println("Invalid login.");
                    }
                    break;
                case "3":
                    OpTerminal op = new OpTerminal();
                    if(op.LoginOp())
                    {
                        op.startTerm();
                        var = false;
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid login.");
                    }
                    break;
                case "2":
                    ManagerTerminal man = new ManagerTerminal();
                    if(man.LoginMan())
                    {
                        man.startTerm();
                        var = false;
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid login.");
                    }
                    break;
                case "4":
                    MemberDatabase me = new MemberDatabase();
                    me.writememrport();
                    ProviderDatabase pro1 = new ProviderDatabase();
                    pro1.writeproviderrport();
                    break;
                case "exit":
                    var = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Unknown command, please enter 1 2 or 3");
                    x = false;
                    break;
            }

        }


    }
}
