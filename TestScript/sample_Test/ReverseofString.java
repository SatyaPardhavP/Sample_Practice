package sample_Test;

import org.testng.annotations.Test;

public class ReverseofString {

	
// Reverse of a string
	@Test(enabled = false)
	public void reverse() {
	String s = "Satya";	
	for (int i = s.length()-1;i>=0;i--) {
		System.out.println("Reverse text:"+s.charAt(i));
	}
	}
	
// String
	@Test(enabled = true)
	public void string1() {
		String str = "acdb";
		System.out.println(str.charAt(0)); // identify the character in string
		System.out.println(str.indexOf("b")); // Identify the index value
		System.out.println(str.substring(1)); // Begin the character index
		
	}
	
}
