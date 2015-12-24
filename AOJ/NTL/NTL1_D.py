def prime_decomposition(n):
    i = 2
    table = []
    while i * i <= n:
        while n % i == 0:
            n /= i
            table.append(i)
        i += 1
    if n > 1:
        table.append(n)
    return table
 
def phi_pk(p,k):
    return (p-1)*p**(k-1)
 
def pkcounter(ls):
    dic={}
    for i in ls:
        dic[i]=dic.get(i,0)
        dic[i]+=1
    return dic
 
n = int(raw_input())
table = prime_decomposition(n)
dic = pkcounter(table)
ans=1
for k,v in dic.items():
    ans *= phi_pk(k,v)
print ans
