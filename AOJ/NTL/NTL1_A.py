def prime_decomposition(n):
    '''ref. by cocodrips'''
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

n = int(raw_input())
print str(n) + ': '+ ' '.join(map(str,prime_decomposition(n)))
