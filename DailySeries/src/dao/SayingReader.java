package dao;
import java.io.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;

class SayingReader {
	
public static void main(String args[])  { 
	
		Connection conn = null;
		Statement stmt = null;	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "Daily";
		String password = "1234";
		BufferedReader reader =null;
		
		int result = -1;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			StringTokenizer stok = null;
			reader = new BufferedReader(new FileReader("C:\\Users\\krit\\Desktop\\HTML�ǽ�\\Saying.txt"));
			stmt.executeUpdate("delete from SAYINGTBL");
			System.out.println("������ ���� ����");
			String kortext ; 
		    String engtext ;
		    String speaker ;
		    String str = null;
				while((str = reader.readLine()) != null) {
					
				stok = new StringTokenizer(str,"$");
					
					if(stok.hasMoreTokens()) {
					    kortext =   stok.nextToken();
					    engtext =   stok.nextToken();
					    speaker =   stok.nextToken();
						System.out.println(kortext);
						System.out.println(engtext);
						System.out.println(speaker);
						
						result = stmt.executeUpdate("insert into SAYINGTBL values('"+kortext+ "','" +engtext+ "','" +speaker+ "',sayingSEQ.nextval)");	
						
					}
					
					
				}
				
				if(result == 1) {
				       System.out.println("======= ��� �Է� ���� ========");
				       result = 1;
				      }else {
				       System.out.println("======= ��� �Է� ���� ========");
				       result = 0;
				      }
				
		}
		
		catch(FileNotFoundException fnfe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		catch(IOException ioe) {
			System.out.println("������ ���� �� �����ϴ�.");
		}
		catch(Exception e) {
		      e.printStackTrace();
		     }
		
		
		finally {
			try {
				reader.close();
				 if(stmt != null) {
				        stmt.close();
				       }
				       if(conn != null) {
				        conn.close();
				       }
			}
			catch(Exception e) {
				 e.printStackTrace();
			}
		}
	}
}
