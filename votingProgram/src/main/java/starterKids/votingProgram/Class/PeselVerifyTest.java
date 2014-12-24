package starterKids.votingProgram.Class;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class PeselVerifyTest {

	@Test
	public void test() {
	//	fail("Not yet implemented");
	}
	
	@Test
	public void checkFirstPeselNumber(){
		PeselVerify pesel = new PeselVerify("90122301778");
		int test = pesel.countControlSum();
		assertEquals(8, test);
	}
	
	@Test
	public void checkIfPeselCorrect(){
		PeselVerify pesel = new PeselVerify("90122301778");
		boolean correct = pesel.isControlSumCorrect();
		assertEquals(true, correct);
	}
	
	@Test
	public void checkIfPossibleToGetDateFromPesel(){
		PeselVerify pesel = new PeselVerify("90122301778");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = null;

	          try {
				date1 = fmt.parse(new String("1990-12-23"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		 java.util.Date date2 = pesel.getDateOfBirth();
		System.out.println(date2);	
		assertEquals(date1,date2);		
	}
	
	@Test
	public void CurrentDateIsAfterBirth(){
		PeselVerify pesel = new PeselVerify("90122301778");
		boolean test = pesel.isDateCorrect();
		assertEquals(true, test);
	}
	@Test
	public void CurrentDateIsBeforeBirth(){
		PeselVerify pesel = new PeselVerify("30622301778");
		boolean test = pesel.isDateCorrect();
		assertEquals(false, test);
	}
	@Test
	public void TypeOfSexMan(){
		PeselVerify pesel = new PeselVerify("90122301778");
		String test = pesel.typeOfSex();
		assertEquals("man", test);
	}
	@Test
	public void TypeOfSexWoman(){
		PeselVerify pesel = new PeselVerify("90122301788");
		String test = pesel.typeOfSex();
		assertEquals("woman", test);
	}
	@Test 
	public void haveNotEnoughtAge(){
		PeselVerify pesel = new PeselVerify("9912201778");
		boolean test = pesel.isAgeCorrect();
		assertEquals(false, test);
	}

}
