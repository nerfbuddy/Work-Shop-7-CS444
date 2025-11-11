package Project4;

/**
 * Class representing the opTerminal functionalities.
 * It also encapsulates services provided by the operator.
 * @author Nahom Workalemahu
 */

import java.util.*;

public class OpTerminal {
    public Scanner scanner = new Scanner(System.in);
    public MemberDatabase md = new MemberDatabase();
    public ProviderDatabase pd = new ProviderDatabase();
    public boolean LoginOp()
    {
        OperatorVerifier opv = new OperatorVerifier();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter your nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter your password: ");
        String MemberPassword = myObj.nextLine();

        Operator userMember = new Operator(MemberName, MemberID, MemberPassword);



        if(!(opv.LoginOperator(userMember))) {
            System.out.print("Invaild login.");
            return false;
        }
        else
        {
            System.out.print("Validated.");
            return true;
        }


    }
    public void startTerm(){

        //System.out.println("\nYou have selected: Run Interactive Mode\n");
        System.out.println("Please select an action:\n");
        System.out.println("1: Add Provider  2: Remove Provider  3: Edit Provider");
        System.out.println("4: Add Member    5: Remove Member    6: Edit Member\n exit: return to main terminal");
        System.out.println("Choose a selection by entering a number 1-6:");
        
        String command = scanner.nextLine(); 

        if (command.equals("1")) {
            addProvider();
            startTerm();
        }
        else if (command.equals("2")) {
            removeProvider();
            startTerm();
        }
        else if (command.equals("3")) {
            editProvider();
            startTerm();
        }
        else if (command.equals("4")) {
            addMember();
            startTerm();
        }
        else if (command.equals("5")) {
            removeMember();
            startTerm();
        }
        else if (command.equals("6")) {
            editMember();
            startTerm();
        }
        else if(command.equals("exit"))
        {
            aTerminal.main(new String[]{"a", "b"});
        }
        else {
            System.out.println("\nCommand not found. Please try again.");
            startTerm();
        }
    }



    public void addMember() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter member name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter member nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter member password: ");
        String MemberPassword = myObj.nextLine();
        if(md.addUser(new Member(MemberName, MemberID, MemberPassword)))
        {
            System.out.println("Added new member");
            md.save();
        }
        else
        {
            System.out.println("Member already exits");
        }
    }

    public void addProvider() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Provider name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter Provider ID number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter Provider password: ");
        String MemberPassword = myObj.nextLine();
        if(pd.addUser(new Provider(MemberName, MemberID, MemberPassword)))
        {
            System.out.println("Added new Provider");
            pd.save();
        }
        else
        {
            System.out.println("Provider already exits");
        }
    }

    public void editMember() {

        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter ID of member you want to edit: ");
        User userToEdit = new Member(null,Integer.parseInt(myObj.nextLine()), null);
        userToEdit = md.search(userToEdit);
        userToEdit.getInfo();
        System.out.println("now re enter desired data.");

        System.out.println("Enter member name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter member nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter member password: ");
        String MemberPassword = myObj.nextLine();
        md.removeUser(userToEdit);
        if(md.addUser(new Member(MemberName, MemberID, MemberPassword)))
        {
            System.out.println("Added new member");
            md.save();
        }
        else
        {
            System.out.println("Member already exits");
        }
    }

    public void editProvider() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter ID of Provider you want to edit: ");
        User userToEdit = new Provider(null,Integer.parseInt(myObj.nextLine()), null);
        userToEdit = md.search(userToEdit);
        userToEdit.getInfo();
        System.out.println("now re enter desired data.");


        System.out.println("Enter Provider name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter Provider nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter Provider password: ");
        String MemberPassword = myObj.nextLine();
        pd.removeUser(userToEdit);
        if(pd.addUser(new Provider(MemberName, MemberID, MemberPassword)))
        {
            System.out.println("Added new Provider");
            pd.save();
        }
        else
        {
            System.out.println("Provider already exits");
        }
    }

    public void removeMember() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter member name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter member nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter member password: ");
        String MemberPassword = myObj.nextLine();
        if(md.removeUser(new Member(MemberName, MemberID, MemberPassword)))
        {
            System.out.println("Removed member");
            md.save();
        }
        else {
            System.out.println("Member does not exist");
        }
    }

    public void removeProvider() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Provider name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter Provider nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if(MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter Provider password: ");
        String MemberPassword = myObj.nextLine();
        if(pd.removeUser(new Provider(MemberName, MemberID, MemberPassword)))
        {
            System.out.println("Removed Provider");
            pd.save();
        }
        else
        {
            System.out.println("Provider does not exist");
        }
    }
}

