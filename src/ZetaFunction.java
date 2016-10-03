

public class ZetaFunction {
	public static String zeta(String zetaEq) {
		zetaEq = zetaEq.substring(5);
		double zetaValueDouble = Double.parseDouble(zetaEq);
		int zetaValue;
		
		if (zetaValueDouble - Math.floor(zetaValueDouble) < 0.0000000000001) {
			zetaValue = (int)Math.floor(zetaValueDouble);
		}
		else {
			return "ERROR";
		}
		
		switch (zetaValue) {
		case 0:
			return "-0.5";
		case 1:
			return "Infinity";
		case 2:
			return "π^2/6";
		case 3:
			return "1.2020569";
		case 4:
			return "π^4/90";
		case 5: 
			return "1.0369278";
		case 6:
			return "π^6/945";
		case 7:
			return "1.0083493";
		case 8:
			return "π^8/9450";
		case 9:
			return "1.0020084";
		case 10:
			return "π^10/93555";
		case 12:
			return "691π^12/638512875";
		case 14:
			return "2π^14/18243225";
		case 16:
			return "3617π^16/325641566250";
		case 18:
			return "43867π^18/38979295480125";
		case 20:
			return "174611π^20/1531329465290625";
		case -1:
			return "-1/12";
		case -2:
			return "0";
		case -3:
			return "1/120";
		case -4:
			return "0";
		case -5:
			return "-1/252";
		case -6:
			return "0";
		case -7:
			return "1/240";
		case -8:
			return "0";
		case -9:
			return "-1/132";
		case -10:
			return "0";
		default:
			zetaEq = "ERROR";
		}
		
		return zetaEq;
	}
	
	/*
	public static void main (String args[]) {
		System.out.println(ZetaFunction.zeta("zeta 12"));
	
	}
	*/
}
