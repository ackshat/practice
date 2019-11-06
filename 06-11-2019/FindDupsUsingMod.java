public class FindDupsUsingMod{
	
public static void printDups(int arr[]. int n){

	// the value of element sin the array lie between the range 0 to n-1
	for(int i=0;i<n;i++){
		arr[arr[i]% (n+1)]+=n+1;

}
	for(int i=0;i<n;i++){
	if(arr[i]>n+1+n)
	System.out.println(i+ " ");
}	

}



}
