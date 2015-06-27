# coding: utf-8
n = int(raw_input())
gears = map(int,raw_input().split())
refans = [i for i in xrange(n)]
refnums = [i for i in xrange(n)]*2
tmpgears = list(gears)
for i in range(n):
    for j in range(n):
        if j%2 == 1:
            tmpgears[j] = refnums[n+tmpgears[j]-1]
        else:
            tmpgears[j] = refnums[tmpgears[j]+1]
    if tmpgears == refans:
        print "YES"
        break
else:
    print "NO"
