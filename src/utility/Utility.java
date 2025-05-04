package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	 public static Properties readPropertiesFile(String fileName)  {
		  FileInputStream fis = null;
	      Properties prop = null;
	      String path = System. getProperty("user.dir");
	      String filePath=path+"\\resources\\"+fileName;
	      try {	    	  
	    	 fis = new FileInputStream(filePath);
	         prop = new Properties();
	         prop.load(fis);
	         fis.close();
	      } catch(FileNotFoundException fnfe) {
	         System.out.println("File not present at: "+filePath);
	         System.exit(0);
	      } catch(IOException ioe) {
	    	  System.out.println("IOException in file: "+filePath);
	    	  System.exit(0);
	      } 
	      return prop;
	   }
}
