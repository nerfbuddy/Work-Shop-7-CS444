package Project4;

public abstract class User {
    protected String name;
    protected int ID;
    protected String pwd;

    public void getInfo()
    {
        System.out.println(name);
        System.out.println(ID);
        System.out.println(pwd);
    }

    public String getName()
    {
        return name;
    }

    public int getID()
    {
        return ID;
    }

    public String getPwd()
    {
        return pwd;
    }
    public void setName(String n)
    {
        name = n;
    }

    public void setID(int n)
    {
        ID = n;
    }
    public void setpwd(String n)
    {
        pwd = n;
    }




}
