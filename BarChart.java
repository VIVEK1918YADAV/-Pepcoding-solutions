package xyz;

import java.util.Scanner;

public class Barchart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
		    int n=s.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<arr.length;i++)
		    {
		        arr[i]=s.nextInt();
		    }
		    int max=arr[0];
		    for(int i=1;i<arr.length;i++)
		    {
		        if(arr[i]>max)
		          max=arr[i];
		    }
		    for(int floor=max;floor>=1;floor--)
		    {
		        for(int i=0;i<arr.length;i++)
		        {
		            if(arr[i]>=floor){
		            System.out.print("*\t");
		             }  else
		           { System.out.print("\t");
		             }     }
		        System.out.println();
		        
		    }

	}

}
