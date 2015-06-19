# coding: utf-8
n = int(raw_input())
a = map(int,raw_input().split())
ans = [1]*n
for i in range(n):
    ans[i] = 1 + sum([1 for num in a if num > a[i]])
print " ".join(map(str,ans))
