# coding: utf-8
n,m = map(int,raw_input().split())
arr = []
for i in range(n):
    arr.append(raw_input())
count = 0
face = set(("f","a","c","e"))
for i in range(n-1):
    for j in range(m-1):
        se = set((arr[i][j],
        arr[i][j+1],
        arr[i+1][j],
        arr[i+1][j+1]))
        if face == se:
            count += 1
print count
