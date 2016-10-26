s = input().split()
d = {}
for inx, word in enumerate(s):
    if word in d:
        d[word][0] += 1
    else:
        d[word] = [1, inx]
for k, v in sorted(d.items(), key=lambda x: x[1][1]):
    print(k, v[0])
