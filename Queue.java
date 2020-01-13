import java.util.*;

class Queue{
	private int front;
	private int back;
	private Object queue[];
	
	public Queue(int size) {
		this.front = 0;
		this.back = -1;
		this.queue = new Object[size];
	}
	
	public void push(Object item) {
		queue[++back] = item;
	}
	
	public Object pop() {
		if(empty())
			return -1;
		Object item = queue[front];
		front++;
		return item;
	}
	
	public int Size() {
		return this.back - this.front + 1;
	}
	
	public boolean empty() {
		if(Size() == 0)
			return true;
		return false;
	}
	
	public Object Front() {
		if(empty())
			return -1;
		return this.queue[this.front];
	}
	
	public Object Back() {
		if(empty())
			return -1;
		return this.queue[this.back];
	}

	
}


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue qu = new Queue(n);
		
		for(int i =0; i<n; i++) {
			String x = sc.next();
			if(x.equals("push")) {
				int item = sc.nextInt();
				qu.push(item);
			}
			else if(x.equals("pop")) {
				System.out.println(qu.pop());
				
			}
			else if(x.equals("size")) {
				System.out.println(qu.Size());
			}
			else if(x.equals("empty")) {
				if(qu.empty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(x.equals("front")) {
				System.out.println(qu.Front());
			}
			else if(x.equals("back")) {
				System.out.println(qu.Back());
			}
			
			
		}

		
		sc.close();
	}
	
}

