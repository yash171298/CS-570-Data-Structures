//Name: Yash Avinash Patole
//CWID: 10460520

//Course: CS570

package HomeworkAssignment2;

public class Complexity {
	

	
	public static void method1(int n) {
		int counter = 0;
		for (int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				System.out.println("Operation 1 O(n^2): "+counter); 
				counter++;
			}
		}
		System.out.println("The time complexity of operation O(n^2) equals = "+counter);
	}
	
	public static void method2(int n) {
		int counter = 0;
		for(int i=0; i<n; i++) {
			for(int k = 0 ; k<n ; k++) {
				for(int x = 0; x<n; x++) {
					System.out.println("Operation 2 O(n^3): "+counter); 
					counter++;
				}
			}
		}
		System.out.println("The time complexity of operation O(n^3) equals = "+counter);
		
	}
	
	public static void method3(int n) {
		int counter = 0;
		int i;
		for (i = 1; i<n; i= i*2) {
			System.out.println("Operation 3 O(logn): "+counter); 
			counter++;
		}
		System.out.println("The time complexity of operation O(log n) equals = "+counter);
	}
	
	public static void method4(int n) {
		int counter = 0;
		int i;
		int k;
		for (i = 1; i<=n; i++) {
			for (k =1; k<n; k*=2) {
			System.out.println("Operation 4 (n logn): "+counter); 
			counter++;
		}
	}
		System.out.println("The time complexity of operation O(nlogn) equals = "+counter);
	}
	
	public static void method5(int n) {
		int counter = 0;
		int i;
		for (i = 2; i<n; i*=i) {
			System.out.println("Operation 5 O(log logn): "+counter); 
			counter++;
		}
		System.out.println("The time complexity of operation O(log logn) equals = "+counter);
	
	}
	
	private static int counter1 = 1;
	public static int method6(int n) {
		
		System.out.println("Operation 6 O(2^n): " +counter1); 
		counter1++;
		int x;
		if(n<=1) {
			return n;
		}
		else {
			
			x  = method6(n-1)+method6(n-1);
			return x;
		}
	
	}
	 
	 public static void main(String[] args) {
			System.out.println("Method1 is executed which has a complexity of O(n^2):");
			method1(5);
			System.out.println("Method1 is executed which has a complexity of O(n^3):");
	        method2(5);
	        System.out.println("Method1 is executed which has a complexity of O(logn):");
	        method3(16);
	        System.out.println("Method1 is executed which has a complexity of O(nlogn):");
	        method4(10);
	        System.out.println("Method1 is executed which has a complexity of O(log logn):");
	        method5(10);
	        System.out.println("Method1 is executed which has a complexity of O(2^n):");
	        method6(2);
	        
	 }

}
