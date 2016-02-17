# coding: utf-8
import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

l = int(raw_input())
h = int(raw_input())
t = raw_input().upper()
ascii = []
for i in xrange(h):
    row = raw_input()
    ascii.append(row)

result = ["" for i in range(h)]
for i in xrange(len(t)):
    if ord('A') <= ord(t[i]) <= ord('Z'):
        # asciiアートを一文字づつつける
        inx = ord(t[i]) - 65
        for j in xrange(h):
            ch_row = ascii[j][inx * l:  (inx + 1) * l]
            result[j] += ch_row
    else:
        # ?をつける
        inx = 26
        for j in xrange(h):
            ch_row = ascii[j][inx * l:  (inx + 1) * l]
            result[j] += ch_row

# Write an action using print
# To debug: print >> sys.stderr, "Debug messages..."

for row in result:
    print row
