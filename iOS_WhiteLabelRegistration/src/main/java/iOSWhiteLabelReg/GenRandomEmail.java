package iOSWhiteLabelReg;

import java.util.Random;

public class GenRandomEmail {

	public String EmailAdd()
	{
		Random r = new Random();
		int num = r.nextInt(10000);
		String rn = Integer.toString(num);
		String email = "sriios"+rn+"@test.com";
		System.out.println(email);
		return email;
	}

}
