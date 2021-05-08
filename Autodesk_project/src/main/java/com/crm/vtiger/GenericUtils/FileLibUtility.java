package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;





public class FileLibUtility 
{
	@Test
	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./Data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		return  p.getProperty(key);
	}

	
	/**
	 * this method is used to read data from json file
	 * @param jsonKey
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String getDataFromJson(String jsonKey) throws IOException, ParseException 
	{
		FileReader reader=new FileReader(IPathConstant.JSONPATH);
		JSONParser parser=new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonObject = (JSONObject)object;
		String value=jsonObject.get(jsonKey).toString();
		return value;
	}
	


}
