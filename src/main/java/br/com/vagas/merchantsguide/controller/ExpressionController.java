package br.com.vagas.merchantsguide.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vagas.merchantsguide.factory.CheckLanguage;
import br.com.vagas.merchantsguide.factory.GalacticNumberTranslator;
import br.com.vagas.merchantsguide.model.expressions.Assignment;
import br.com.vagas.merchantsguide.model.expressions.Credits;
import br.com.vagas.merchantsguide.model.expressions.Expression;
import br.com.vagas.merchantsguide.model.expressions.HowMany;
import br.com.vagas.merchantsguide.model.expressions.HowMuch;



public class ExpressionController {
    
    private static HashMap<String, String> transList = new HashMap<String, String>();
    private static HashMap<String, Double> curryList = new HashMap<String, Double>();
    
    public void readFile(String file) {
    	
        BufferedReader br = null;       
        
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line!=null){
                Expression flag = CheckLanguage.checkFlag(line, transList, curryList);
                
            	flag.evaluate();
                
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpressionController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(ExpressionController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ExpressionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}