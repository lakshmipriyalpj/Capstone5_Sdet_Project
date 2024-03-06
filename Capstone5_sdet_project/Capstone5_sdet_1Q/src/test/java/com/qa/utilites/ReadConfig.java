package com.qa.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;//create an obj namedproperties (class)
	
	//create constructor 
	public ReadConfig()
	{
		File src = new  File ("C:\\Users\\Lakshmi Priya\\Downloads\\Capstone5_sdet_project\\Capstone5_sdet_project\\Capstone5_sdet_1Q\\src\\test\\java\\com\\qa\\testdata\\config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getSearch()
	{
		String search=pro.getProperty("search");
		return search;
	}
	

}
