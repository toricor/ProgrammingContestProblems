# coding: utf-8
# TLE
import itertools
n = int(raw_input())
room = [[True if int(i) else False for i in raw_input()] for j in xrange(n)]

max_ = 0
ls = [i for i in xrange(n)]
for q in xrange(n):
    for col in itertools.product(ls, repeat=q):
        tmp = list(room)
        if len(col)!=0:
            for jj in col:
                for j in xrange(n):
                    if tmp[j][jj]:
                        tmp[j][jj]=0
                    else:
                        tmp[j][jj]=1
        tmpmax = 0
        for k in xrange(n):
            if sum([i for i in tmp[k]]) == n:
                tmpmax += 1
        if max_ < tmpmax:
            max_ = tmpmax
print max_
