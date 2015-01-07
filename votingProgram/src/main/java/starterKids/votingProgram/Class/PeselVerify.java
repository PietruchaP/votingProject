package starterKids.votingProgram.Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PeselVerify {
	
	String pesel = new String();
	String date;
	int controlValue;
	String sexType = new String();
	boolean peselCorrect;

	public boolean isPeselCorrect() {
		return peselCorrect;
	}

	private Date birthDate;
	int[] peselNumbers = new int[11];
	char[] charPeselNumber;
	
	public PeselVerify(String checkPesel){
		pesel = checkPesel;

		charPeselNumber = pesel.toCharArray();
		for(int i = 0; i<pesel.length();i++){
			peselNumbers[i] = Integer.parseInt(String.valueOf(charPeselNumber[i]));
		}
		birthDate = createDateOfBirthFromPesel();

			verifyPesel();
			typeOfSex();
	}
	
	public void verifyPesel(){
		boolean answer1,answer2,answer3, answer4;
		answer1 = isControlSumCorrect();
		answer2 = isDateAfterBirthDate();
		answer3 = isVoterMature();
		answer4 = isDateValid();
		if(answer1 == true && answer2==true && answer3 == true && answer4 == true)
			peselCorrect = true;
		else
			peselCorrect = false;
	}
	
	public void print(){
		System.out.println(controlValue);
	}

	private void typeOfSex(){
		int number = peselNumbers[9]%2;
		if(number==1)
			sexType = "man";
		else
			sexType = "woman";
	}
	
	public boolean isDateAfterBirthDate(){
		Date todayDate = new Date(); /// temporary (need to take date frome internet not from computer
		return (todayDate.after(birthDate)) ? true : false;
	}
	public boolean isControlSumCorrect() {
		countControlSum();
		return (peselNumbers[peselNumbers.length-1]==controlValue)? true:false;
	}
		public int countControlSum() {
			controlValue = (10-(peselNumbers[0]+peselNumbers[1]*3+peselNumbers[2]*7+peselNumbers[3]*9+peselNumbers[4]+peselNumbers[5]*3
					+peselNumbers[6]*7+peselNumbers[7]*9+peselNumbers[8]+peselNumbers[9]*3)%10)%10;
			return controlValue;
		}

	public Date getDateOfBirth() {
		return birthDate;
	}
		private Date createDateOfBirthFromPesel() {
			date = null;
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date dateFromPesel = null;
			int defineYearNumber = peselNumbers[2];
			switch(defineYearNumber){
				case (0):
					date = "19" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+Integer.toString(peselNumbers[2])+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;	
				case (1):
					date = "19" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+Integer.toString(peselNumbers[2])+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (2):
					date = "20" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"0"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (3):
					date = "20" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"1"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (4):
					date = "21" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"0"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (5):
					date = "21" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"1"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (6):
					date = "22" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"0"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (7):
					date = "22" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"1"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (8):
					date = "18" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"0"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				case (9):
					date = "18" + Integer.toString(peselNumbers[0])+Integer.toString(peselNumbers[1])+"-"+"1"+Integer.toString(peselNumbers[3])+"-"+
							Integer.toString(peselNumbers[4])+Integer.toString(peselNumbers[5]);
					break;
				default:
					break;
			}
			 try {
				 dateFromPesel = fmt.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
			return dateFromPesel;
		}

		public boolean isVoterMature() {
			Date today = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(today);
			cal.add(Calendar.YEAR,-18);
			Date adultDay = cal.getTime();
			return birthDate.before(adultDay);
		}
		public boolean isDateValid(){
			
			if(date == null){
				return false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false); 
			try { 
				Date checkedDate = sdf.parse(date);
				System.out.println(checkedDate);
			} catch (ParseException e) {	 
				e.printStackTrace();
				return false;
			} 
			return true;
		}
		
		public String getSexType() {
			return sexType;
		}

		public void setSexType(String sexType) {
			this.sexType = sexType;
		}
		
	//      1800 – 1899 	1900 – 1999 	2000 – 2099 	2100 – 2199 	2200 – 2299
	//Styczeń 	81 	            01 	             21 	         41 	        61

}
