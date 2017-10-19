# coding: utf-8
h, w = list(map(int, input().split()))
ls = [list(input()) for y in range(h)]
ls.append(list("." * w))
ls = [list("." * w)] + ls

for i in range(h + 2):
    ls[i].append(".")
    ls[i] = ["."] + ls[i]
ans = [[0 for x in range(w+2)] for y in range(h+2)]

for y in range(1, h+1):
    for x in range(1, w+1):
        if ls[y][x] == "#":
            ans[y][x] = "#"
        else:
            ans[y][x] = [ls[y-1][x-1], ls[y-1][x], ls[y-1][x+1], ls[y][x-1], ls[y][x+1], ls[y+1][x-1], ls[y+1][x], ls[y+1][x+1]].count("#")
print(ans)

for i in range(1, h+1):
    print(''.join(map(str, ans[i]))[1:w+1])
