
// Use this class to translate the equation
public class XXXTranslator {
	RPoland rp;
	Translation dt;
	Dictionary dict;
	
	public XXXTranslator (String equation) {
		dict = new Dictionary ();
		rp = new RPoland(equation);
		dt = new Translation(rp.doCalculation(), dict.xxxDictionary);
		dt.translate();
	}
	
	public String getDogLanguage () {
		return dt.getTheirLanguage();
	}
	
	/*
	public static void main (String args[]) {
		DogTranslator t = new DogTranslator ("12 zeta");
		System.out.println(t.getDogLanguage());
	}
	*/
}
