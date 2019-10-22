package dsalgo;

import java.util.Arrays;

public class KLargestElements {

  public static void main(String args[]){
    int[] a = new int[]{2,8,16,17,8,15,14,9};
    System.out.println(Arrays.toString(a)+"\n");
	 int k =  kLargest(a,4);
	 
	  for(int i = k;i< a.length;i++) {
		  System.out.print(a[i] + ", ");
	  }
	  System.out.println("\n"+Arrays.toString(a));
  }
  
  public static int kLargest(int a[], int k){
    return kLargestUsingPartition(a,k,0,a.length-1);
  }

  
  public static int kLargestUsingPartition(int a[], int k, int lo, int hi){
  
    int pivot = hi;
    
    if(lo<hi){ 
      int left = lo;
      int right = hi-1;
      while(left<right){
        while(a[left]<a[pivot]) left++;
        while(a[right]>a[pivot]) right--;
        swap(a,left++,right--);
      }
      if(left<pivot) {
       swap(a,left,pivot);
      }
      
      if(k==hi-left+1)return left+1;
      
      if(k<hi-left+1){
    	  pivot = kLargestUsingPartition(a,  k,left+1, hi);
        
      }
      else{
    	  pivot = kLargestUsingPartition(a,  k,lo, left);
      }
      
      
    }
    
    return pivot;
  }
  
  public static void swap(int a[], int i, int j){
    int t = a[i];
    a[i]=a[j];
    a[j]=t;
  }
  
}
