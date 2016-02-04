# coding: utf-8
H = int(raw_input())
A = map(int,raw_input().split())

for i in range(H):
    parent_key = ""; left_key = ""; right_key = ""; ans = ""
    
    if i > 0:            parent_key = "parent key = " + str(A[(i+1)/2-1]) + ", "
    if 2*(i+1) - 1 < H:  left_key = "left key = " + str(A[2*(i+1)-1])  +", "
    if 2*(i+1) < H:      right_key= "right key = " + str(A[2*(i+1)]) + ", "
    
    ans = "node " +str(i + 1) + ": key = "+ str(A[i]) + ", " + parent_key + left_key + right_key
    print ans
