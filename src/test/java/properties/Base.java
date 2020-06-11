package properties;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Base {

	public static Properties prop;
	
	public static void loadData() throws IOException {
		prop = new Properties();
		File f = new File(System.getProperty("user.dir")+ "/src/test/java/properties/data.properties");
		FileReader obj = new FileReader(f);
		prop.load(obj);
	}
	
	public static String getObj(String Data) throws IOException {
		loadData();
		String data = prop.getProperty(Data);
		return data;
		
	}

}

