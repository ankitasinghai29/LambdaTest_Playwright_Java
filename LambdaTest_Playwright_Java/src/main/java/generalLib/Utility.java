package generalLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Utility {
	
	public String readDataFromPropFile(String path, String key) throws Throwable
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	
	public void setDataIntoPropFile(String path, String key, String value) throws Throwable
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fis);
		pro.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(file);
		pro.store(fos, "File Modified");
	}
	

}
