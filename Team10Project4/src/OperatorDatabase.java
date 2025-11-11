package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class OperatorDatabase extends Database{
    public OperatorDatabase() {
        try
        {
            file = new File("op.txt");
            sc = new Scanner(file);
            list = new Vector<User>();
            importData();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public OperatorDatabase(File file) {
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
