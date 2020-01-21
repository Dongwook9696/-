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
		
		quickSort(arr, 0, cnt-1);
		
		int result=0;
		for(int i=cnt-1; i>=0; i--){
			result = result*10 + arr[i];
		}
		System.out.println(result);
		sc.close();
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) { 
			// 원소가 1개인 경우 
			return ; 
		}
		int pivot = left;
		int start = pivot +1;
		int end = right;
		int temp;
		
		while(start<end) {

			while(arr[pivot]>arr[start] && (start<=right)) {
				start++;
			}
			while(arr[pivot]<arr[end] && (end>=pivot)) {
				end--;
			}
			if(start<end) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;

			}else {
				temp = arr[pivot];
				arr[pivot] = arr[end];
				arr[end] = temp;
			}
			
		}

		quickSort(arr, left, end - 1); 
		quickSort(arr, end + 1, right);

	}
        
		
	
}