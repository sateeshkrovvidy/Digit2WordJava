package com.java.digit2word;

public class Digit2Word {

	private static final String[] BigNumberNames = {
			
			
            "",
            " thousand",
            " million",
            };
        
        private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
        };
        
        private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
        };
        
        private String convertLessThanOneThousand(int number) {
            String current;
            
            if (number % 100 < 20){
            	
                current = numNames[number % 100];
                number /= 100;
            	 }
            else {
                current = numNames[number % 10];
                number /= 10;
                
                current = tensNames[number % 10] + current;
                number /= 10;
            }
            if (number == 0) return current;
            return numNames[number] + " hundred" + current;
        }
        
        public String convert(long number) {

            if (number == 0) { return "zero"; }
            
            String prefix = "";
            
            if (number < 0) {
                number = -number;
                prefix = "Minus";
            }
            
            String current = "";
            int place = 0;
            
            do {
               long n = number % 1000;
                if (n != 0){
                    String s = convertLessThanOneThousand((int)n);
                    current = s + BigNumberNames[place] + current;
                }
                place++;
                number /= 1000;
            } while (number > 0);
            
            return (prefix + current).trim();
        }
        
        public static void main(String[] args) {
        	Digit2Word obj = new Digit2Word();
            System.out.println("*** " + obj.convert(123456789));
            System.out.println("*** " + obj.convert(-55));
            System.out.println("*** " + obj.convert(-123456789));
            System.out.println("*** " + obj.convert(0));
        }
    }
