# coding: utf-8
# Here your code !

from collections import deque 

class Node:
    def __init__(self):
        self.id = -1
        self.sibling = -1
        self.degree = -1
        self.depth = -1
        self.height = -1
        self.parent = -1
        self.left = -1
        self.right = -1
        self.type = 'root'
        
def find_root_id(nodes):
    for node in nodes:
        if node.parent == -1:
            return node.id
 
def set_depth(rootid, nodes):
    nodes[rootid].depth = 0
    depth = 0
    node = nodes[rootid]
    que = deque()
    que.append(node.left)
    que.append(node.right)
    ref = deque()
    ref.append(-1)
    ref.append(-1)
    if que == ref:
        node.depth = 0
        return 0
    for i in que:
        nodes[i].depth = depth + 1
    depth += 1
    
    while que:
        for i in xrange(len(que)):
            popped = que.popleft()
            l = nodes[popped].left
            r = nodes[popped].right
            if l != -1:
                que.append(nodes[popped].left)
            if r != -1:
                que.append(nodes[popped].right)
        for j in que:
            nodes[j].depth = depth + 1
        depth += 1
    return depth
        
def set_height(rootid, nodes, dep):
    if len(nodes) == 1:
        nodes[0].height=0
    for node in nodes:
        if node.type == 'leaf':
            node.height = 0
            
    while dep > 0:
        for node in nodes:
            if node.depth == dep:
                nodes[node.parent].height = max(nodes[nodes[node.parent].left].height, nodes[nodes[node.parent].right].height) + 1
        dep -= 1
    
def set_degree(nodes):
    for node in nodes:
        node.degree = sum([1 for i in [node.left, node.right] if i != -1])
        
def set_parent(nodes):
    for node in nodes:
        if node.left != -1:
            nodes[node.left].parent = node.id
        if node.right != -1:
            nodes[node.right].parent = node.id
            
def set_sibling(rootid, nodes):
    for node in nodes:
        if node.id != rootid:
            if nodes[node.parent].left == node.id:
                node.sibling = nodes[node.parent].right
            elif nodes[node.parent].right == node.id:
                node.sibling = nodes[node.parent].left
        else:
            pass#root has no sibling
        
def set_type(nodes):
    for node in nodes:
        if node.left == -1 and node.right == -1:
            if node.parent != -1:
                node.type = 'leaf'
        else:
            if node.parent != -1:
                node.type = 'internal node'
    
n = int(raw_input())
nodes = []
for i in xrange(n):
    node = Node()
    ls =  map(int, raw_input().split())
    node.id = ls[0]
    node.left = ls[1]
    node.right = ls[2]
    nodes.append(node)
    
nodes = sorted(nodes, key=lambda node:node.id)

set_degree(nodes)
set_parent(nodes)
rootid = find_root_id(nodes)

set_type(nodes)
set_sibling(rootid, nodes)
dep = set_depth(rootid, nodes)
set_height(rootid, nodes, dep)
for node in nodes:
    print 'node %s: parent = %s, sibling = %s, degree = %s, depth = %s, height = %s, %s'%(node.id, node.parent, node.sibling, node.degree, node.depth, node.height, node.type)
