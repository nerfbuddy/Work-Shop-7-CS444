package Project4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class representing the Provider Terminal functionalities.
 * This class manages the provider directory, including display, email sending, and service lookup.
 * It also encapsulates services provided by the providers.
 * 
 * @author Nahom Workalemahu
 */


public class ProviderTerminal {
    public void startTerm()
    {
        MemberVerifier memv = new MemberVerifier();
        Scanner myObj = new Scanner(System.in);
        boolean var = true;
        while (var) {
            System.out.println("Enter M to validate a member or S to make a service report. Type exit to return to main");
            switch (myObj.nextLine()) {
                case "M": case "m":
                    System.out.println("Enter member name: ");
                    String MemberName = myObj.nextLine();

                    System.out.println("Enter their nine-digit member number:");
                    int MemberID = Integer.parseInt(myObj.nextLine());
                    if(MemberID > 999999999) {
                        System.out.println("Invalid code; code must be nine digits in total.");
                    }

                    System.out.println("Enter their password: ");
                    String MemberPassword = myObj.nextLine();
                    if(memv.VerifyMember(new Member(MemberName, MemberID, MemberPassword)))
                    {
                        System.out.println("Member is valid.");
                    }
                    else
                    {
                        System.out.println("Member is invalid.");
                    }
                    break;
                case "S": case "s":
                    System.out.println("Enter name of service");
                    String sName = myObj.nextLine();
                    System.out.println("Enter code of service");
                    int sCode = Integer.parseInt(myObj.nextLine());
                    System.out.println("Enter fee of service");
                    int sFee = Integer.parseInt(myObj.nextLine());
                    services.add(new Service(sName, sCode, sFee));
                    System.out.println("added!");
                    listAllService();
                    break;
                case "exit":
                    var = false;
                    aTerminal.main(new String[]{"a", "b"});
                default:
                    System.out.println("Unknown command, please enter S or M");
                    break;
            }
        }
    }

    private static final List<Service> services = new ArrayList<>();

    static {
        // Initialize services provided
        services.add(new Service("Wellness services", 8470, 60));
        services.add(new Service("Massage Services", 6745, 100));
        services.add(new Service("Therapy Services", 3642, 90));
        // Add more services here
    }

    /**
     * Sends an email attachment containing the provider directory information.
     */
    public static void sendEmailAttachment() {
        final String filename = "./ProviderDirectory.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Provider Directory:\n\n");
            writer.write(String.format("%-40s%-40s%-40s%n", "Service Name:", "Service Code:", "Fee:"));
            for (Service service : services) {
                writer.write(String.format("%-40s%-40s$%-40s%n", service.getName(), service.getCode(), service.getFee()));
            }
            System.out.println("\nEmail sent\n");
        } catch (IOException e) {
            System.out.println("Failed to send email.");
            e.printStackTrace();
        }
    }

    /**
     * Displays the provider directory on the terminal.
     */
    public static void displayProviderDirectory() {
        System.out.println("Provider Directory: \n");
        System.out.format("%-40s%-40s%-40s%n", "Service Name:", "Service Code:", "Fee:");
        for (Service service : services) {
            System.out.format("%-40s%-40s$%-20s%n", service.getName(), service.getCode(), service.getFee());
        }
        System.out.println();
    }

    /**
     * Retrieves the name of the service corresponding to the given service code.
     * 
     * @param serviceCode The service code to search for.
     * @return The name of the service if found, otherwise null.
     */
    public static String getServiceName(int serviceCode) {
        for (Service service : services) {
            if (service.getCode() == serviceCode) {
                return service.getName();
            }
        }
        return null;
    }
    void listAllService()
    {
        for (Service service : services)
        {
            System.out.format(service.getName() + " Fee: " + service.getFee() + " Code: " + service.getCode() + "\n");
        }
    }


    /**
     * Retrieves the fee of the service corresponding to the given service code.
     * 
     * @param serviceCode The service code to search for.
     * @return The fee of the service if found, otherwise -1.
     */
    public static int getFee(int serviceCode) {
        for (Service service : services) {
            if (service.getCode() == serviceCode) {
                return service.getFee();
            }
        }
        return -1;
    }

    /**
     * Represents a service provided by a provider.
     */
    private static class Service {
        private final String name;
        private final int code;
        private final int fee;

        public Service(String name, int code, int fee) {
            this.name = name;
            this.code = code;
            this.fee = fee;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }

        public int getFee() {
            return fee;
        }
    }
    public boolean LoginPro()
    {
        ProviderVerifier prov = new ProviderVerifier();
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

        Provider userMember = new Provider(MemberName, MemberID, MemberPassword);



        if(!(prov.LoginProvider(userMember))) {
            System.out.print("Invaild login.");
            return false;
        }
        else
        {
            System.out.print("Validated.\n");
            return true;
        }


    }
}
