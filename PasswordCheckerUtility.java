import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Class: CMSC203 
 * Instructor: Aygun
 * Description: Password checker
 * Due: 09/11/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Talia Kouncar
*/
public class PasswordCheckerUtility {

	/**
	 * @author Talia Kouncar
	 */

	/**
	 * constructor
	 */
	public PasswordCheckerUtility() {

	}

	// throws unmatched exception
	/**
	 * Compare equality of two passwords
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords​(String password, String passwordConfirm) throws UnmatchedException {

		if (!(password.equals(passwordConfirm))) {
			throw new UnmatchedException("Passwords do not match");

		}
	}

	/**
	 * Compare equality of two passwords
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm) {

		boolean comp = false;

		if (password.equals(passwordConfirm)) {
			return comp = true;
		}

		return comp;
	}

	/**
	 * Checks the password length requirement - The password must be at least 6
	 * characters long
	 * 
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength​(String password) throws LengthException {
		if (password.length() < 6) {
			throw new LengthException("The password must be at least 6 characters long");
		} else
			return true;
	}

	/**
	 * Checks the password alpha character requirement - Password must contain an
	 * uppercase alpha character
	 * 
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException {
		for (char c : password.toCharArray()) {

			if ((Character.isUpperCase(c))) {
				return true;
			}
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}

	/**
	 * Checks the password lowercase requirement - Password must contain at least
	 * one lowercase alpha character
	 * 
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException {
		for (char c : password.toCharArray()) {

			if ((Character.isLowerCase(c))) {
				return true;
			}
		}

		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");

	}

	/**
	 * Checks the password Digit requirement - Password must contain a numeric
	 * character
	 * 
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit​(String password) throws NoDigitException {
		for (char c : password.toCharArray()) {

			// if no digit is found...
			if ((Character.isDigit(c))) {
				return true;
			}
		}
		throw new NoDigitException("The password must contain at least one digit");

	}

	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a
	 * Special Character
	 * 
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException {
		// define a pattern
		Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?\\\\|]");
		// need to use a matcher to check if the pattern exists in the password
		Matcher match = pattern.matcher(password);

		if (match.find()) {
			return true;
		} else
			throw new NoSpecialCharacterException("The password must contain at least one special character");

	}

	/**
	 * Checks the password Sequence requirement - Password should not contain more
	 * than 2 of the same character in sequence
	 * 
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException {
		for (int i = 0; i < password.length() - 2; i++) {
			if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
				throw new InvalidSequenceException(
						"The password cannot contain more than two of the same character in sequence.");
			}
		}
		return true;
	}

	/**
	 * Return true if valid password (follows all the following rules), returns
	 * false if an invalid password 1. At least 6 characters long - 2. At least 1
	 * numeric character- 3. At least 1 uppercase alphabetic character - 4. At least
	 * 1 lowercase alphabetic character - 5. At least 1 special character - 6. No
	 * more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 –
	 * not OK Aaabb@123 – OK
	 * 
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

		if (password.length() < 6) {
			throw new LengthException("The password must be at least 6 characters long");
		}

		// Check other criteria here
		if (!hasUpperAlpha​(password)) {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}

		if (!hasLowerAlpha​(password)) {
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}

		if (!hasDigit​(password)) {
			throw new NoDigitException("The password must contain at least one digit");
		}

		if (!hasSpecialChar​(password)) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}

		if (!NoSameCharInSequence​(password)) {
			throw new InvalidSequenceException(
					"The password cannot contain more than two of the same character in sequence.");
		}

		return true;
	}

	/**
	 * checks if the password contains 6 to 9 characters
	 * 
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars​(String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * 
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword​(String password) throws WeakPasswordException {
		if ((hasBetweenSixAndNineChars​(password))) {
			throw new WeakPasswordException("The password is OK but weak- it contains fewer than 10 characters.");
		}
		return false;
	}

	/**
	 * This method will accept an ArrayList of passwords as the parameter and return
	 * an ArrayList with the status of any invalid passwords (weak passwords are not
	 * considered invalid). The ArrayList of invalid passwords will be of the
	 * following format: password BLANK message of the exception thrown
	 * 
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) {
		ArrayList<String> invalidPassword = new ArrayList<>();
		for (String password : passwords) {

			try {
				if (!isValidLength​(password)) {
					throw new LengthException("The password must be at least 6 characters long");
				} else if (!hasUpperAlpha​(password)) {
					throw new NoUpperAlphaException(
							"The password must contain at least one uppercase alphabetic character");
				} else if (!hasLowerAlpha​(password)) {
					throw new NoLowerAlphaException(
							"The password must contain at least one lowercase alphabetic character");
				} else if (!hasDigit​(password)) {
					throw new NoDigitException("The password must contain at least one digit");
				} else if (!hasSpecialChar​(password)) {
					throw new NoSpecialCharacterException("The password must contain at least one special character");
				} else if (!NoSameCharInSequence​(password)) {
					throw new InvalidSequenceException(
							"The password cannot contain more than two of the same character in sequence.");
				}
			} catch (Exception e) {
				invalidPassword.add(password + " " + e.getMessage());
			}
		}
		return invalidPassword;
	}

}
