# read input
m, n = map(int, input().split())
mat = [list(map(int, input().split())) for i in range(n)]

# make an labeled matrix
mat_labeled = []
temp = []
for i in range(m*n + 1):
    if (i != 0 and i%m == 0):
        mat_labeled.append(temp)
        temp = []
        if i == m * n: 
            break 
    if mat[i//m][i%m] == 0:
        temp.append(-1)
    else:
        temp.append(i)
        
#print(mat)
#print(mat_labeled)

# investigate surrounding cells and label the cells to a group. 
# a group has an index whose a minimum index cell belonging to
# bfs
visited = [[False for i in range(m)] for j in range(n)]

for x in range(m):
    for y in range(n):
        if mat[y][x] == 1:
            que = []
            que.append((x, y))
            visited[y][x] = True
            while que:
                qx, qy = que.pop()
                nextcells = [(qx+1, qy), (qx-1, qy), (qx, qy+1), (qx, qy-1)]
                for i in range(4):
                    tx = nextcells[i][0]
                    ty = nextcells[i][1]
                    if 0 <= tx < m and 0 <= ty < n and mat[ty][tx] == 1:
                        if mat_labeled[y][x] >= 0 and mat_labeled[ty][tx] >= 0 and mat_labeled[ty][tx] > mat_labeled[y][x]:
                            mat_labeled[ty][tx] = mat_labeled[y][x]
                            que.append((tx, ty))
                            visited[ty][tx] = True

#print(mat)
#print(mat_labeled)

# count unique index labels except -1
s = set()
for y in range(n):
    for x in range(m):
        s.add(mat_labeled[y][x])
if -1 in s:
    s.discard(-1)
#print(s)
print(len(s))


