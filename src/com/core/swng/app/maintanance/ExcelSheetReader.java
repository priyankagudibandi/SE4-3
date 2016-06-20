package com.core.swng.app.maintanance;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExcelSheetReader {

	private static final String DRIVER_NAME = "sun.jdbc.odbc.JdbcOdbcDriver";
	   private static final String DATABASE_URL = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ=%s;DriverID=22;READONLY=false";

	   private static final String FILEPATH = "C:/Documents and Settings/web/Desktop/Employee.xlsx";

	   private static Connection con = null;
	   private static Statement stmt = null;

	   private Connection getConnection(File file) throws ClassNotFoundException, SQLException{
	       Class.forName(DRIVER_NAME);
	       Connection con = DriverManager.getConnection(String.format(DATABASE_URL, file.getAbsolutePath()));
	       return con;
	   }

	     public List<String> getData(File file, String []columns) throws SQLException {

	       List<String> list = null;
	          try {
	              ResultSet rs = getRecord(file, "select emailid from [Sheet1$]");
	              ResultSetMetaData rsmd = rs.getMetaData();
	              System.out.println(rsmd.getColumnCount());

	             while (rs.next()) {
	                 if (list==null)
	                        list = new  ArrayList<String>();
	                 for (int i=0; i<columns.length; i++) {
	                     list.add(rs.getString(columns[i]));
	                 }
	             }
	             rs.close();
	           } catch (Exception e) {
	            }
	          finally {
	             closeConnection();
	             return list;
	          }
	   }
	   private void closeConnection() throws SQLException {
	       if (stmt!=null) {
	           stmt.close();
	           stmt = null;
	       }

	       if (con!=null) {
	           con.close();
	           con = null;
	       }

	}
	ResultSet getRecord(File file, String query) throws ClassNotFoundException, SQLException {
	        con = getConnection(file);
	       stmt = con.createStatement();
	       ResultSet rs = stmt.executeQuery(query);
	    return rs;
	}
	public static void main(String[] args) {
	       /*ExcelSheetReader reader = new ExcelSheetReader();
	       String[] columns = {"emailid"};
	       File file = new File(FILEPATH);
	       List<String> list = null;
	    try {
	        list = reader.getData(file,columns);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	       for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
	        String string = (String) iterator.next();
	        System.out.println(string); 
	       }
	       */
	       ExcelSheetReader reader = new ExcelSheetReader();
	        File file = new File(FILEPATH);
	        if (file.exists()) {
	            try {
	                ResultSet rs = reader.getRecord(file, "select emailid from [Sheet1$]");
	                ResultSetMetaData rsmd = rs.getMetaData();
	                int count = rsmd.getColumnCount();
	                //System.out.println(count);
	                while (rs.next()) {
	                    for (int i=1; i<=count; i++) {
	                        System.out.println(rsmd.getColumnName(i)+": "+rs.getString(rsmd.getColumnName(i)));
	                    }
	                }
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	   }
}
