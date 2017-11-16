package br.com.vagas.merchantsguide.model.expressions;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vagas.merchantsguide.factory.CheckLanguage;

public class Assignment implements Expression {

	private String line;
	private HashMap<String, String> transList;
	
	public Assignment(String line, HashMap<String, String> transList) {
		this.line = line;
		this.transList = transList;
	}
	
	public void evaluate() {
		Pattern ptn = Pattern.compile(CheckLanguage.rgxAssignment);
        Matcher mcher = ptn.matcher(line);
        mcher.matches();
        String name = mcher.group(1).trim();
        String roman = mcher.group(2).trim();
        if(!transList.containsKey(name)){
            transList.put(name, roman);
        }
	}
}
