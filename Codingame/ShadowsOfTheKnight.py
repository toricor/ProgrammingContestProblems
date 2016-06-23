# Python 3
w, h = [int(i) for i in input().split()]
n = int(input())  # maximum number of turns before game over.
x0, y0 = [int(i) for i in input().split()]
h_max, h_min = h, 0
w_max, w_min = w, 0
x, y = x0, y0
# game loop
while True:
    bomb_dir = input()  # the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
    if 'U' in bomb_dir:   h_max = y - 1
    elif 'D' in bomb_dir: h_min = y + 1
    if 'R' in bomb_dir:   w_min = x + 1
    elif 'L' in bomb_dir: w_max = x - 1
    x = int((w_min + w_max)/2)
    y = int((h_min + h_max)/2)
    print(x, y)
