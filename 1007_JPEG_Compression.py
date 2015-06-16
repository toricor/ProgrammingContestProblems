# coding: utf-8
case = 1
while True:
    N = int(raw_input())
    if N == 0: break
    mat = [[0 for i in xrange(N)] for j in xrange(N)]
    n = 1
    for i in xrange(N): # upper half
        for j in reversed(xrange(i+1)):
            if i%2==0:
                mat[j][i-j] = n
                n += 1
            elif i%2==1:
                mat[i-j][j] = n
                n += 1
                  
    for i in xrange(N,2*N-1): # lower half
        for j in reversed(xrange(i-N+1,N)):
            if i%2==0:
                mat[j][i-j] = n
                n += 1
            elif i%2==1:
                mat[i-j][j] = n
                n += 1
    print 'Case %d:'%(case); case += 1
    for s in mat:
        print ''.join(map(str,[str(st).rjust(3) for st in s]))
