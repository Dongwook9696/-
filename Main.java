import java.util.*;

// 배열을 이용한 Stack 구현
class Stack{
	private int top;
	private int Size;
	private Object stackArr[];
	
	// 스택 생성자
	public Stack(int size) {
		this.top = -1;
		this.Size = size;
		this.stackArr = new Object[size];
	}
	
	// 스택이 비었는지 확인
	public boolean empty() {
		return (top == -1);
	}
	
	// 스택이 꽉찼는지 체크
	public boolean full() {
		return(top == Size-1);
	}
	
	//스택에 item 입력
	public void push(Object item) {
		if(full())
			throw new ArrayIndexOutOfBoundsException((top+1)+">="+Size);
		
		stackArr[++top]= item;
	}
	
	//스택의 가장 위의 데이터 반환
	public Object peek() {
		if(empty()) return 0;
		
		return stackArr[top];
	}
	
	//스택의 가장 위의 데이터 제거
	public Object pop() {
		Object item = peek();
		
		top--;
		
		return item;
	}
}

// 백준 1874번 스택 수열 문제
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack st = new Stack(n);
		

		// 입력 배열
		int input[] = new int[n]; 
		// 출력 배열
		char output[] = new char[2*n];
		
		for(int i=0; i<n; ++i)
			input[i] = sc.nextInt();
		
		// output 배열 인덱스
		int idx = 0;
		
		for(int i=1, j=0; i<=n; ++i) {
			if(st.empty()) {
				st.push(i);
				output[idx++] = '+';
			}
			else if(!st.peek().equals(input[j])) {
				st.push(i);
				output[idx++] = '+';
			}

			while(st.peek().equals(input[j])) {
				st.pop();
				j++;
				output[idx++] = '-';
				if(st.empty())
					break;
			}
			
		}
		// 계산가능
		if(st.empty()) {
			for(int i=0; i<2*n; i++)
				System.out.println(output[i]);
		}
		// 계산 불가능
		else
			System.out.println("NO");
	}
	
}
