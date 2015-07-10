# coding: utf-8
from collections import deque 

class Node:
    def __init__(self):
        self.id = -1
        self.k = -1
        self.depth = -1
        self.parent = -1
        self.type = 'root'
        self.end = False
        self.children = []
        
def find_root_id(nodes):
    i = 0
    rootid = -1
    while nodes[i].parent != -1:
        nodes[i]
        i += 1
    else:
        rootid = nodes[i].id
        return rootid
        
def set_depth(rootid, nodes):
    que = deque()
    depth = 0
    node = nodes[rootid]
    que = deque(node.children)
    for i in que:
        nodes[i].depth = depth + 1
    depth += 1
    
    while que:
        for i in range(len(que)):
            for child in nodes[que.popleft()].children:
                que.append(child)
        for j in que:
            nodes[j].depth = depth + 1
        depth += 1

n = int(raw_input())
nodes = []
for i in range(n):
    node = Node()
    ls =  map(int, raw_input().split())
    node.id = ls[0]
    node.k = ls[1]
    if node.k == 0:
        pass
    else:
        node.children = ls[2:]
    nodes.append(node)
    
nodes = sorted(nodes, key=lambda node:node.id)
for node in nodes:
    for child in node.children:
        nodes[child].parent = node.id
        
for node in nodes:
    if node.children == []:
        if node.parent != -1:
            node.type = 'leaf'
    else:
        if node.parent != -1:
            node.type = 'internal node'

rootid = find_root_id(nodes)
nodes[rootid].depth = 0
set_depth(rootid, nodes)
for node in nodes:
    print 'node %s: parent = %s, depth = %s, %s, %s'%(node.id, node.parent, node.depth, node.type, node.children)
