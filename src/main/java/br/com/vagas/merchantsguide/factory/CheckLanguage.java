package br.com.vagas.merchantsguide.factory;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vagas.merchantsguide.model.expressions.Assignment;
import br.com.vagas.merchantsguide.model.expressions.Credits;
import br.com.vagas.merchantsguide.model.expressions.ErrorExpression;
import br.com.vagas.merchantsguide.model.expressions.Expression;
import br.com.vagas.merchantsguide.model.expressions.HowMany;
import br.com.vagas.merchantsguide.model.expressions.HowMuch;

public class CheckLanguage {
    
	public static String Error = "I have no idea what you are talking about";
    public static String rgxAssignment = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
    public static String rgxCredits = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
    public static String rgxHowMany= "^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$";
    public static String rgxHowMuch = "^how much is ((?:\\w+[^0-9] )+)\\?$";
    
	 public static Expression checkFlag(String s, HashMap<String, String> transList, HashMap<String, Double> curryList){
	        Expression flag = new ErrorExpression();
	        String[] rgxArray = new String[]{rgxAssignment,rgxCredits,rgxHowMany,rgxHowMuch};
	        for(int i = 0;i<rgxArray.length;i++){
	            Pattern ptn = Pattern.compile(rgxArray[i]);
	            Matcher mcher = ptn.matcher(s);
	            if(mcher.matches()){
	                switch(i){
	                    case 0:
	                        flag = new Assignment(s, transList);
	                    break;
	                    case 1:
	                        flag = new Credits(s, transList, curryList);
	                    break;
	                    case 2:
	                        flag = new HowMany(s, transList, curryList);
	                    break;
	                    case 3:
	                        flag = new HowMuch(s, transList);
	                    break;
	                    default:
	                        flag = new ErrorExpression();
	                }
	            }
	        }     
	        return flag;
	    }

}
