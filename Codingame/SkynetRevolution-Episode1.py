import sys
import math

#python 3

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

# n: the total number of nodes in the level, including the gateways
# l: the number of links
# e: the number of exit gateways
def make_nodes_dic(l, inp): # nodes inputted
    dic = {}
    for i in range(l):
        key, val = inp[i][0], inp[i][1]
        if key in dic: dic[key].append(val)
        else:          dic[key] = [val]
        
        key, val = inp[i][1], inp[i][0]
        if key in dic: dic[key].append(val)
        else:          dic[key] = [val]
            
    return dic
    
def update_nodes(ans, nodes):
    start, end = ans.split(" ")
    
    a = [str(i) for i in nodes[int(start)]]
    a.pop(a.index(end))
    b = [int(i) for i in a]
    nodes[int(start)] = b
    
    start, end = end, start
    
    a = [str(i) for i in nodes[int(start)]]
    a.pop(a.index(end))
    b = [int(i) for i in a]
    nodes[int(start)] = b
    return nodes

def bfs(agent_position, goal, nodes):
    """calculating steps between the agent and the node"""
    output_string = "0 1"
    que = [(nodes[agent_position][i], agent_position) for i in range(len(nodes[agent_position]))]
    step_item_count = len(nodes[agent_position])
    step = 1
    visited = []
    counting_flag = True
    while que:
        if not counting_flag:
            step_item_count = len(que)
            counting_flag = True
        item_tuple = que.pop(0)
        item = item_tuple[0]
        #print(str(item) + " " + str(step))
        step_item_count -= 1
        if step_item_count == 0:
            step += 1
            counting_flag = False

        if item in visited:
            continue
    
        if item == goal:
            #print("goal " + str(item) +" step:" + str(step),file=sys.stderr)
            break
        visited.append(item)
        que = que + [(nodes[item][i], item) for i in range(len(nodes[item]))]
    
    output_string = str(item_tuple[0]) + " " + str(item_tuple[1])
    return (output_string, step)

def calc(agent_position, gateways, nodes):
    ret = "-1 -1"
    step = 2**31 - 1
    for gate in gateways:
        temp_ret, temp_step = bfs(agent_position, gate, nodes)
        if temp_step <= step:
            ret = temp_ret
            step = temp_step
        
    return ret

n, l, e = [int(i) for i in input().split()]
inp = []
for i in range(l):
    # n1: N1 and N2 defines a link between these nodes
    n1, n2 = [int(j) for j in input().split()]
    inp.append((n1, n2))

gateways = []
for i in range(e):
    ei = int(input())  # the index of a gateway node
    gateways.append(ei)

nodes = make_nodes_dic(l, inp)
# game loop
while True:
    agent_position = int(input())  # The index of the node on which the Skynet agent is positioned this turn
    #print("agent: " + str(agent_position) + " " + str(gateways) + " " +  str(nodes), file=sys.stderr)
    # Write an action using print
    # To debug: print("Debug messages...", file=sys.stderr)
    ans = calc(agent_position, gateways, nodes)
    print(ans)
    nodes = update_nodes(ans, nodes)
