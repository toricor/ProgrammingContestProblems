def pos(x,n,M):
    if n==0:
        return 1
    res = pos(x*x%M, n /2, M)
    if n%2 ==1:
        res = res * x%M
    return res
  
m,n = map(int,raw_input().split())
  
print pos(m,n,1000000007)
