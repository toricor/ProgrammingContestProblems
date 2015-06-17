from collections import deque

while True:
    try:
        n,m = map(int,raw_input().split())
    except EOFError:
        break
    if (n, m) == (0, 0):
        break
        
    d = deque([i for i in range(1,1+n)])
    while len(d) > 1:
        d.rotate(-m + 1)
        d.popleft()
    print d[0]

    
