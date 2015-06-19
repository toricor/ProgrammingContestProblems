# coding: utf-8
while True:
    try:
        n = int(raw_input())
    except EOFError:
        break
    dig = len(str(n))
    if dig == 1:
        print n
    elif dig == 2:
        print 9 + 2 * (n - 10 + 1)
    elif dig > 2:
        total = 9
        d = dig
        while d > 2:
            total += (d - 1) * 9 * 10 **(d -2)
            d = d - 1
        total += dig * (n - 10**(dig-1) + 1)
        print total
