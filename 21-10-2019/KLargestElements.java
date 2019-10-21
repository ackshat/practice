
public class KLargestElements{
  public static void main(String args[]){
    
    kLargest(new int[]{2,8,16,17,8,15,14,9},4);
  }
  public static int[] kLargest(int a[], int k){
    System.out.println(kLargestUsingPartition(a,k,0,a.length-1));
  }

  
  public static int kLargestUsingPartition(int a[], int k, int lo, int hi){
  
    int pivot = hi;
    
    if(lo<hi){ 
      int left = lo;
      int right = hi;
      while(left<right){
        while(a[left]<a[pivot]) left++;
        while(a[right]>a[pivot]) right--;
        swap(a,left,right);
      }
       swap(a,left,pivot);
      
      if(k==left+1)return left+1;
      
      if(K<left+1){
        pivot = kLargestUsingPartition(a[],  k,lo, left);{
      }
      else{
         pivot = kLargestUsingPartition(a[],  k,left+1, hi);
      }
      
      
    }
    
    return pivot;
  }
  
  public static swap(int a[], int i, int j){
    int t = a[i];
    a[i]=a[j];
    a[j]=t;
  }
  
}
