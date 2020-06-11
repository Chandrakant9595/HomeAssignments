package twoPackage;
import onePackage.*;

public class Two extends One{

	public static void main(String args[]) {
		One o = new One();
		o.mesage();
		
		Two t = new Two();
		t.message2();
	}
}
