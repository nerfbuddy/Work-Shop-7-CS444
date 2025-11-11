package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ProviderDatabase extends Database{
    public ProviderDatabase() {

        try
        {
            file = new File("pro.txt");
            sc = new Scanner(file);
            list = new Vector<>();
            importData();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("File does not exist");
        }
    }
    @Override
    public void importData()
    {
        while (sc.hasNext()){
            list.add(new Provider(sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine()));
        }
    }
    public void writeproviderrport()
    {
        ReportWriter rp = new ReportWriter();
        for(User b : list)
        {
            rp.getProviderSummaryReport(b);
        }
    }

}
