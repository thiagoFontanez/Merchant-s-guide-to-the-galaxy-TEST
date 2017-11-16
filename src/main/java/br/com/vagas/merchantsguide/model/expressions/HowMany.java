package br.com.vagas.merchantsguide.model.expressions;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vagas.merchantsguide.factory.CheckLanguage;
import br.com.vagas.merchantsguide.factory.GalacticNumberTranslator;

public class HowMany implements Expression {
	
	private String line;
	private HashMap<String, String> transList;
	private HashMap<String, Double> curryList;

	public HowMany(String line, HashMap<String, String> transList, HashMap<String, Double> curryList) {
		this.line = line;
		this.transList = transList;
		this.curryList = curryList;
	}

	public void evaluate() {
        Pattern ptn = Pattern.compile(CheckLanguage.rgxHowMany);
        Matcher mcher = ptn.matcher(line);
        mcher.matches();
        String[] trans = mcher.group(2).split(" ");
        int transValue = GalacticNumberTranslator.toInteger(trans ,transList);
        String curr = mcher.group(3).trim();
        double value = 0;
        for(String k:curryList.keySet()){
            if(k.equals(curr)){
               value = curryList.get(k);
            }
        }
        double total = transValue*value;
        if(total != 0){
            System.out.println(mcher.group(2)+ mcher.group(3) +" is "+(long)total+" Credits");
        }
	}

}
