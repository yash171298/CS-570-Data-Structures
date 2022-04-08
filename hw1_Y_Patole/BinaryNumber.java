//Name: Yash Avinash Patole
//CWID:10460520
//Course: CS 570 B


import java.util.*; 
import java.util.Arrays;
public class BinaryNumber {
	private int data[];
	//initialiazation of ocerflow.
	private boolean overflow;
	
	//constructor BinaryNumber(int length) for creating a binary number of length
	
	public BinaryNumber(int length) {
		if(length < 0) {
			System.out.println("Not a valid input.");
		}
		data = new int[length];
		for(int i=0; i<length; i++) {
			data[i]=0;
		}
	}
	
	//constructor BinaryNumber(String str) for creating a binary number given a string.
	
	public BinaryNumber(String str) {
		int x = str.length();
		boolean flag = true;
		data = new int[x];
		for (int i =0; i < x; i++) {
			if(str.charAt(i) != '0' && str.charAt(i) != '1') {
				flag = false;
				System.out.println("The given input is not a binary number");
				break;
			}
		}
		if(flag == true) {
		for(int j = 0; j < x; j++) {
			if(str.charAt(j) == '0') {
				data[j] = 0;
			}
			else {
				data[j] = 1;
			}
		}
		}
	}
	
	//operation int getLength() for determining the length of a binary number
	public int getLength() {
		int count = 0;
		for(int i=0; i<data.length; i++) {
			count++;
		}
		return count;
	}
	
	//operation for obtaining a digit of a binary number given an index.
	
	public int getDigit(int index) {
		if(index> data.length) {
			System.out.println("The given input is out of bounds enter a valid input");
			System.exit(1);
			return 0;
		}
		else {
			return data[index];
		}
	}
	
	
//	operation  for shifting all digits in a binary number
	public void shiftR(int amount) {
		if(amount < 0) {
			System.out.println("The entered input is incorrect.");
		}
		BinaryNumber reallocate = new BinaryNumber(data.length + amount);
		for (int i = amount; i < reallocate.getLength(); i++) {
			reallocate.data[i] = data[i - amount];
		}
		this.data = reallocate.data;
	}
	
//	operation for adding two binary numbers.
	public void add(BinaryNumber aBinaryNumber) {
	   
		int number[] = new int[aBinaryNumber.getLength()];
		int addition[] = new int[data.length];
		int carry = 0;
		
		if(data.length != number.length) {
			System.out.println("The lengths of the given two binary numbers do not coincide.");
			
		}		
		else {
			for(int i=0;  i< data.length; i++) {
				int x = carry + data[i] + aBinaryNumber.getDigit(i);
				if(x == 0) {
					addition[i] = 0;
					carry = 0;
				}
				if(x == 1) {
					addition[i] = 1;
					carry = 0;
				}
				if(x == 2) {
					addition[i] = 0;
					carry = 1;
				}
				if(x == 3) {
					addition[i]= 1;
					carry = 1;
				}
				
				
			}
			data = addition;
			System.out.println("Addition of 2 binary number is = " + toString());
		}
		if(carry == 1) {
			overflow = true;
		}
		
	}
	
//	converting the binary number to string
	public String toString(){
		if(overflow) {
			return "Overflow";
		}
		else {
			String y ="";
			for(int i = 0; i<data.length; ++i) {
				y += data[i];
			}
			
			return y;
		}
	}
	
	// operation for transforming a binary number
	public int toDecimal() {
		int x = 0;
		
		
		for(int i=0; i < data.length; i++) {
			x= (int)(x + data[i] * Math.pow(2, i));
			
		}
		return x;
	}
	
//	operation to reset the overflow
	public void clearOverflow() {
		overflow = false;
		System.out.println("Overflow is reset");
	}

	public static void main(String args[]) {
		BinaryNumber binary1 = new BinaryNumber("01000");
		BinaryNumber binary2 = new BinaryNumber("01001");
		BinaryNumber binary3 = new BinaryNumber("10110");
		BinaryNumber binary4 = new BinaryNumber("10000");
		
		System.out.println("The length of the given binary number is " + binary2.getLength());
		binary4.shiftR(3);
		System.out.println("Binary number after shifting R times is = "+binary4.toString());
		
		binary1.add(binary3);
		
	   
		System.out.println("Decimal value of given Binay number is = " + binary3.toDecimal());
		System.out.println("The digit in that index place is = " + binary2.getDigit(4));
		
		BinaryNumber newnumber = new BinaryNumber(5);
		System.out.println("new binary number is = "+newnumber);
		binary2.clearOverflow();
		
	}
}

//
//private int data[]
//private boolean overflow
//public BinaryNumber(int length)
//public BinaryNumber(String str)
//public int getLength()
//public int getDigit(int index)
//public void shiftR(int amount)
//public void add(BinaryNumber aBinaryNumber)
//public String toString()
//public int toDecimal()
//public void clearOverflow()