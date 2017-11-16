package br.com.vagas.merchantsguide;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import br.com.vagas.merchantsguide.model.RomanNumber;
import br.com.vagas.merchantsguide.model.ValueRoman;


public class FactoryTranslateTest {
	
	@Test
	public void Checks_If_Roman_Numeral_D_L_V_Repeats_in_sequence_between_a_list() {
		ArrayList<Integer> NumberRomanTranslate = new ArrayList<>();
		NumberRomanTranslate.add(ValueRoman.D.getValue());
		NumberRomanTranslate.add(ValueRoman.D.getValue());
		NumberRomanTranslate.add(ValueRoman.L.getValue());
		NumberRomanTranslate.add(ValueRoman.V.getValue());
		NumberRomanTranslate.add(ValueRoman.V.getValue());

		int rept = RomanNumber.repeatValidationDVL(NumberRomanTranslate);
		
		assertThat(rept, equalTo(2));
	}
	
	@Test
	public void Checks_If_Roman_Numeral_Repeats_4_in_sequence_between_a_list() {
		ArrayList<Integer> NumberRomanTranslate = new ArrayList<>();
		NumberRomanTranslate.add(ValueRoman.I.getValue());
		NumberRomanTranslate.add(ValueRoman.I.getValue());
		NumberRomanTranslate.add(ValueRoman.I.getValue());
		NumberRomanTranslate.add(ValueRoman.D.getValue());
		NumberRomanTranslate.add(ValueRoman.I.getValue());
		
		int rept = RomanNumber.repeatValidateOneOrMore(NumberRomanTranslate);
		
		assertThat(rept, equalTo(3));
		
	}
	
	@Test
	public void Verifies_Translation_of_Roman_values_​​into_numerals() {
		
		int One = ValueRoman.getValueByRoman("I");
		int five = ValueRoman.getValueByRoman("V");
		int teen = ValueRoman.getValueByRoman("X");
		int fifiten = ValueRoman.getValueByRoman("L");
		int hundred = ValueRoman.getValueByRoman("C");
		int fiveHundred = ValueRoman.getValueByRoman("D");
		int thousand = ValueRoman.getValueByRoman("M");
		
		assertThat(One, equalTo(1));
		assertThat(five, equalTo(5));
		assertThat(teen, equalTo(10));
		assertThat(fifiten, equalTo(50));
		assertThat(hundred, equalTo(100));
		assertThat(fiveHundred, equalTo(500));
		assertThat(thousand, equalTo(1000));
	}

}
