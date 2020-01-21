import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int ns = n;
		int cnt=0;
		while(ns>0){
			ns/=10;
			
			cnt++;
		}
		
		int arr[] = new int[cnt];
		for( int i=0; i<cnt ; i++){
			arr[i] = n%10;
			n/=10;
		}
		
		mergeSort(arr, 0, cnt-1);
		
		int result=0;
		for(int i=cnt-1; i>=0; i--){
			result = result*10 + arr[i];
		}
		System.out.println(result);
		sc.close();
	}
	
	public static void merge(int arr[], int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int k = l;
		int temp[] = new int[arr.length];
		while(i<=mid && j<=r) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		while(i<=mid)
			temp[k++] = arr[i++];
		while(j<=r)
			temp[k++] = arr[j++];
		for(int index=l; index<k; index++)
			arr[index] = temp[index];
	}

	public static void mergeSort(int arr[], int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}


	
}