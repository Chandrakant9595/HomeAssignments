package homeAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter no ");
		int no = Integer.parseInt(br.readLine());
		
		long n1 = 0;
		System.out.println(n1);
		long n2 = 1;
		System.out.println(n2);
		long n = n1+n2;
		System.out.println(n);
		
		int count = 3;
		 
		while(count<=no){
			n1=n2;
			n2=n;
			n = n1+n2;
			System.out.println(n);
			count ++;
		}
	}
}
