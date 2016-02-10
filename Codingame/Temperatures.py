import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
def main():
    n = int(raw_input())  # the number of temperatures to analyse
    if n == 0:
        print 0
        return
    temps = map(int, raw_input().split())  # the n temperatures expressed as integers ranging from -273 to 5526
    sorted_temps = sorted(temps, key=lambda x: abs(x))
    if len(sorted_temps) >= 2 and sorted_temps[0] * sorted_temps[1] < 0 and (abs(sorted_temps[0]) == abs(sorted_temps[1])):
        print abs(sorted_temps[0])
    else:
        print sorted_temps[0]
    
main()
