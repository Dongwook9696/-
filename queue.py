#  리스트를 이용한 Queue 구현
import sys

class Queue:
    def __init__(self):
        self.queue = []
        self.front = 0
        self.back = -1

    def insert(self, data):
        self.back += 1
        self.queue.append(data)

        return None

    def remove(self):
        if self.isEmpty():
            return -1

        else:
            result = self.queue[self.front]
            self.front += 1
            return result

    def isEmpty(self):
        return self.back < self.front

    def size(self):
        return self.back + 1 - self.front

    def Front(self):
        return self.queue[self.front]

    def Back(self):
        return self.queue[self.back]


if __name__ == "__main__":
    q = Queue()
    n = int(sys.stdin.readline())

    for i in range(n):
        x = sys.stdin.readline().split()

        if "push" == x[0]:
            idx = int(x[1])
            q.insert(idx)
        elif "pop" == x[0]:
            print(q.remove())
        elif "size" == x[0]:
            print(q.size())
        elif "empty" == x[0]:
            if q.isEmpty():
                print(1)
            else :
                print(0)
        elif "front" == x[0]:
            if q.isEmpty():
                print(-1)
            else:
                print(q.Front())
        elif "back" == x[0]:
            if q.isEmpty():
                print(-1)
            else:
                print(q.Back())
