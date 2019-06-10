import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import junit.framework.TestCase;

public class Jtest extends TestCase{

    public void testEquality() throws Exception {
    	Connection a=DatabaseConnection.getConnectiondelete("123");
    	assertNotNull(a);
   
    }
    

}


