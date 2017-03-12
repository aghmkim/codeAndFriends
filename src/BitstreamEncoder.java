
public class BitstreamEncoder {
	//ASSUMED THAT A CHARACTER IS 8 BITS LONG
	
	public String generator (String input) {
		String val=input;
		String result = "00000000";
		String checkSum;
		val=val.replaceAll(" ","");
		while (val.length()>0){
			result=binaryAdd(result,val.substring(0, 8));
			val=val.substring(8);
		}
		while (result.length()<8) {
			result = "0".concat(result);
		}
		checkSum=result;
		//take the complement to find the checksum
		checkSum=checkSum.replaceAll("0","2");
		checkSum=checkSum.replaceAll("1","0");
		checkSum=checkSum.replaceAll("2","1");
		
		System.out.println(result);
		System.out.println(checkSum);
		
		return input.concat(checkSum);
	}
	
	public void verifier (String input) {
		String val=input;
		String result = "00000000";
		String checkSum;
		val=val.replaceAll(" ","");
		while (val.length()>0){
			result=binaryAdd(result,val.substring(0, 8));
			val=val.substring(8);
		}
		if (Integer.parseUnsignedInt(result)==0){
			System.out.println("correct");
		}
		else
		{
			System.out.println("incorrect");
		}
	}
	
	public String alter(String input, int index) {
		input=input.replaceAll(" ","");
		index=index-1;
		String output;
		char newCharacter;
		if (index>input.length() || index < 0) {
			System.out.println("Invalid index");
			return "ERROR";
		}
		else {
			if (input.charAt(index)=='0') {
				newCharacter='1';
			}
			else {
				newCharacter='0';
			}
			output=input.substring(0, index) + newCharacter + input.substring(index+1);
		}
		return output;
	}
	
	/**
	 * Adds two binary numbers (represented as strings) and outputs the binary result (as a string)
	 * Does binary addition assuming the provided values are 8 bits in length
	 * @param a String representation of first number
	 * @param b String representation of second number
	 * @return String representation of the binary result
	 */
	private static String binaryAdd(String a, String b){
		int first = Integer.parseUnsignedInt(a, 2);
		int second = Integer.parseUnsignedInt(b, 2);
		while (second!=0){
			int carry= (first & second);
			
			first = first ^ second;
			
			second = carry << 1;
		}
		first = (int) (first % (Math.pow(2,8)-1));
		return Integer.toBinaryString(first);
	}
}
