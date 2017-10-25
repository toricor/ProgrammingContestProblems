# coding: utf-8
import copy

def bfs(n, ls, mat):
    tmat = copy.deepcopy(mat)
    cnt = 0
    for a, b in ls:
        tmat[a][b] = tmat[b][a] = 0
        visited = [0 for i in range(n+2)]
        que = [a]
        
        while que:
            st = que.pop(0)
            visited[st] = 1
            for i in range(1, n + 1):
                if tmat[st][i] == 1 and visited[i] != 1:
                    que.append(i)
                    
        tmat = copy.deepcopy(mat)
        if sum(visited) != n:
            cnt += 1
    return cnt

n, m = list(map(int, input().split()))
ls = []
for i in range(m):
    a, b = list(map(int, input().split()))
    ls.append((a, b))
    
mat = [[0 for i in range(m + 2)] for j in range(m + 2)]
for a, b in ls:
    mat[a][b] = mat[b][a] = 1
    
cnt = bfs(n, ls, mat)
print(cnt)
