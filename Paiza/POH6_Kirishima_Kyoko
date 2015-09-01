# coding: utf-8
def canBeSolved(ls, query):
  if query >= len(ls): 
    return False
  elif query == len(ls) - 1:
    return True

  visited = [False for i in xrange(len(ls))]
  index = query
  while 0 <= index < len(ls) and visited[index] == False:
    visited[index] = True
    delta = ls[index]
    
    if delta == 0:
      return False
    else:
      tmp_index = index + delta
      if tmp_index == len(ls) - 1:
        return True
      else:
        index = tmp_index
  else:
    return False

if __name__ == "__main__":
  n = int(raw_input())
  ls = map(int, raw_input().split())
  m = int(raw_input())
  for i in xrange(m):
    q = int(raw_input())
    if canBeSolved(ls, q):
      print "Yes"
    else:
      print "No"
