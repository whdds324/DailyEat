package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.MemberVo;
import vo.MenuVo;
import vo.SayingVo;
import vo.orderlistVo;

public class MemberDao {
	String username;
    private MemberDao() {

    } 
    
    private static MemberDao instance = new MemberDao();
    
    public static MemberDao getInstance() {
     return instance;
    }

    public Connection getConnection() throws Exception{
     Connection conn = null;
     Context initContext = new InitialContext();
     Context envContext = (Context) initContext.lookup("java:/comp/env");
     DataSource ds  = (DataSource) envContext.lookup("jdbc/myoracle");
     conn = ds.getConnection();
     return conn;
    }
    
    // �Էµ� ������ ȸ�� ������ �μ�Ʈ �ϴ� �κ�
    public int insertMember(MemberVo mVo) {
     
     System.out.println("================ �μ�Ʈ dao ���� ================");
     
  Connection conn = null;
  Statement stmt = null;
   
  int result  = -1;
  
     try {
      
      conn = getConnection();

      System.out.println("===== db ���� ���� =====");
      System.out.println(mVo.getUserid());
      System.out.println(mVo.getName());
      System.out.println(mVo.getPassword());
      System.out.println(mVo.getBirthyear());
      System.out.println(mVo.getAddr());
      
      stmt = conn.createStatement();
      result = stmt.executeUpdate("insert into membertbl values('" 
                                      + mVo.getUserid() + "','" 
                                + mVo.getName() + "','" 
                                + mVo.getPassword() +"','"
                                + mVo.getAddr() +"','"
                                + mVo.getBirthyear()+ "',sysdate)");
      
      
      if(result == 1) {
       System.out.println("======= ȸ�� ���� ���� ========");
       result = 1;
      }else {
       System.out.println("======= ȸ�� ���� ���� ========");
       result = 0;
      }
      
     }
     catch(Exception e) {
      e.printStackTrace();
     }
     finally {
      try {
       if(stmt != null) {
        stmt.close();
       }
       if(conn != null) {
        conn.close();
       }
      }catch(Exception e) {
       e.printStackTrace();
      }
     }
     return result;
    }
    
    // �Էµ� ������ �α��� �ϴ� �κ�
    public int userCheck(String userid, String password) {
     MemberVo Vo = new MemberVo();
     System.out.println("================ userCheck dao ���� ================");
     
  Connection conn = null;
  Statement stmt = null;
   
  int result  = -1;
  
     try {

      conn = getConnection();
      
      System.out.println("===== db ���� ���� =====");
      System.out.println(userid);
      System.out.println(password);

      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select userid, password,username from memberTBL where userid = '" + userid + "' and password = '" + password + "'");
      
   
    	  
     
      
      if(rs.next()) {
    	  
    	  String id = rs.getString("userid");
    	  String password2 = rs.getString("password");
    	  String username = rs.getString("username");  
    	  Vo.setName(username);
    	  System.out.println(id+password2+username);
    	  
    	  if(id.equals(userid) && password2.equals(password)) {
              result = 1;
          }
          else if(id.equals(userid) == false || password.equals(password2) == false)  {
           result = 0;
           System.out.println("======= ���̵� ��й�ȣ�� Ȯ���ϼ���. ========");
          }
    	  
      }
      
      else {
       System.out.println("======= ȸ�� �α��� ���� ========");
          result = -1;
      }
      System.out.println(result+"============================================");
      
     }
     
     catch(Exception e) {
      e.printStackTrace();
     }finally {
      try {
       if(stmt != null) {
        stmt.close();
       }
       if(conn != null) {
        conn.close();
       }
      }catch(Exception e) {
       e.printStackTrace();
      }
     }
     return result;
    }
    
