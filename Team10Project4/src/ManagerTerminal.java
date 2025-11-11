package Project4;

import java.util.Scanner;

/**
 * The ManagerTerminal class allows managers to print different reports, run the main accounting procedure, or log out.
 * It provides a terminal interface for manager operations.
 *
 * @author Nahom Workalemahu
 */
public class ManagerTerminal {
    MemberVerifier memv = new MemberVerifier();
    ProviderVerifier prov = new ProviderVerifier();
    public static Scanner mScan = new Scanner(System.in);

    /**
     * Allows the user to select which type of report to print and prompts the report to be printed.
     */
    MemberDatabase md =  new MemberDatabase();
    ProviderDatabase pd =  new ProviderDatabase();
    public void startTerm() {
        ReportWriter rp = new ReportWriter();
        System.out.println("\nWhat type of report would you like to print?\n\n1: Member\t2: Provider\t3: Main acc pro\t4: Return to main\n");
        System.out.println("Choose a selection by entering a number 1-3:");

        int reportType = 0;
        if (mScan.hasNextInt()) {
            reportType = mScan.nextInt();
        }
        mScan.nextLine();

        if (reportType == 1) {
            System.out.println("\nEnter member number of member you would like to view.");
            String memNum = mScan.nextLine();
            int num = 0;
            try {
                num = Integer.parseInt(memNum);
            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid input");
                startTerm();
            }
            if (memv.VerifyMember(new Member(null, num, null)))
            {
                rp.getMemberSummaryReport(md.search(new Member(null, num, null)));
                startTerm();
            }
            else
            {
                System.out.println("\nMember not found.");
                startTerm();
            }
        }
        else if (reportType == 2) {
            System.out.println("\nEnter provider number of provider you would like to view.");
            String memNum = mScan.nextLine();
            int num = 0;
            try {
                num = Integer.parseInt(memNum);
            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid input");
                startTerm();
            }
            if (prov.VerifyProvider(new Provider(null, num, null)))
            {
                rp.getProviderSummaryReport(pd.search(new Provider(null, num, null)));
                startTerm();
            }
            else
            {
                System.out.println("\nProvider not found.");
                startTerm();
            }
        }
        else if (reportType == 3) {
            md.writememrport();
            pd.writeproviderrport();
            startTerm();
        }
        else if (reportType == 4){
            aTerminal.main(new String[]{"a", "b"});
        }
        else {
            System.out.println("\nReport type not found. Please try again.");
            startTerm();
        }
        //startTerm();
    }

    /**
     * Logs the user out and returns them to the main login menu.
     */

    /**
     * Main function for manager terminal, allows the user to select what action they would like to perform.
     */
    public boolean LoginMan() {
        ManagerVerifier manv = new ManagerVerifier();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String MemberName = myObj.nextLine();

        System.out.println("Enter your nine-digit member number:");
        int MemberID = Integer.parseInt(myObj.nextLine());
        if (MemberID > 999999999) {
            System.out.println("Invalid code; code must be nine digits in total.");
        }

        System.out.println("Enter your password: ");
        String MemberPassword = myObj.nextLine();

        Manager userMember = new Manager(MemberName, MemberID, MemberPassword);




        if (!(manv.LoginManager(userMember))) {
            System.out.print("Invaild login.");
            return false;
        } else {
            System.out.print("Validated.");
            return true;
        }
    }
}

