package br.com.vagas.merchantsguide.model;

public enum ValueRoman {
	
	  I("I",1),
      V("V",5),
      X("X",10),
      L("L",50),
      C("C",100),
      D("D",500),
      M("M",1000);
      
      private String name;
      private int value;

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public int getValue() {
          return value;
      }

      public void setValue(int value) {
          this.value = value;
      }
      
      public static int getValueByRoman(String roman){
	    switch(roman){
	        case "I":
	            return I.getValue();
	        case "V":
	            return V.getValue();
	        case "X":
	            return X.getValue();
	        case "L":
	            return L.getValue();
	        case "C":
	            return C.getValue();
	        case "D":
	            return D.getValue();
	        case "M":
	            return M.getValue();
	        default:
	            return 0;
	    }
	}

	ValueRoman(String name, int value){
          this.name = name;
          this.value = value;
      }

}
