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
			reader = new BufferedReader(new FileReader("C:\\Users\\krit\\Desktop\\HTML실습\\Saying.txt"));
			stmt.executeUpdate("delete from SAYINGTBL");
			System.out.println("데이터 삭제 성공");
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
				       System.out.println("======= 명언 입력 성공 ========");
				       result = 1;
				      }else {
				       System.out.println("======= 명언 입력 실패 ========");
				       result = 0;
				      }
				
		}
		
		catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
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
