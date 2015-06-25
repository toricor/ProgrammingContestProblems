# coding: utf-8
import string
s = raw_input()
ans = set()
tmp = ""
for i in range(len(s)+1):
    for j in string.ascii_lowercase:
        tmp = list(s)
        tmp.insert(i, j)
        ans.add(tuple(tmp))
print len(ans)
