package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(1), equalTo("I"));
		assertThat(RomanConverter.getRomanFromNumber(3), equalTo("III"));
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(RomanConverter.getRomanFromNumber(9), equalTo("IX"));
		assertThat(RomanConverter.getRomanFromNumber(10), equalTo("X"));
		assertThat(RomanConverter.getRomanFromNumber(30), equalTo("XXX"));
		assertThat(RomanConverter.getRomanFromNumber(40), equalTo("XL"));
		assertThat(RomanConverter.getRomanFromNumber(50), equalTo("L"));
		assertThat(RomanConverter.getRomanFromNumber(90), equalTo("XC"));
		assertThat(RomanConverter.getRomanFromNumber(100), equalTo("C"));
		assertThat(RomanConverter.getRomanFromNumber(400), equalTo("CD"));
		assertThat(RomanConverter.getRomanFromNumber(500), equalTo("D"));
		assertThat(RomanConverter.getRomanFromNumber(900), equalTo("CM"));
		assertThat(RomanConverter.getRomanFromNumber(1000), equalTo("M"));
		assertThat(RomanConverter.getRomanFromNumber(3000), equalTo("MMM"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
		
		
		
		assertThat(RomanConverter.getNumberFromRoman("I"), equalTo(1));
		assertThat(RomanConverter.getNumberFromRoman("III"), equalTo(3));
		assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));
		assertThat(RomanConverter.getNumberFromRoman("V"), equalTo(5));
		assertThat(RomanConverter.getNumberFromRoman("IX"), equalTo(9));
		assertThat(RomanConverter.getNumberFromRoman("X"), equalTo(10));
		assertThat(RomanConverter.getNumberFromRoman("XXX"), equalTo(30));
		assertThat(RomanConverter.getNumberFromRoman("XL"), equalTo(40));
		assertThat(RomanConverter.getNumberFromRoman("L"), equalTo(50));
		assertThat(RomanConverter.getNumberFromRoman("C"), equalTo(100));
		assertThat(RomanConverter.getNumberFromRoman("D"), equalTo(500));
		assertThat(RomanConverter.getNumberFromRoman("CM"), equalTo(900));		
		assertThat(RomanConverter.getNumberFromRoman("M"), equalTo(1000));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("DD")), instanceOf(IllegalArgumentException.class));
		//assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
		
	}
	
	//TODO : les autres tests 
	
	/*
	
	*/
	


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
