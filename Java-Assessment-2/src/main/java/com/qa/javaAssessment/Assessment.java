package com.qa.javaAssessment;

import java.util.Locale;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public static String getBert(String input) {
	
		String word = "bert";
		
		int firstIndex;
		int lastIndex;
		
		input = input.toLowerCase(Locale.UK);
		word = word.toLowerCase(Locale.UK);
		
		
		firstIndex = input.indexOf(word);
		lastIndex = input.lastIndexOf(word);
		if (firstIndex == lastIndex) {
			return "";
		}
		else {
			input = input.substring(firstIndex + 4, lastIndex);
			
            byte [] strAsByteArray = input.getBytes(); 
            byte [] result =  
                       new byte [strAsByteArray.length]; 
   
            for (int i = 0; i<strAsByteArray.length; i++) 
                result[i] =  
                 strAsByteArray[strAsByteArray.length-i-1];
            
            input = new String(result); 
			
		}
		
		
		/*
		if (input.contains(word)) { 
			
           // String temp = word + " "; 
            input = input.replaceAll(word, "&"); 
  
           // temp = " " + word; 
            input = input.replaceAll(word, "&"); 
            
            
            
            for (int i = 0; i < input.length(); i++){
            	//int [] count = new int[1];
            	
    		    char c = input.charAt(i);        
    		    if (c == '&') {
    		    	input = input.substring(i + 1);
    		    	break;
    		    }
    		    	
    		}
            
            // getBytes() method to convert string  
            // into bytes[]. 
            byte [] strAsByteArray = input.getBytes(); 
      
            byte [] result =  
                       new byte [strAsByteArray.length]; 
      
            // Store result in reverse order into the 
            // result byte[] 
            for (int i = 0; i<strAsByteArray.length; i++) 
                result[i] =  
                 strAsByteArray[strAsByteArray.length-i-1];
            
            input = new String(result); 
            
            
            for (int i = 0; i < input.length(); i++){
            	int [] count = new int[1];
            	
    		    char c = input.charAt(i);        
    		    if (c == '&') {
    		    	input = input.substring(i + 1);
    		    	break;
    		    }
    		    	
    		}
            
        } 
        */
		System.out.println(input);
		System.out.println(firstIndex);
		System.out.println(lastIndex);
		
		
		return input;
	}
	public static void main(String[] args) {
	
		//getBert("xxBertfridgebERtyy");
		/*
		evenlySpaced(4, 60, 9);
		superBlock("hoopplla");
		fizzBuzz(3);
		*/
		//largest("555 72 86 45 10");
		//nMid("Chocolate", 1);
		amISearch("I have been in Amsterdam");
	}
	

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public static boolean evenlySpaced(int a, int b, int c) {
		boolean result;
		int hold1 = a - b;
		int hold2 = b - c;
		
		if (hold1 % 2 == 0 & hold2 % 2 == 0)
			result = true;
		else
			result = false;
		
		System.out.println(result);
		return result;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public static String nMid(String input, int a) {
		
		for (int i = 0; i < a; i++){
			int mid = input.length()/2;
		input = input.substring(0, mid) + input.substring(mid + 1);
		}
		
		return input;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public static int superBlock(String input) {
		 char temp = '&';
	     int count = 0;
	     int maxCount = 0;
		
		 for (int i = 0; i < input.length(); i++){
 		    char c = input.charAt(i);
 		    
 		    if (temp == c) {
 		    	count++;
 		    }
 		    else {
 		    	temp = c;
 		    	if (count > maxCount)
 		    		maxCount = count;
 		    	count = 0;
 		    	
 		    }
 		    	
 		}
		 if (maxCount != 0)
			 maxCount++;
		
		System.out.println(maxCount);
		 
		return maxCount;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public static int amISearch(String arg1) {
		arg1 = arg1.toLowerCase(Locale.UK);
		
		String[] splitStr = arg1.split("\\s+");
		int count = 0;
		
		for (String result : splitStr) {
			if (result.equals("am")) {
				count += 1;
			}
		}

		
		System.out.println(count);
		return count;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public static String fizzBuzz(int arg1) {
		String result = null;
		
		
		if (arg1 % 3 == 0 & arg1 % 5 == 0 )
			result = "fizzbuzz";
		
		else if (arg1 % 3 == 0)
			result = "fizz";
		
		else if (arg1 % 5 == 0)
			result = "buzz";
		
		
		System.out.println(result);
		return result;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public static int largest(String arg1) {
		int temp;
		int addNum = 0;
		int maxTotal = 0;
		String[] char1 = null;
		String[] splitNum = arg1.split("\\s+");
		
		for (int i = 0; i < splitNum.length; i++){
			temp = splitNum[i].length();
			
 		    char1 = splitNum[i].split("");    
 		    
 		   for (int x = 0; x < char1.length; x++ ){
	            if (temp == 2 & x < char1.length - 1 ) {
	            	addNum = Integer.parseInt(char1[x]) + Integer.parseInt(char1[x+1]);
	 		    	System.out.println("2 num:  " + addNum);
	 		    	if (addNum > maxTotal)
	 		    		maxTotal = addNum;
	 		    }
	            else if (temp == 3 & x < char1.length - 2 ) {
	            	addNum = Integer.parseInt(char1[x]) + Integer.parseInt(char1[x+1]) + Integer.parseInt(char1[x+2]);
	            	System.out.println("3 num: " + addNum);
	 		    	if (addNum > maxTotal)
	 		    		maxTotal = addNum;
	            }
	        }
		}
		    
		System.out.println(maxTotal);
		
		return maxTotal;
	}
}
