package br.com.vagas.merchantsguide.model.expressions;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vagas.merchantsguide.factory.CheckLanguage;
import br.com.vagas.merchantsguide.factory.GalacticNumberTranslator;

public class Credits implements Expression {

	private String line;
	private HashMap<String, String> transList;
	private HashMap<String, Double> curryList;
	
	public Credits(String line, HashMap<String, String> transList, HashMap<String, Double> curryList) {
		this.line = line;
		this.transList = transList;
		this.curryList = curryList;
	}
	
	public void evaluate() {
        Pattern ptn = Pattern.compile(CheckLanguage.rgxCredits);
        Matcher mcher = ptn.matcher(line);
        mcher.matches();    

        String[] trans = mcher.group(1).split(" ");
        int transValue = GalacticNumberTranslator.toInteger(trans ,transList);
        String curr = mcher.group(2);
        int credits = Integer.parseInt(mcher.group(3).trim());
        double value = credits/transValue;
        curryList.put(curr, value);
	}

}
