package br.com.vagas.merchantsguide.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.vagas.merchantsguide.model.RomanNumber;
import br.com.vagas.merchantsguide.model.ValueRoman;

public class GalacticNumberTranslator {

	
	public static int toInteger(String[] trans,HashMap<String, String> transList){
        
		List<String> galacticNumbers = new ArrayList<>(Arrays.asList(trans));
        
        List<Integer> numberList = new ArrayList<Integer>();
        
        galacticNumbers.forEach(galacticNumber -> {
        	if(!transList.keySet().contains(galacticNumber)){
        		System.out.println("Invalid value from input detected!");
        		System.exit(0);
        	}
            numberList.add(ValueRoman.getValueByRoman(transList.get(galacticNumber)));
        });
        
        return new RomanNumber(numberList).toInteger();
    }
}
