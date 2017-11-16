package br.com.vagas.merchantsguide.model;

import java.util.List;

public class RomanNumber {

	private List<Integer> numbers;

	public RomanNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static int repeatValidateOneOrMore(List<Integer> numbers) {
		int reptValue = 0;
		
		for(int num= 0; num < numbers.size() ; num ++) {
			if(num + 1 != numbers.size()) {
				if(numbers.get(num) == numbers.get(num + 1)) {
					reptValue = reptValue + 1;
				}
			}else {
				if(numbers.get(num) == numbers.get(num)) {
					reptValue = reptValue + 1;
				}
			}
		}
		return reptValue;
	}

	public static int repeatValidationDVL(List<Integer> numbers) {
		int doubleVerification = 0;
		for(int num= 0; num < numbers.size() ; num ++) {
			
			if(numbers.get(num) == ValueRoman.D.getValue() || numbers.get(num) == ValueRoman.L.getValue() || numbers.get(num) == ValueRoman.V.getValue()) {
				if(num + 1 != numbers.size()) {
					if(numbers.get(num) == numbers.get(num + 1)) {
						doubleVerification = doubleVerification + 1;
					}
					
				}else{
					if(numbers.get(num) == numbers.get(num - 1)) {
						doubleVerification = doubleVerification + 1;
					}
				}
			}
	}
		return doubleVerification;
	}

	public int toInteger()	{
		int value = 0;
		int currentElement;
		int doubleVerification = repeatValidationDVL(numbers);
		int reptValue = repeatValidateOneOrMore(numbers);
		
		for(int i = 0 ; i < numbers.size() -1; i++)
		{
			currentElement = numbers.get(i);
			if( currentElement < numbers.get(i+1))
			{
				numbers.set(i, -currentElement);
			}
		}
		if (reptValue > 3) {
			System.out.println("caution, Roman value repeats more than 4 times for the calculation!!");
		}
		if(doubleVerification >= 1) {
			System.out.println("the value D, L or v tant repeated more than once");
		}
	    for(int i : numbers ){ value+=i;   }
	    
	    return value;
	}
}
