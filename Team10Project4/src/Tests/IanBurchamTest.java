package Project4.Tests;

import Project4.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IanBurchamTest {
    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void OpDatabaseAddSuccess()
    {
        OperatorDatabase od = new OperatorDatabase();
        Operator op = new Operator("Tim man", 100, "password1234");
        od.addUser(op);
        od.save();
        OperatorVerifier opv = new OperatorVerifier();
        assertEquals(opv.LoginOperator(op), true);

    }
    @Test
    void OpDatabaseStartFail()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            OperatorDatabase od = new OperatorDatabase(new File("lala.txt"));
        });
        Assert.assertEquals("File does not exist", thrown.getMessage());
    }
    @Test
    void ManDatabaseRemoveSuccess()
    {
        ManagerDatabase od = new ManagerDatabase();
        Manager op = new Manager("Tim man", 100, "password1234");
        od.addUser(op);
        od.save();
        od.removeUser(op);
        od.save();
        ManagerVerifier opv = new ManagerVerifier();
        assertEquals(opv.LoginManager(op), false);

    }
    @Test
    void ManDatabaseStartFail()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ManagerDatabase od = new ManagerDatabase(new File("lala.txt"));
        });
        Assert.assertEquals("File does not exist", thrown.getMessage());
    }
    @Test
    void ProLoginGood()
    {
        ProviderDatabase od = new ProviderDatabase();
        Provider op = new Provider("Tim man", 100, "password1234");
        od.addUser(op);
        od.save();
        ProviderVerifier opv = new ProviderVerifier();
        assertEquals(opv.LoginProvider(op), true);
    }
    @Test
    void ProLoginFail()
    {
        ProviderVerifier opv = new ProviderVerifier();
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            opv.LoginProvider(new Operator("haha", 100, "no"));
        });
        Assert.assertEquals("Requires type Provider", thrown.getMessage());
    }

}
