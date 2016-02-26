import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

# w: width of the building.
# h: height of the building.

w, h = [int(i) for i in raw_input().split()]
n = int(raw_input())  # maximum number of turns before game over.
x, y = [int(i) for i in raw_input().split()]
w_min = 0
w_max = w - 1
h_min = 0
h_max = h - 1
# game loop
while True:
    bomb_dir = raw_input()  # the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
    if bomb_dir == "U":
        h_max = y - 1
    if bomb_dir == "UR":
        w_min = x + 1
        h_max = y - 1
    if bomb_dir == "R":
        w_min = x + 1
    if bomb_dir == "DR":
        w_min = x + 1
        h_min = y + 1
    if bomb_dir == "D":
        h_min = y + 1
    if bomb_dir == "DL":
        w_max = x - 1
        h_min = y + 1
    if bomb_dir == "L":
        w_max = x - 1
    if bomb_dir == "UL":
        w_max = x - 1
        h_max = y - 1
    
    x = (w_min + w_max)/2
    y = (h_min + h_max)/2

    # the location of the next window Batman should jump to.
    print "%s %s"%(x, y)
