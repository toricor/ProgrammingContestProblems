# coding: utf-8

n = int(raw_input())
array = []
for i in range(n):
    row = list(raw_input())
    array.append(row)

maxcnt = 0
for i in range(n):
    tmparray = list(array)
    for j in range(n): # reverse all bits in rows according to tmparray[i]
        if int(tmparray[i][j]) == 0: 
            for k in range(n):
                if int(tmparray[k][j]) == 1:
                    tmparray[k][j] = "0"
                else:
                    tmparray[k][j] = "1"
    tmpcnt = 0
    for s in range(n):
        for t in range(n):
            if int(tmparray[s][t]) == 0:
                break
        else:
            tmpcnt += 1
            
    if maxcnt < tmpcnt:
        maxcnt = tmpcnt
print maxcnt
