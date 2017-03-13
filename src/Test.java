
public class Test {

	public static void main(String[] args) {
		LayeredArchitecture test = new LayeredArchitecture();
		BitstreamEncoder encoder = new BitstreamEncoder();
		System.out.println(test.convertToBinary("~"));
		String testString = "bllkahsdflfkahw";
		test.applicationProtocol("message", 7);
		System.out.println(testString + " in binary: \n" + test.convertToBinary(testString));
		String encoded=encoder.generator(test.convertToBinary(testString));
		System.out.println(encoded);
		encoder.verifier(encoded);
		encoded=encoder.alter(encoded, 123);
		encoder.verifier(encoded);
	}
	


}