    public MemberVo getInfo(String userid) {
		MemberVo mVo = null;
		String sql = "select userid, username, password, addr, BIRTHyear, signdate from membertbl where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mVo = new MemberVo();
				mVo.setUserid(rs.getString("userid"));
				mVo.setName(rs.getString("username"));	
				mVo.setPassword(rs.getString("password"));
				mVo.setAddr(rs.getString("addr"));
				mVo.setBirthyear(rs.getString("birthyear"));
				mVo.setSigndate(rs.getString("signdate"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if( conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}
    
    public SayingVo getSaying() {
    	System.out.println("================ ��� ȹ�� dao ���� ================");
    	Random r = new Random();
    	SayingVo sv = null;
    	  Connection conn = null;
    	  Statement stmt = null;
    	  ResultSet rss = null;
    	  ResultSet rs = null;
    	     	  
    	     try {
    	      
    	      conn = getConnection();

    	      System.out.println("===== db ���� ���� =====");
    	     
    	      stmt = conn.createStatement();
    	      rs = stmt.executeQuery("select kortext,engtext,speaker from (select * from sayingtbl order by DBMS_RANDOM.RANDOM) where rownum =1");
    	       
    	      if(rs.next()) {
    	      sv = new SayingVo();
    	      sv.setKortxt(rs.getString("kortext"));
    	      System.out.println(rs.getString("kortext"));
    	      
    	      sv.setEngtxt(rs.getString("engtext"));
    	      sv.setSpeaker(rs.getString("speaker"));
    	      }
    	      
    	     
    	     }catch(Exception e) {
    	      e.printStackTrace();
    	     }finally {
    	      try {
    	       if(stmt != null) {
    	        stmt.close();
    	       }
    	       if(conn != null) {
    	        conn.close();
    	       }
    	      }catch(Exception e) {
    	       e.printStackTrace();
    	      }
    	     }
    	     
    	     return sv;
    }
    
    public int ChangeInfo(MemberVo mVo) {
    	System.out.println("================ ���� dao ���� ================");
        
    	  Connection conn = null;
    	  Statement stmt = null;
    	   
    	  int result  = -1;
    	  
    	     try {
    	      
    	      conn = getConnection();

    	      System.out.println("===== db ���� ���� =====");
    	      System.out.println(mVo.getUserid());
    	      System.out.println(mVo.getPassword());
    	      System.out.println(mVo.getBirthyear());
    	      System.out.println(mVo.getAddr());
    	      
    	      stmt = conn.createStatement();
    	      result = stmt.executeUpdate("update membertbl set password = '"+mVo.getPassword()+"', addr = '"+mVo.getAddr()+"',birthyear = '"+mVo.getBirthyear()+"' where userid = '"+mVo.getUserid()+"'"  );
    	      
    	      
    	      if(result == 1) {
    	       System.out.println("======= ȸ�� ���� ���� ���� ========");
    	       result = 1;
    	      }else {
    	       System.out.println("======= ȸ�� ���� ���� ���� ========");
    	       result = 0;
    	      }
    	      
    	     }catch(Exception e) {
    	      e.printStackTrace();
    	     }finally {
    	      try {
    	       if(stmt != null) {
    	        stmt.close();
    	       }
    	       if(conn != null) {
    	        conn.close();
    	       }
    	      }catch(Exception e) {
    	       e.printStackTrace();
    	      }
    	     }
    	     return result;
    
    }
    
    public List<MenuVo> getMenu(String type) {
    	System.out.println("================ �޴� ȹ�� dao ���� ================");
    	
    	List<MenuVo> list = null;
    	  Connection conn = null;
    	  Statement stmt = null;
     	  ResultSet rs = null;
    	     	  
    	     try {
    	      
    	      conn = getConnection();

    	      System.out.println("===== db ���� ���� =====");
    	     
    	      stmt = conn.createStatement();
    	     
    	      rs = stmt.executeQuery("select code,type,storename,call,storeaddr,time from menutbl where type = '"+type+"'");
    	    
    	      list = new ArrayList<MenuVo>(); 
    	      while(rs.next()) {
    	    	  MenuVo mv = new MenuVo();
    	    	  System.out.println(rs.getString("type"));
    	    	  mv.setCall(rs.getString("call"));
    	    	  mv.setCode(rs.getString("code"));
    	    	  mv.setStoreaddr(rs.getString("storeaddr"));
    	    	  mv.setStorename(rs.getString("storename"));
    	    	  mv.setTime(rs.getString("time"));
    	    	  mv.setType(rs.getString("type"));
    	    	  list.add(mv);
    	      }
    	      
    	     
    	     }catch(Exception e) {
    	      e.printStackTrace();
    	     }finally {
    	      try {
    	       if(stmt != null) {
    	        stmt.close();
    	       }
    	       if(conn != null) {
    	        conn.close();
    	       }
    	      }catch(Exception e) {
    	       e.printStackTrace();
    	      }
    	     }
    	     
    	     return list;
    }
    
    public List<MenuVo> getRecommend(String addr) {
    	System.out.println("================ ��õ �޴� dao ���� ================");
    	
    	List<MenuVo> list = null;
    	  Connection conn = null;
    	  Statement stmt = null;
     	  ResultSet rs = null;
    	     	  
    	     try {
    	      
    	      conn = getConnection();

    	      System.out.println("===== db ���� ���� =====");
    	     
    	      stmt = conn.createStatement();
    	     
    	      rs = stmt.executeQuery("select code,type,storename,call,storeaddr,time from menutbl where storeaddr like'%"+addr+"%'");
    	    
    	      list = new ArrayList<MenuVo>(); 
    	      while(rs.next()) {
    	    	  MenuVo mv = new MenuVo();
    	    	  System.out.println(rs.getString("type"));
    	    	  mv.setCall(rs.getString("call"));
    	    	  mv.setCode(rs.getString("code"));
    	    	  mv.setStoreaddr(rs.getString("storeaddr"));
    	    	  mv.setStorename(rs.getString("storename"));
    	    	  mv.setTime(rs.getString("time"));
    	    	  mv.setType(rs.getString("type"));
    	    	  list.add(mv);
    	      }
    	      
    	     
    	     }catch(Exception e) {
    	      e.printStackTrace();
    	     }finally {
    	      try {
    	       if(stmt != null) {
    	        stmt.close();
    	       }
    	       if(conn != null) {
    	        conn.close();
    	       }
    	      }catch(Exception e) {
    	       e.printStackTrace();
    	      }
    	     }
    	     
    	     return list;
    }
    
    
    public List<MenuVo> getMenudetail(String code) {
    	System.out.println("================ �޴������� ȹ�� dao ���� ================");
    	
    	List<MenuVo> list = null;
    	  Connection conn = null;
    	  Statement stmt = null;
    	 
    	  ResultSet rs = null;
    	     	  
    	     try {
    	      
    	      conn = getConnection();

    	      System.out.println("===== db ���� ���� =====");
    	     
    	      stmt = conn.createStatement();
    	     
    	      rs = stmt.executeQuery("select code,storename,menu,price,key from MENUDETAIL where code = '"+code+"'");
    	    
    	      list = new ArrayList<MenuVo>(); 
    	      while(rs.next()) {
    	    	  MenuVo mv = new MenuVo();
    	    	  System.out.println(rs.getString("code"));
    	    	  mv.setKey(rs.getString("key"));
    	    	  mv.setCode(rs.getString("code"));
    	    	  mv.setStorename(rs.getString("storename"));
    	    	  mv.setMenu(rs.getString("menu"));
    	    	  mv.setPrice(rs.getString("price"));
    	    	  list.add(mv);
    	      }
    	      
    	     
    	     }catch(Exception e) {
    	      e.printStackTrace();
    	     }finally {
    	      try {
    	       if(stmt != null) {
    	        stmt.close();
    	       }
    	       if(conn != null) {
    	        conn.close();
    	       }
    	      }catch(Exception e) {
    	       e.printStackTrace();
    	      }
    	     }
    	     
    	     return list;
    }
    
    public String GettotalPrice(String userid) {
    	System.out.println("================ �հ�ݾ� ȹ�� dao ���� ================");
    	
    		String totalprice = null; 
    	  Connection conn = null;
    	  Statement stmt = null;
    	 
    	  ResultSet rs = null;
    	     	  
    	     try {
    	      
    	      conn = getConnection();

    	      System.out.println("===== db ���� ���� =====");
    	     
    	      stmt = conn.createStatement();
    	     
    	      rs = stmt.executeQuery("select sum(price) from orderlist where userid ='"+userid+"'");
    	      		rs.next();
    	      		orderlistVo ov = new orderlistVo();
    	      totalprice = rs.getString("sum(price)");
    	      ov.setTotalprice(totalprice);
    	      
    	      
    	      
    	      
    	     
    	     }catch(Exception e) {
    	      e.printStackTrace();
    	     }finally {
    	      try {
    	       if(stmt != null) {
    	        stmt.close();
    	       }
    	       if(conn != null) {
    	        conn.close();
    	       }
    	      }catch(Exception e) {
    	       e.printStackTrace();
    	      }
    	     }
    	     
    	     return totalprice;
    }
    
    
    public List<orderlistVo> insertshoppingbag (String key, String userid) {
        
        System.out.println("================ ���ι� dao ���� ================");
     
     List<orderlistVo> list = new ArrayList<orderlistVo>();
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     ResultSet order = null;
     int result  = -1;
     
        try {
         
         conn = getConnection();

         System.out.println("===== db ���� ���� =====");
         stmt = conn.createStatement();
         rs = stmt.executeQuery("select menu,price,storename,key from menudetail where key ='"+key+"'");
         rs.next();
         System.out.println("=================select ����===============");
        
         String menu = rs.getString("menu");
    	 String price = rs.getString("price");
    	 String storename = rs.getString("storename");
    	 result = stmt.executeUpdate("insert into orderlist values"
          		+ "('"+menu+"','"+price+"','"+userid+"',orderseq.nextval,"
         		 +key+",'"+storename+"')");
    	 System.out.println("===============��ٱ��� insert ����===============");
         
    	 
    	 order = stmt.executeQuery("select menu,price,storename,orderid from orderlist where userid='"+userid+"'");
         
    	 while(order.next()) {
        	 orderlistVo ov = new orderlistVo();
	    	 	
        	  ov.setMenu(order.getString("menu"));
        	  ov.setPrice(order.getString("price"));
        	  ov.setStorename(order.getString("storename"));
        	  ov.setOrderid(order.getString("orderid"));
        	 
        	  
	    	  list.add(ov);
	      }
         
         if(result == 1) {
          System.out.println("======= ��ٱ��� ��� ���� ========");
          result = 1;
          
         }else {
          System.out.println("======= ��ٱ��� ��� ���� ========");
          result = 0;
         }
         
        }
        catch(Exception e) {
         e.printStackTrace();
        }
        finally {
         try {
          if(stmt != null) {
           stmt.close();
          }
          if(conn != null) {
           conn.close();
          }
         }catch(Exception e) {
          e.printStackTrace();
         }
        }
        return list;
       }
    
    public List<orderlistVo> getorderlist (String userid) {
        
        System.out.println("================ orderlist dao ���� ================");
     
     List<orderlistVo> list = new ArrayList<orderlistVo>();
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     ResultSet order = null;
    
     
        try {
         
         conn = getConnection();

         System.out.println("===== db ���� ���� =====");
         stmt = conn.createStatement();
        
    	 order = stmt.executeQuery("select menu,price,storename,orderid from orderlist where userid='"+userid+"'");
         System.out.println(order);
         
    	 while(order.next()) {
        	
    		  orderlistVo ov = new orderlistVo();
    		  
    		  System.out.println(ov);
    		  
        	  ov.setMenu(order.getString("menu"));
        	  ov.setPrice(order.getString("price"));
        	  ov.setStorename(order.getString("storename"));
        	  ov.setOrderid(order.getString("orderid"));
        	 
	    	  list.add(ov);
	      }
    	 
         if(order != null) {
          System.out.println("======= ��ٱ��� �Ѹ��� ���� ========");
         }
          
        
         
        }
        catch(Exception e) {
         e.printStackTrace();
        }
        finally {
         try {
          if(stmt != null) {
           stmt.close();
          }
          if(conn != null) {
           conn.close();
          }
         }catch(Exception e) {
          e.printStackTrace();
         }
        }
        return list;
       }
    
    public int confirmID(String userid) {
    	System.out.println("================ �ߺ�üũ dao ���� ================");
    	
    	int result = -1;
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        	conn = getConnection();
        	System.out.println("db���� ����");
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery("select userid from membertbl where userid ='"+userid+"'");
        		if(rs.next()) {
        			result =1;
        		}
        		else {
        			result = -1;
        		}
        	
        }
        catch(Exception e) {
  	      e.printStackTrace();
  	     }finally {
  	      try {
  	       if(stmt != null) {
  	        stmt.close();
  	       }
  	       if(conn != null) {
  	        conn.close();
  	       }
  	      }catch(Exception e) {
  	       e.printStackTrace();
  	      }
  	     }
  	     
  	     return result;
  }
    
    public int deletemember(String userid, String password) {
	    System.out.println("================ ȸ��Ż�� dao ���� ================");
		
		int result = -1;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {

	        conn = getConnection();
	        
	        System.out.println("===== db ���� ���� =====");
	        System.out.println(userid);
	        System.out.println(password);
	        stmt = conn.createStatement();
	        result = stmt.executeUpdate("delete from memberTBL where userid = '" + userid + "' and password = '" + password + "'");
	        System.out.println(result);
	        if(result == 1) {
	            System.out.println("======= ȸ�� Ż�� ���� ========");
	            result = 1;
	           }else {
	            System.out.println("======= ȸ�� Ż�� ���� ========");
	            result = 0;
	           }
	      	  
	        
	       }
	       
	       catch(Exception e) {
	        e.printStackTrace();
	       }finally {
	        try {
	         if(stmt != null) {
	          stmt.close();
	         }
	         if(conn != null) {
	          conn.close();
	         }
	        }catch(Exception e) {
	         e.printStackTrace();
	        }
	       }
	       return result;
	      
 
	    
    }
    
    public int DeleteOrderList(String orderid) {
	    System.out.println("================ ��ٱ��� ���� dao ���� ================");
		
		int result = -1;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {

	        conn = getConnection();
	        
	        System.out.println("===== db ���� ���� =====");
	        System.out.println(orderid);
	       
	        stmt = conn.createStatement();
	        result = stmt.executeUpdate("delete from orderlist where orderid = '" + orderid + "'");
	        System.out.println(result);
	        if(result == 1) {
	            System.out.println("======= ���� ���� ========");
	            result = 1;
	           }else {
	            System.out.println("======= ���� ���� ========");
	            result = 0;
	           }

	        
	       }
	       
	       catch(Exception e) {
	        e.printStackTrace();
	       }finally {
	        try {
	         if(stmt != null) {
	          stmt.close();
	         }
	         if(conn != null) {
	          conn.close();
	         }
	        }catch(Exception e) {
	         e.printStackTrace();
	        }
	       }
	       return result;
	      
	    
	    
	    
    }
    
    public int DeleteShoppingBag(String userid) {
	    System.out.println("================ ��ٱ��� ���� dao ���� ================");
		
		int result = -1;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {

	        conn = getConnection();
	        
	        System.out.println("===== db ���� ���� =====");
	        System.out.println(userid);
	       
	        stmt = conn.createStatement();
	        result = stmt.executeUpdate("delete from orderlist where userid = '" + userid + "'");
	        System.out.println(result);
	        if(result == 1) {
	            System.out.println("======= ���� ���� ========");
	            result = 1;
	           }else {
	            System.out.println("======= ���� ���� ========");
	            result = 0;
	           }

	        
	       }
	       
	       catch(Exception e) {
	        e.printStackTrace();
	       }finally {
	        try {
	         if(stmt != null) {
	          stmt.close();
	         }
	         if(conn != null) {
	          conn.close();
	         }
	        }catch(Exception e) {
	         e.printStackTrace();
	        }
	       }
	       return result;

    }
    
    
}