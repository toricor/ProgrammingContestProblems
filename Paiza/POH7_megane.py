# coding: utf-8
def mk_subarray(ref, pat, x, y):
    n = len(ref)
    m = len(pat)
    arr = [[] for i in xrange(m)]
    for i in xrange(m):
        arr[i] = ref[y+i][x: x+m]
    return arr

if __name__ == "__main__":
    n = int(raw_input())
    ref = []
    for i in range(n):
        ref.append(map(int, raw_input().split()))
    m = int(raw_input())
    pat = []
    for i in range(m):
        pat.append(map(int, raw_input().split()))
    
    for y in xrange(n):
        if y + m > n:
            break
        for x in xrange(n):
            if x + m > n:
                break
            arr = mk_subarray(ref, pat, x, y)
            if arr == pat:
                print "{0} {1}".format(y, x)
                break
