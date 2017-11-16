package br.com.vagas.merchantsguide.model.expressions;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vagas.merchantsguide.factory.CheckLanguage;
import br.com.vagas.merchantsguide.factory.GalacticNumberTranslator;

public class HowMuch implements Expression {

	private String line;
	private HashMap<String, String> transList;

	public HowMuch(String line, HashMap<String, String> transList) {
		this.line = line;
		this.transList = transList;
	}
	
	public void evaluate() {
		Pattern ptn = Pattern.compile(CheckLanguage.rgxHowMuch);
        Matcher mcher = ptn.matcher(line);
        mcher.matches();
        
        String[] trans = mcher.group(1).split(" ");
        int transValue = GalacticNumberTranslator.toInteger(trans ,transList);
        if(transValue!=0){
            System.out.println(mcher.group(1)+"is "+transValue);
        }
	}

}
