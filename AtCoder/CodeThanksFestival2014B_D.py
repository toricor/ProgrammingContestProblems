# coding: utf-8
def fillxtimes(A, ashiList):
    for i in xrange(1, len(ashiList)):
        if i%A == 0:
            ashiList[i] += 1
            
if __name__ == "__main__":
    N, T = map(int, raw_input().split())
    #AList = []
    ashiList = [0 for i in xrange(T + 1)]
    for i in xrange(N):
        A = int(raw_input())
        #AList.append(A)
        fillxtimes(A, ashiList)
    print max(ashiList)
