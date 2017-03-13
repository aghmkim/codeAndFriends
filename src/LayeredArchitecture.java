import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class LayeredArchitecture {
	
	private char delim = '~'; //~ has a bit code of 01111110 which makes an ideal FLAG for bit stuffing
	//The characters that will be used by the createRandomString function
	private String characters = "abcdefghikjlmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	String destIPAddress = "170.16.0.5";
	String portNum = "2303";
	
	
	/**
	 * Layer 7
	 * 
	 * @param input
	 * @param size
	 */
	public void applicationProtocol(String input, int size){
		String output=input;
		System.out.println(output);
		presentationProtocol(output,size);
	}
	private void presentationProtocol(String input, int size){
		String header = createRandomString(64);
		String output = input.concat(delim + header);
		System.out.println(output);
		sessionProtocol(output,size);
	}
	private void sessionProtocol(String input, int size){
		String header = createRandomString(64);
		String output = input.concat(delim + header);
		System.out.println(output);
		transportProtocol(output,size);
	}
	private void transportProtocol(String input, int size){
		String header = createRandomString(64);
		String output = input.concat(delim + header);
		System.out.println(output);
		networkProtocol(output,size);
	}
	private void networkProtocol(String input, int size){
		String header = createRandomString(64);
		String output = input.concat(delim + header);
		output = destIPAddress.concat(portNum).concat(output);
		System.out.println(output);
		dataLinkProtocol(output,size);
	}
	private void dataLinkProtocol(String input, int size){
		String header = createRandomString(64);
		String output = input.concat(delim + header);
		System.out.println(output);
		physicalProtocol(output,size);
	}
	private void physicalProtocol(String input, int size){
		String output = convertToBinary(input);
		System.out.println(output);
	}

	/**
	 * Returns a random series of characters of the provided length
	 * @param size the number of random characters to be returned
	 * @return
	 */
	public String createRandomString (int size){
		char[] text = new char[size];
		Random rng = new Random();
		for (int i=0; i<size; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}
	
	public String convertToBinary(String input){
		byte[] bytes = input.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b: bytes)
		{
			int val = b;
			for (int i=0; i<8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<=1;
			}
			binary.append(' ');
		}
		return new String (binary);
	}
	
	//WORK IN PROGRESS
	//idea: knowing how long the message is, and how long the headers are (64 characters)
	//^if those assumptions could be made, the code can know which bytes NOT to stuff
	//the proceed to stuff all other bytes where needed
	public String byteStuffing () {
		return "nocompileerrorrsplease";
	}
}
