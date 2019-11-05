import java.util.*;

public class FindDupInConstantSpace{
	

	public static void printDups(int[] arr, int n){
		for(int i=0;i<n;i++){
			
			if(arr[Maths.abs(arr[i])] >=0){
				arr[arr[i]]= -arr[arr[i]];
			}
			else{
				System.out.println(Maths.abs(arr[i]));
			}
		}
	}


}
