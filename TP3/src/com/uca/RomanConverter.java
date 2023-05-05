package com.uca;


import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		
		StringBuilder string = new StringBuilder();
		
		if(a >=0 || a <= 3999){
			for(RomanNumber romanNumber : SYMBOLS) {
				while(a >= romanNumber.getValue()) {
					string.append(romanNumber.getRoman());
					a -= romanNumber.getValue();
					}
		
				}
		}
	
		else {

			throw new IllegalArgumentException();	

			}
		
		
		
		return string.toString();
	}
	
	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		//TODO
		int n = 0;
		
		for (int i = 0; i < a.length(); i++){
			char c = a.charAt(i);
			
			switch(c) {
			
			case 'I' : 
				/*if(i != a.length()-1 && (a.charAt(i+1) == 'I' && a.charAt(i+3) == 'I')){
					throw new IllegalArgumentException();
				}*/
				n = (i != a.length() - 1 && (a.charAt(i+1) == 'V' || a.charAt(i+1) == 'X')) 
					? n - 1
					: n + 1;
				break;
				
			case 'V' : 
				if(i != a.length()-1 && a.charAt(i+1) == 'V'){
					throw new IllegalArgumentException();
				}
				n += 5;
				break;
				
			case 'X' :
				n = (i != a.length() - 1 && (a.charAt(i+1) == 'L' || a.charAt(i+1) == 'C'))
					? n - 10
					: n + 10;
				break;
			
			case 'L' :
				if(i != a.length()-1 && a.charAt(i+1) == 'L'){
					throw new IllegalArgumentException();
				}
				n += 50;
				break;
				
			case 'C' :
				n = (i != a.length() - 1 && (a.charAt(i+1) == 'D' || a.charAt(i+1) == 'M'))
					? n - 100
					: n + 100;
				break;
			
			case 'D' :
				if(i != a.length()-1 && a.charAt(i+1) == 'D'){
					throw new IllegalArgumentException();
				}
				n += 500;
				break;
				
			case 'M' : 
				n += 1000;
			}
		}
		
		return n;
	}
}
