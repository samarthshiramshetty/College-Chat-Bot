#Databasecon.java

package databaseconnection;
import java.sql.*;

public class databasecon 
{
	static Connection co;
	public static Connection getconnection()
	{
 		
 			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbox","root","root");
		}
		catch(Exception e)
		{
			System.out.println("Database Error"+e);
		}
		return co;
	}
	
}

#CountWords.java
package CT;
import org.apache.commons.lang.StringUtils;
public class  CountWords
{
	public static int main(String input, String compare) 
	{

		input=input.toLowerCase();
		compare=compare.toLowerCase();
		int number = StringUtils.countMatches(input, compare);
		return number;

	}
}
#GetData.java

package CT;
import databaseconnection.*;
import java.sql.*;

public class  GetData
{
static Connection con1=null;
static Statement st1=null;


public static String main(String id) {
	String res="";
try{

con1 = databasecon.getconnection();
st1 = con1.createStatement();
 String sql=null;;
sql="select * from questions where sno='"+id+"'";
ResultSet rs=null;
rs=st1.executeQuery(sql);

if(rs.next())
{
	res=rs.getString("qns").trim();
}
}
	catch(Exception e){
		System.out.println(e);
	}
	finally{
		try{
		con1.close();
		st1.close();
//		rs.close();
		}
		catch(Exception e){
		System.out.println(e);
		}
	}
	return res;
}

	
	public static void main(String[] args) 
	{
		System.out.println(main("1"));
	}

}
#4. Data Base Tables

create database if not exists `chatbox`;
USE `chatbox`;

DROP TABLE IF EXISTS `ans`;

CREATE TABLE `ans` (
  `sno` varchar(20) DEFAULT NULL,
  `ans` varchar(1000) DEFAULT NULL,
  `type` varchar(100) DEFAULT 'text'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `msgs`;

CREATE TABLE `msgs` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `msg` longblob,
  `user_` varchar(100) DEFAULT NULL,
  `time_` varchar(100) DEFAULT NULL,
  `type_` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `profilepic`;

CREATE TABLE `profilepic` (
  `email` varchar(200) NOT NULL,
  `pic` longblob,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `Sno` int(11) NOT NULL AUTO_INCREMENT,
  `qns` varchar(500) NOT NULL,
  PRIMARY KEY (`Sno`,`qns`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `suggetions`;

CREATE TABLE `suggetions` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `ph` varchar(100) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;