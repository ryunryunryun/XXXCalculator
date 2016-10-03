

public class Translation {
	private String nativeLanguage;
	private String theirLanguage;
	
	private String[] dict;
	
	public Translation (String nativeLanguage, String[] dict_) {
		this.nativeLanguage = nativeLanguage;
		
		dict = new String[dict_.length];
		for (int i = 0; i < dict_.length; i++) {
			dict[i] = dict_[i];
		}
	}
	
	public String getTheirLanguage () {
		return this.theirLanguage;
	}
	
	public void translate () {
		String output = "";
		
		if (nativeLanguage.indexOf("ERROR") >= 0) {
			theirLanguage = "???";
			return;
		}
		
		if (nativeLanguage.indexOf("zeta") >= 0) {
			zetaCalculation();
			
			if (nativeLanguage.indexOf("ERROR") >= 0) {
				theirLanguage = "???";
				return;
			}
		}
		else if (nativeLanguage.equals("Infinity")) {
			theirLanguage = dict[16];
			return;
		}
		else if (nativeLanguage.equals("-Infinity")) {
			theirLanguage = dict[17];
			return;
		}
		else {
			setInteger();
		}
		
		for (int i = 0; i < nativeLanguage.length(); i++) {
			try {
				switch (nativeLanguage.charAt(i)) {
				case '.':
					output += dict[10];
					break;
				case '-':
					output += dict[11];
					break;
				case '/':
					output += dict[12];
					break;
				case '^':
					output += dict[13];
					break;
				case 'π':
					output += dict[14];
					break;
				case 'E':
					output += dict[15];
					break;
				default:
					output += dict[(int)(nativeLanguage.charAt(i)) - 48];
				}
			}
			catch (Exception e) {
				output = "???";
			}
		}
		
		theirLanguage = output;
	}
	
	// zeta
	public void zetaCalculation() {
		nativeLanguage = ZetaFunction.zeta(nativeLanguage);
	}
	
	// integer
	public void setInteger () {
		try {
			double a = Double.parseDouble(nativeLanguage);
			if (a - Math.floor(a) < 0.000000000001) {
				nativeLanguage = "" + (long)(Math.floor(a));
			}
		} 
		catch (Exception e) {
			
		}
	}
}
