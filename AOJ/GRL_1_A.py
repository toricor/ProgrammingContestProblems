# coding: utf-8
from heapq import heappush, heappop

class Node:
    def __init__(self, name):
        self.name = name
        self.edges_to = []
        self.edges_cost = []
        self.done = False
        self.cost = -1

if __name__ == "__main__":
    # set a graph
    V, E, r = map(int, raw_input().split())
    nodes = []
    for i in xrange(V):         # V個のNodeを初期化
        nodes.append(Node(i)) 
    
    for i in xrange(E):
        s, t, d = map(int, raw_input().split())
        nodes[s].edges_to.append(t)
        nodes[s].edges_cost.append(d)
    
    # dijkstra by priority queue(heapq)
    hq = []
    nodes[r].cost = 0           #始点rのコストは0
    nodes[r].done = True  
    heappush(hq, nodes[r])
    
    while len(hq)!= 0:          # rから各点への最短経路上の重みの和を求める。
        done_node = heappop(hq)
        done_node.done = True
        for to, cost in zip(done_node.edges_to, done_node.edges_cost):
            new_cost = done_node.cost + cost
            if nodes[to].cost < 0 or new_cost < nodes[to].cost:
                nodes[to].cost = new_cost
                if nodes[to] not in hq:
                    heappush(hq, nodes[to])
            
    for item in nodes:
        if item.cost == -1:
            print "INF"
        else:
            print item.cost
    
    
