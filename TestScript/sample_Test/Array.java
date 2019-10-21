package sample_Test;

import org.testng.annotations.Test;

public class Array {

	// array --> collection of objects (string,integer)
	@Test(enabled = false)
	public void sumofarray() {
		int sum = 0;
		int c[]= {1,2,3,4,5};
		for (int i = 0; i < c.length; i++) {
			sum = sum+c[i];
			System.out.println("Sum of array:" +sum);
		}
	}
	
	// Index array of 4th digit
	@Test(enabled = true)
	public void index() {
		int c[]= {1,2,3,4,5};
		for (int i = 0; i < c.length; i++) {
			if (c[i]==2) {
				System.out.println("Index value of 2 is :"+i);
				break; // if data match exactly then loop will be break
			}
			System.out.println("Index value: "+i);
		}
	}
}
