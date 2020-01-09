import java.util.*;

// �迭�� �̿��� Stack ����
class Stack{
	private int top;
	private int Size;
	private Object stackArr[];
	
	// ���� ������
	public Stack(int size) {
		this.top = -1;
		this.Size = size;
		this.stackArr = new Object[size];
	}
	
	// ������ ������� Ȯ��
	public boolean empty() {
		return (top == -1);
	}
	
	// ������ ��á���� üũ
	public boolean full() {
		return(top == Size-1);
	}
	
	//���ÿ� item �Է�
	public void push(Object item) {
		if(full())
			throw new ArrayIndexOutOfBoundsException((top+1)+">="+Size);
		
		stackArr[++top]= item;
	}
	
	//������ ���� ���� ������ ��ȯ
	public Object peek() {
		if(empty()) return 0;
		
		return stackArr[top];
	}
	
	//������ ���� ���� ������ ����
	public Object pop() {
		Object item = peek();
		
		top--;
		
		return item;
	}
}

// ���� 1874�� ���� ���� ����
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack st = new Stack(n);
		

		// �Է� �迭
		int input[] = new int[n]; 
		// ��� �迭
		char output[] = new char[2*n];
		
		for(int i=0; i<n; ++i)
			input[i] = sc.nextInt();
		
		// output �迭 �ε���
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
		// ��갡��
		if(st.empty()) {
			for(int i=0; i<2*n; i++)
				System.out.println(output[i]);
		}
		// ��� �Ұ���
		else
			System.out.println("NO");
	}
	
}
