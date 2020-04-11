package org.btm.propertyApp;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader 
{
	public static void main(String[] args) 
	{
		FileReader fr=null;
		Properties p=new Properties();
		try {
			fr=new FileReader("config/data.properties");
			//Load Properties File
			p.load(fr);
			//Fetch Data from Properties File
			String username=p.getProperty("user");
			String password=p.getProperty("pw");
			System.out.println(username+" "+password);
			String gender=p.getProperty("ge","Key Not Found");
			System.out.println(gender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
