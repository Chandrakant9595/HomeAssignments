package properties;


import java.io.IOException;

import org.testng.annotations.Test;

public class TestCaseGetData extends Base{

	@Test
	public void getPropertyTest() throws IOException {
		String url = getObj("URL");
		System.out.println(url);
		
		String fName = getObj("FirstName");
		System.out.println(fName);
		
		String lName = getObj("LastName");
		System.out.println(lName);
	}
}
