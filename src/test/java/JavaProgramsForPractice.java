import java.util.TreeSet;

import org.testng.annotations.Test;

public class JavaProgramsForPractice {
	
	@Test
	public void reverseAString() {
		String s="my name is smruti";
		String reverse="";
		for (int i = s.length()-1; i>=0; i--) {
			reverse=reverse+s.charAt(i);
		}
		System.out.println(reverse);
	}
	
	@Test
	public void removeDuplicates() {
		String s="tester is is good good";
		TreeSet<Character> set= new TreeSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
			
		}
		System.out.println(set);
	}
	
	@Test
	public void removeDuplicatesFromArray() {
		int a[]= {1,2,3,4,1,2,3,4,6,7};
		TreeSet<Integer> set= new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
			
		}
		System.out.println(set);
	}
	
	@Test
	public void descendArray() {
		int a[]= {1,2,3,4,1,2,3,4,6,7};
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]<a[j]) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
							
			}
			System.out.println(a[i]);
			
		}
	}
	
	@Test
	public void asecdArray() {
		int a[]= {1,2,3,4,1,2,3,4,6,7};
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j]) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
							
			}
			System.out.println(a[i]);
			
		}
		
	}
	
	@Test
	public void printOneDimensionalArray() {
//		int[] a=new int[3];//declaration   
//		a[0]=10;//initialization  
//		a[1]=20;  
//		a[2]=30;  
		int a[]= {10,20,30};
		//printing array  
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	@Test
	public void printTwoDimensionalArray() {
	
		int[][] a={{10,20},{30,40},{50,60}};//declaration and initialization   
		   
		for (int i = 0; i < 3; i++) 
		{
	            for (int j = 0; j < 2; j++) 
		    {
	                System.out.print(a[i][j]+" ");
	            }
	            System.out.println();
		}
	}
 
	@Test
	public void reverseAnArray() {
		int arr[]= {10,20,30};
		 for (int i = arr.length-1; i >= 0; i--) {  
	            System.out.print(arr[i] + " ");  
	        }  
	}
	
	

}
