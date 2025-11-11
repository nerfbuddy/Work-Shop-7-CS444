package Project4;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Database {
    protected List<User> list;
    protected File file = new File("op.txt");
    protected Scanner sc;

    /*
    public Database() {
        try
        {
            sc = new Scanner(file);
            list = new Vector<User>();
            importData();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

    }
*/
    public void importData()
    {
        while (sc.hasNext()){
            list.add(new Operator(sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine()));
        }
    }

    //Returns false if member is already in database
    public boolean addUser(User u)
    {
        for(User b : list)
        {
            if (b.getID() == u.getID())
            {
                return false;
            }
        }
        list.add(u);
        return true;
    }

    //Returns false if member isn't in database
    public boolean removeUser(User u)
    {
        for(User b : list)
        {
            if (b.getID() == u.getID())
            {
                if(list.remove(b))
                {
                    System.out.println("removed");
                }
                return true;
            }
        }
        return false;
    }

    //saves current list to database
    public void save() {

        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(file, false);

        myWriter.write("");
        for (User b : list) {
            //b.getInfo();
            System.out.println(b.getName());
            myWriter.write(b.getName());
            myWriter.write("\n");
            myWriter.write(Integer.toString(b.ID));
            myWriter.write("\n");
            myWriter.write(b.pwd);
            myWriter.write("\n");

        }
            myWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //search for and return the specified user; returns null if user in not in database
    public User search(User u)
    {
        for(User b : list)
        {
            if (b.getID() == u.getID())
            {
                //System.out.println(b.getID());
                return b;
            }
        }
        return null;
    }
}
