n = int(raw_input())
ls = []
for i in xrange(n):
    key = int(raw_input())
    ls.append(key)
dic = {}
for k,v in enumerate(sorted(list(set(ls)))):
    dic[v] = k 
for i in ls:
    print dic[i]
