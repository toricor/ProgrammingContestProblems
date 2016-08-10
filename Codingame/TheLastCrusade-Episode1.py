import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

# w: number of columns.
# h: number of rows.
class Indy:
    x = 0
    y = 0
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def next_cell(self, pos, map):
        #print(self.x, self.y ,file=sys.stderr)
        next_x, next_y = self.x, self.y
        xy_dif = mk_dif(convert_type(map[self.y][self.x], pos))
        return (self.x + xy_dif[0], self.y + xy_dif[1])
        
        
def mk_dif(direction):
    if direction == "TOP":
        return (0, 1)
    if direction == "RIGHT":
        return (-1, 0)
    if direction == "LEFT":
        return (1, 0)
        
def convert_type(type_id, input_direction):
    type_id = int(type_id)
    if type_id == 0:
        pass
    if type_id == 1:
        return "TOP"
    if type_id == 2 or type_id == 6:
        if input_direction == "LEFT":
            return "LEFT"
        if input_direction == "RIGHT":
            return "RIGHT"
    if type_id == 3 or type_id == 7 or type_id == 8 or type_id == 9 or type_id == 12 or type_id == 13:
        return "TOP"
    if type_id == 4:
        if input_direction == "TOP":
            return "RIGHT"
        if input_direction == "RIGHT":
            return "TOP"
    if type_id == 5:
        if input_direction == "TOP":
            return "LEFT"
        if input_direction == "LEFT":
            return "TOP"
    if type_id == 10:
        return "RIGHT"
    if type_id == 11:
        return "LEFT"
    
    
w, h = [int(i) for i in input().split()]
map = []
for i in range(h):
    line = input().split()  # represents a line in the grid and contains W integers. Each integer represents one room of a given type.
    map.append(line)
ex = int(input())  # the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
print(map,file=sys.stderr)
# game loop
indy = Indy(0, 0)
while True:
    xi, yi, pos = input().split()
    indy.x = int(xi)
    indy.y = int(yi)
    next_x, next_y = indy.next_cell(pos, map)
    # Write an action using print
    # To debug: print("Debug messages...", file=sys.stderr)

    # One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
    print(next_x, next_y)
