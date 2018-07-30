package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider

{

	public Properties prop;
	public ConfigDataProvider()
	{
		File src = new File("./Config/config.properties");

		try {
			FileInputStream input = new FileInputStream(src);
			prop = new Properties();
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser()
	{
		return prop.getProperty("browser");
	}
	
	public String getApplicationURL()
	{
		return prop.getProperty("url");
	}
	
	public String getUserName()
	{
		return prop.getProperty("username");
	}
	
	public String getUserPassword()
	{
		return prop.getProperty("password");
	}
	
	public String getValuefromConfig(String Key)
	{
		return prop.getProperty(Key);
	}
}
