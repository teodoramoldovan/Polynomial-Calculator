package PT2018.assigment1.Assigment1PolynomialCalculator;



import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monom {
	
	private int exponent;
	private double coeficient;
	
	
	public Monom(int exponent,double coeficient) {
		this.exponent=exponent;
		this.coeficient=coeficient;
	}
	public Monom(String mon) {
		Pattern p = Pattern.compile("\\^");
		Matcher m = p.matcher(mon);
		String s = new String();
		String s2[];
		while(m.find()) {
			s = m.group();
		}
		if(!s.isEmpty()) {
			s2 = mon.split("\\^");
			try {
				String s3 = new String();
				s3=s2[0].replaceAll("x","");
				if(s3.equals("-")) {
					String s5=new String();
					s5=s3.replaceAll("-", "");
					coeficient=(s5.isEmpty())?-1.0:Double.parseDouble(s3);
				}
				else coeficient = (s3.isEmpty()) ? 1.0 : Double.parseDouble(s3);
				exponent = Integer.parseInt(s2[1]);
			} catch(NumberFormatException e) { //     
				System.out.println("Ceva nu e bine");
			}
		} else {
			s2 = mon.split("[a-zA-Z]");
			if(s2.length == 0) {
				coeficient = 1.0;
				exponent = 1;
			} else {
				if(s2[0].equals("-")) {
					String s4=new String();
					s4=s2[0].replaceAll("-", "");
					coeficient=(s4.isEmpty())?-1.0:Double.parseDouble(s2[0]);
				}
				else coeficient = (!s2[0].isEmpty()) ? Double.parseDouble(s2[0]) : 1.0;
				exponent = (s2[0] == mon) ? 0 : 1;
			}
		} 
	}
	public void adunaCoeficienti(double coeficient) {
		this.coeficient += coeficient;
	}
	public static Comparator<Monom> comparareDupaPuteri() {//pentru argument la Collections.sort 
		Comparator<Monom> comp = new Comparator<Monom>(){
		    public int compare(Monom m1, Monom m2) {
		    	return Integer.compare(m1.exponent, m2.exponent);
		    }        
		};
		return comp;
	}  
	public String toString(){
			if(exponent==0) {
				return this.coeficient+"";
			}
			else {
				return this.coeficient+"x^"+this.exponent;
			}	
	}
	public Monom inmultire(Monom m) {
		Monom mNew;
		double coef=this.getCoeficient()*m.getCoeficient();
		int expo=this.getExponent()+m.getExponent();
		mNew=new Monom(expo,coef);
		return mNew;
	}
	public Monom impartire(Monom m) {
		Monom mNew;
		double coef = this.coeficient/ m.coeficient;
		int expo = this.exponent - m.exponent;
		mNew=new Monom(expo,coef);
		return mNew;
	}
	public void deriveaza() {
		if(this.exponent!=0) {
			coeficient=coeficient*exponent;
			exponent-=1;
		}
		else coeficient=0;
	}
	public void integreaza() {
		exponent+=1;
		coeficient=coeficient/exponent;
	}
	public int getExponent() {
		return exponent;
	}
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	public double getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}
}


