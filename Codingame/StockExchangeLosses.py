import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(raw_input())
maxv = -1
minv = 0
for i in raw_input().split():
    v = int(i)
    minv = min(minv, v - maxv)
    maxv = max(maxv, v)

print minv
