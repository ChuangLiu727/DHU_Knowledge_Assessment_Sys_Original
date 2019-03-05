package InputDatabase;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException; 
import java.util.ArrayList;

public class DBHelper {
	 	private Connection conn = null;  
	    PreparedStatement statement = null;  
	    static String createQuestion = "create table question("
	    		+ "id int(11),"
	    		+ "chapter int(8),"
	    		+ "idinchapter int(8),"
	    		+ "question varchar(255),"
	    		+ "answer varchar(255),"
	    		+ "choicetype int(4)"
	    		+ ");";
	    static String createChoice = "create table `choice`("
	    		+ "id int(11) not null primary key,"
	    		+ "`option` varchar(255),"
	    		+ "detail varchar(255)"
	    		+ ");";
	  
	    // connect to MySQL  
	    public void connSQL() {  
	        String url = "jdbc:mysql://SAE_MYSQL_HOST_M:SAE_MYSQL_PORT/app_dhutiku1?characterEncoding=GBK";  
	        String username = "SAE_MYSQL_USER";  
	        String password = "SAE_MYSQL_PASS"; 
	        try {   
	            Class.forName("com.mysql.jdbc.Driver" );   
	            conn = DriverManager.getConnection( url,username, password );   
	            }  
	        //捕获加载驱动程序异常  
	         catch ( ClassNotFoundException cnfex ) {  
	             System.err.println(  
	             "装载 JDBC/ODBC 驱动程序失败。" );  
	             cnfex.printStackTrace();   
	         }   
	         //捕获连接数据库异常  
	         catch ( SQLException sqlex ) {  
	             System.err.println( "无法连接数据库" );  
	             sqlex.printStackTrace();   
	         }  
	    }  
	    
	    public boolean insertSQL(String sql) {  
	        try {  
	            statement = conn.prepareStatement(sql);  
	            statement.executeUpdate();  
	            return true;  
	        } catch (SQLException e) {  
	            System.out.println("插入数据库时出错：");  
	            e.printStackTrace();  
	        } catch (Exception e) {  
	            System.out.println("插入时出错：");  
	            e.printStackTrace();  
	        }  
	        return false;  
	    }  
	    
	    public void execute(){
	    	connSQL();
	    	insertSQL("drop table if exists `question`;");
	    	insertSQL("drop table if exists `choice`;");
	    	insertSQL(createQuestion);
	    	insertSQL(createChoice);
	    	ArrayList<Question> questions = Database.questions;
	    	for(Question q: questions){
	    		String questionSql = "insert into question values("
	    				+ q.getId() + ","
	    				+ q.getChapter() + ","
	    				+ q.getIdInChapter() + ","
	    				+ "'" + q.getQuestion() + "'" + ","
	    				+ "'" + q.getAnswer() + "'" + ");" ;
	    		insertSQL(questionSql);
	    		
	    		ArrayList<Choice> choices = q.getChoice();
	    		for(Choice c: choices){
	    			String choiceSql = "insert into `choice` values("
	    				+ c.getId() + ","
	    				+ "'" + c.getOption() + "'" + ","
	    				+ "'" + c.getDetail() + "'" + ");" ;
	    		insertSQL(choiceSql);
	    		}
	    	}
	    }
	    
}
