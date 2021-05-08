package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFileTest 
{
	@Test
	public  void readDataTest() throws IOException 
	{
		FileInputStream fis =new FileInputStream("./Data/commondata.property");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		  String URL = pObj.getProperty("url");
		  String USERNAME = pObj.getProperty("username");
		  String PASSWORD = pObj.getProperty("password");
		  String BROWSER = pObj.getProperty("browser");
		  String PLATEFORM = pObj.getProperty("plateform");
		  
		  System.out.println(URL);
		  System.out.println(USERNAME);
		  System.out.println(PASSWORD);
		  System.out.println(BROWSER);
		  System.out.println(PLATEFORM);
		  
		
	}

}
