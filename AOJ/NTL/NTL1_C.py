def gcd(m,n):  
    while m % n > 0:
        m, n = n, m % n
    else:
        return n
         
def gen_lcm_list(a):
    '''return a shorter list'''
    b = []
    for i in range(len(a) - 1):
        b.append(a[i] * a[i+1] / gcd(a[i], a[i+1]))
    return b
 
n = int(raw_input())
a = map(int,raw_input().split())
while len(a) > 1:
    a = gen_lcm_list(a)
print a[0]
