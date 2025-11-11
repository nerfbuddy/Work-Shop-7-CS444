package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ManagerDatabase extends Database{
    public ManagerDatabase() {
        try
        {
            file = new File("man.txt");
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
            list.add(new Manager(sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine()));
        }
        sc.close();
    }

    public ManagerDatabase(File file) {
        try
        {
            sc = new Scanner(file);
            list = new Vector<User>();
            importData();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("File does not exist");
        }
    }
}
