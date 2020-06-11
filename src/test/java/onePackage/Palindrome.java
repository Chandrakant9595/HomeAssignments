package onePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String ori = br.readLine();
		
		String rev = "";
		
		int len = ori.length();
		
		for(int i=len-1; i>=0; i--){
			rev = rev + ori.charAt(i);
		}
		
		if(ori.equals(rev)){
			System.out.println("Palindrome");
		}else{
			System.out.println("NotPalindrome");
		}
		
		System.out.println();

	}

}
