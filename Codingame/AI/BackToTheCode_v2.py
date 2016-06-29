import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
def get_first_quad_label(first_x, first_y):
    if 0 <= x < 17:
        if 0 <= y < 10:
            return 0
        if 10 <= y < 20:
            return 2
    else: # 17 <= x < 35 
        if 0 <= y < 10:
            return 1
        if 10 <= y < 20:
            return 3
    return -1

def get_first_corner(first_quad_label):
    """return (first_corner_x, first_corner_y)"""
    if first_quad_label == 0:
        return (0, 0)
    elif first_quad_label == 1:
        return (34, 0)        
    elif first_quad_label == 2:
        return (0, 19)
    else:
        return (34, 19)
    
def think(first_quad_label, x, y, opponent_x, opponent_y, owner, visited, op_visited):
    ret = "0 0"
    first_corner_x, first_corner_y = get_first_corner(first_quad_label) # the index of [UL, UR, DL, DR]
    if visited[first_corner_y][first_corner_x]:
        area_label = calcGridsInAQuad(owner)[0]
        if area_label == 0:
            t0x, t0y = 0, 0
            while t0x < 10 or t0y < 10:
                if not visited[t0y][t0x]:
                    ret = str(t0x) + " " + str(t0y)
                    break
                else:
                    t0x += 1
                    t0y += 1
                
        elif area_label == 1:
            t1x, t1y = 34, 0
            while 17 < t1x or t1y < 10:
                if not visited[t1y][t1x]:
                    ret = str(t1x) + " " + str(t1y)
                    break
                else:
                    t1x -= 1
                    t1y += 1
                
        elif area_label == 2:
            t2x, t2y = 0, 19
            while t2x < 17 or 10 < t2y:
                if not visited[t2y][t2x]:
                    ret = str(t2x) + " " + str(t2y)
                    break
                else:
                    t2x += 1
                    t2y -= 1
        else:
            t3x, t3y = 34, 19
            while 17 < t3x or 10 < t3y :
                if not visited[t3y][t3x]:
                    ret = str(t3x) + " " + str(t3y)
                    break
                else:
                    t3x -= 1
                    t3y -= 1
    else:
        ret = str(first_corner_x) + " " + str(first_corner_y)
    print(ret, file=sys.stderr)
    return ret
    
def calcGridsInAQuad(visited):
    # future: calc (max, min) in the quarter
    UL, UR, DL, DR = 0, 0, 0, 0 # count of my occupied cell
    for y in range(20):
        for x in range(35):
            if 0 <= x < 17:
                if 0 <= y < 10:
                    if visited[y][x] != -1: UL += 1
                if 10 <= y < 20:
                    if visited[y][x] != -1: DL += 1
            else: # 17 <= x < 35 
                if 0 <= y < 10:
                    if visited[y][x] != -1: UR += 1
                if 10 <= y < 20:
                    if visited[y][x] != -1: DR += 1
    ls = [UL, UR, DL, DR]
    print(ls, file=sys.stderr)
    return (ls.index(min(ls)), ls.index(max(ls)))

if __name__ == "__main__":
    
    opponent_count = int(input())  # Opponent count
    visited = [[False for i in range(35)] for j in range(20)]
    op1_visited = [[False for i in range(35)] for j in range(20)]
    op2_visited = [[False for i in range(35)] for j in range(20)]
    op3_visited = [[False for i in range(35)] for j in range(20)]
    owner = [[-1 for i in range(35)] for j in range(20)] # -1 is null, 1 is mine, 0 is opponent's

    first_x = 0
    first_y = 0
    first_quad_label = 0 # the index of [UL, UR, DL, DR]
    # game loop
    while True:
        game_round = int(input())
        # x: Your x position
        # y: Your y position
        # back_in_time_left: Remaining back in time
        x, y, back_in_time_left = [int(i) for i in input().split()]
        if game_round == 1:
            first_x = x
            first_y = y
            first_quad_label = get_first_quad_label(first_x, first_y)
        
        visited[y][x] = True
        if owner[y][x] == -1:
            owner[y][x] = 1
        for i in range(opponent_count):
            # opponent_x: X position of the opponent
            # opponent_y: Y position of the opponent
            # opponent_back_in_time_left: Remaining back in time of the opponent
            opponent_x, opponent_y, opponent_back_in_time_left = [int(j) for j in input().split()]
            op1_visited[opponent_y][opponent_x] = True    
            if owner[y][x] == -1:
                owner[y][x] = i + 1
            
        for i in range(20):
            line = input()  # One line of the map ('.' = free, '0' = you, otherwise the id of the opponent)

        # Write an action using print
        # To debug: print("Debug messages...", file=sys.stderr)
        ans = think(first_quad_label, x, y, opponent_x, opponent_y, owner, visited, op1_visited)
        # action: "x y" to move or "BACK rounds" to go back in time
        print(ans)
