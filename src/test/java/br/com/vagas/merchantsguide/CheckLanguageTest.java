package br.com.vagas.merchantsguide;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import br.com.vagas.merchantsguide.factory.CheckLanguage;
import br.com.vagas.merchantsguide.model.expressions.Assignment;
import br.com.vagas.merchantsguide.model.expressions.Credits;
import br.com.vagas.merchantsguide.model.expressions.Expression;
import br.com.vagas.merchantsguide.model.expressions.HowMany;
import br.com.vagas.merchantsguide.model.expressions.HowMuch;

public class CheckLanguageTest {
	
	@Test
	public void Checks_The_Input_Question_Of_Values_​By_Placing_The_Corresponding_Flags() {
		
		HashMap<String, String> transList = new HashMap<String, String>();
	    HashMap<String, Double> curryList = new HashMap<String, Double>();
		
		String testAssignment = "glob is I";
		String testCredits = "glob glob Silver is 50 Credits";
		String testHowmany = "how many Credits is glob prok Silver ?";
		String testHowmuch = "how much is pish tegj glob glob ?";
		
		Expression RespAssignment = CheckLanguage.checkFlag(testAssignment, transList, curryList);
		Expression RespCredits = CheckLanguage.checkFlag(testCredits, transList, curryList);
		Expression RespHowmany = CheckLanguage.checkFlag(testHowmany, transList, curryList);
		Expression RespHowmuch = CheckLanguage.checkFlag(testHowmuch, transList, curryList);
		
		assertTrue(RespAssignment instanceof Assignment);
		assertTrue(RespCredits instanceof Credits);
		assertTrue(RespHowmany instanceof HowMany);
		assertTrue(RespHowmuch instanceof HowMuch);
	}
	
}
