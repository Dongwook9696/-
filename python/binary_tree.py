class Node:
    def __init__(self, data):
        self.data = data;
        self.left = None;
        self.right = None;

    def __str__(self):
        return str(self.data)

class Tree:
    def __init__(self):
        self.root = None

    def makeRoot(self, node, left_node, right_node):
        if self.root == None:
            self.root = node
        node.left = left_node
        node.right = right_node

    def preorderTrabersal(self, node):
        print(node, end='')
        if not node.left == None : self.preorderTrabersal(node.left)
        if not node.right == None : self.preorderTrabersal(node.right)

    def inorderTrabersal(self, node):
        if not node.left == None : self.inorderTrabersal(node.left)
        print(node, end='')
        if not node.right == None : self.inorderTrabersal(node.right)

    def postorderTrabersal(self, node):
        if not node.left == None : self.postorderTrabersal(node.left)
        if not node.right == None : self.postorderTrabersal(node.right)
        print(node, end='')


if __name__ == "__main__":
    n = int(input())
    btree = Tree()
    node = []

    for i in range(26):
        node.append(Node(chr(i+65)))

    for i in range(n):
        temp = input()
        point = node[ord(temp[0])-65]
        point_left = None
        point_right = None

        if not temp[2] == '.':
            point_left = node[ord(temp[2]) - 65]

        if not temp[4] == '.':
            point_right = node[ord(temp[4]) - 65]

        btree.makeRoot(point, point_left, point_right)

    print(node)
    btree.preorderTrabersal(btree.root)
    print()
    btree.inorderTrabersal(btree.root)
    print()
    btree.postorderTrabersal(btree.root)