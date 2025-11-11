package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class MemberDatabase extends Database{
    public MemberDatabase() {
        try
        {
            file = new File("mem.txt");
            sc = new Scanner(file);
            list = new Vector<User>();
            importData();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void importData()
    {
        while (sc.hasNext()){
            list.add(new Member(sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine()));
        }
        sc.close();
    }
    public void writememrport()
    {
        ReportWriter rp = new ReportWriter();
        for(User b : list)
        {
            rp.getMemberSummaryReport(b);
        }
    }

}
