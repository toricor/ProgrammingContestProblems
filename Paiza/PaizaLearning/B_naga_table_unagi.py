# coding: utf-8
def update_table(a, b, table):
    old_table = list(table)
    for i, v in enumerate(table[b-1: b-1 + a]):
        if v == 1:
            #print(a, b, old_table)
            return old_table
        else:
            table[(b-1 + i)%n] = 1
            table[b-1 + i] = 1
            table[b-1 + i + n] = 1
    #print(a, b, table)
    return table

n, m = map(int, input().split())
table = [0 for i in range(n* 3)]
for i in range(m):
    a, b = map(int, input().split())
    table = update_table(a, b, table)
print(sum(table[:n]))
