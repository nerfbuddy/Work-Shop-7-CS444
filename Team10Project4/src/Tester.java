package Project4;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) {
        OperatorDatabase op = new OperatorDatabase();
        Operator oper = new Operator("james", 13, "manman");
        Operator jeff = new Operator("Jeff", 12, "he's/him");
        //op.search(jeff).getInfo();
        op.removeUser(jeff);
        op.removeUser(oper);
        op.save();

    }
}
