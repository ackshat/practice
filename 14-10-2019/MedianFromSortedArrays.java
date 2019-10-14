
public class MedianFromSortedArrays{
  
  public static int median(int arr1[], int s1, int e1, int[] arr2, int s2, int e2){
  
  if(e1<s1 || e2<s2) return -1;
  
  if(e1-s1+1 + e2-s2+1 <=4){
    int[] a = new int[e1-s1+1 + e2-s2+1];
    int i = s1, j=s2, k=0;
    while(i<=e1 || j<=e2){
      if(arr1[i]<arr2[j]){
        a[k++]=arr1[i++];
      }
      else{
        a[k++] = arr2[j++];
      }
    }
    return med(a, 0, a.length-1);
  }
  
  int mid1 = med(arr1, s1,e1);
  int mid2 = med(arr2, s2,e2);
  
  if(mid1==mid2) return mid1;
  
  if(mid1>mid2){
      return median(arr1, s1, s1+(e1-s1+1)/2, arr2 , s2+(e2-s1+1)/2, e2);
  }
  else{
    return median(arr1,s1+(e1-s1+1)/2,e1, arr2 , s2, (e2-s1+1)/2);
  }
  
  
  }
  
  public static int med(int a[], int s, int e){
  
   return (e-s+1)%2==0 ? (a[s+(e-s+1)/2]+a[s+(e-s+1)/2-1])/2 : a[s+(e-s+1)/2];
  
  }
  
  public static void main(String[] args) {
	int a1[] = {2,3,4,5,6,7,8,9};
	int a2[] = {3,4,5,10,11,12};
	
	System.out.println(median(a1, 0, a1.length-1, a2, 0, a2.length-1));
	
	//2,3,3,4,4,5,6,7,8,9,10,11,12
	
	
}
  
  
  
}
