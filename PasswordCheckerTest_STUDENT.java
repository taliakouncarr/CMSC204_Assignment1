
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = { "aaaH8r!", "7Hyss", "taliakouncar4@2","taLiaKoun&", "compSci88", "MONTGOMERYCOLLEGE9@"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 * 
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("tkd8"));
			assertTrue("Threw lengthException", true);
		} catch (LengthException e) {
			assertFalse("Threw a lengthException", false);
		}

		catch (Throwable c) {
			assertTrue("Didn't throw a different exception besides LengthException", true);
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("qwerty5732"));
			 
			assertFalse("Did not throw NoUpperAlphaException",true);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Threw a NoUpperAlphaExcepetion",true);
		}
		catch(Throwable c)
		{
			assertTrue("Threw a different exception besides NoUpperAlphaException"
					,false);
		}	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("TALIAKOUNCAR353"));
 
			assertFalse("Didn't throw a NoLowerAlphaException",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Threw a NoLowerAlphaExcepetion",true);
		}
		catch(Throwable c)
		{
			assertTrue("Threw a different exception rather than NoLowerAlphaException",false);
		}

	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		{
			try{
				 
				boolean weakPassword = PasswordCheckerUtility.isWeakPassword​("ab^3hA");
				assertTrue("Threw WeakPassword Exception",true);
			}
			catch(WeakPasswordException e)
			{
				assertTrue("Threw a NoLowerAlphaExcepetion",true);
			}
			catch(Throwable e)
			{ 
				assertTrue("Didn't throw the incorrect exception",true);
			}
		}
}


	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword​("hhhWWH7!34f"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threw an InvalidSequenceExcepetion for this password",true);
		}
		catch(Throwable e)
		{
			assertFalse("Threw a different exception other than an InvalidSequenceException",true);
		}	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword​("abc**hH"));
		 	assertTrue("Didn't throw a NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Threw an NoDigitException",true);
		}
		catch(Throwable e)
		{
			assertFalse("Threw another exception besides an NoDigitException",true);
		}	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword​("7&hHtyk2G"));
		 	assertTrue("Didn't throw any exception",true);
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			assertTrue("Threw a different exception",false);
		}
	}	

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords​(passwords);
		
		

		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "aaaH8r!");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "7Hyss");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("long"));
		
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "taliakouncar4@2");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "taLiaKoun&");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "compSci88");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "MONTGOMERYCOLLEGE9@");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		
		
			}

}
