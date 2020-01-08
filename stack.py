# 연결 리스트를 이용한 Stack 구현
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Stack:
    def __init__(self):
        self.head = None

    def is_empty(self):
        if self.head:
            return False
        return True

    def push(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def pop(self):
        if self.is_empty():
            return -1;
        data = self.head.data
        self.head = self.head.next
        return data

    def peek(self):
        if self.is_empty():
            return -1
        return self.head.data


# 백준 1874번 스택 수열 문제
if __name__ == "__main__":
    s = Stack()

    num = []    # 입력
    output = [] # 출력
    n = int(input())

    # 입력받아 리스트에 저장
    for i in range(n):
        x = int(input())
        num.append(x)

    c = 0    # 베열 idx
    i = 1    # 스택 숫자
    cnt = 0  # push pop 횟수

    # push 와 pop 갯수의 합은 2*n 개
    while cnt < (2 * n):
        if s.is_empty():    # 비어있으면 push
            output.append('+')
            s.push(i)
            i += 1

        else:
            if s.peek() != num[c]:  # 숫자가 다르면 push
                output.append('+')
                s.push(i)
                i += 1

            elif s.peek() == num[c]:    # 숫자가 같으면 pop
                output.append('-')
                s.pop()
                c += 1

        cnt += 1    # 횟수 +

    # 스택이 비었으면 계산 가능
    if s.is_empty():
        for j in output:
            print(j)
    # 스택에 숫자가 남아있으면 계산 불가능
    else:
        print("NO")
