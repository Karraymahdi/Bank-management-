

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import hu.bme.model.Customer;

public class DatabaseConnection {
	private String s;

	public static List<Customer> getConnectionDATAaccount(String a, String v) throws Exception {
		Statement statement;
		PreparedStatement stmt = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customers";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url + "?useSSL=false", "root", "");
			System.out.println("Connected");
			stmt = (PreparedStatement) conn.prepareStatement(
					"SELECT `Name`, `Address`, `Account type`, `Sex`, `ID type`, `id Number`, `DOB`, `Password`, `Account number`,`BALANCE`,`Image` FROM customers WHERE (`id Number`='"
							+ v + "' AND `Name`='" + a + "')");
			ResultSet rs = stmt.executeQuery();
			List<Customer> customers = new ArrayList<>();
			while (rs.next()) {
				// Retrieve by column name
				Customer c = new Customer();
				c.setName(rs.getString("Name"));
				c.setAddress(rs.getString("Address"));
				c.setAccountType(rs.getString("Account type"));
				c.setSex(rs.getString("Sex"));
				c.setIdType(rs.getString("ID type"));
				c.setDob(rs.getString("DOB"));
				c.setPassword(rs.getString("Password"));
				c.setAccountNumber(rs.getString("Account number"));
				c.setBalance(rs.getInt("BALANCE"));
				c.setImage(rs.getString("Image"));
				customers.add(c);
			}
			return customers;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public static List<Customer> getConnectionDATA(String a, String v, String g) throws Exception {
		Statement statement;
		PreparedStatement stmt = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customers";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url + "?useSSL=false", "root", "");
			System.out.println("Connected");
			stmt = (PreparedStatement) conn.prepareStatement(
					"SELECT `Name`, `Address`, `Account type`, `Sex`, `ID type`, `id Number`, `DOB`, `Password`, `Account number`,`BALANCE`,`Image` FROM customers WHERE (`id Number`='"
							+ v + "' AND `Name`='" + a + "' AND `Password`='" + g + "')");
			ResultSet rs = stmt.executeQuery();
			List<Customer> customers = new ArrayList<>();
			while (rs.next()) {
				// Retrieve by column name
				Customer c = new Customer();
				c.setName(rs.getString("Name"));
				c.setAddress(rs.getString("Address"));
				c.setAccountType(rs.getString("Account type"));
				c.setSex(rs.getString("Sex"));
				c.setIdType(rs.getString("ID type"));
				c.setDob(rs.getString("DOB"));
				c.setPassword(rs.getString("Password"));
				c.setAccountNumber(rs.getString("Account number"));
				c.setBalance(rs.getInt("BALANCE"));
				c.setImage(rs.getString("Image"));
				customers.add(c);
			}
			return customers;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public static Connection getConnectioninsert(String a, String b, String c, String d, String m, String v, String f,
			String g, String h, String i) throws Exception {
		Statement statement;
		PreparedStatement stmt = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customers";

			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url + "?useSSL=false", "root", "");
			System.out.println("Connected");

			stmt = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO `customers` (`Name`, `Address`, `Account type`, `Sex`, `ID type`, `id Number`, `DOB`, `Password`, `Account number`,`Image` ) VALUES (?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, a);
			stmt.setString(2, b);
			stmt.setString(3, c);
			stmt.setString(4, d);
			stmt.setString(5, m);
			stmt.setString(6, v);
			stmt.setString(7, f);
			stmt.setString(8, g);
			stmt.setString(9, h);
			stmt.setString(10, i);
			stmt.executeUpdate();
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public static Connection getConnectionupdate(String a, String b, String c, String d) throws Exception {
		Statement statement;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customers";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url + "?useSSL=false", "root", "");
			PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement(
					"UPDATE `customers` SET `Name` = ?, `Address` =?, `Account type` =? WHERE `customers`.`id Number` = '"
							+ c + "' ");
			updateEXP.setString(1, a);
			updateEXP.setString(2, b);
			updateEXP.setString(3, d);
			int updateEXP_done = updateEXP.executeUpdate();
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Connection getConnectionupdatebalance(String a, String b) throws Exception {
		Statement statement;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customers";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url + "?useSSL=false", "root", "");
			PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement(
					"UPDATE `customers` SET  `BALANCE` =? WHERE `customers`.`id Number` = '" + b + "' ");
			updateEXP.setString(1, a);

			int updateEXP_done = updateEXP.executeUpdate();
			System.out.println("Connected");
			return conn;
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return null;
	}

	public static Connection getConnectiondelete(String b) throws Exception {
		Statement statement;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customers";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url + "?useSSL=false", "root", "");
			PreparedStatement updateEXP = (PreparedStatement) conn
					.prepareStatement("DELETE FROM `customers`  WHERE `customers`.`id Number` = '" + b + "' ");
			int updateEXP_done = updateEXP.executeUpdate();
			System.out.println("Connected");
			return conn;
		} catch (Exception e1) {
			System.out.println(e1);
			
		}
		return null;
	}
}
