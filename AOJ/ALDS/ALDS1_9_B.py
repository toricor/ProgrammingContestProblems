# coding: utf-8
def maxHeapify(A, i):
    l = 2*i
    r = 2*i+1
    
    if l <= H and A[l] > A[i]:
        largest = l
    else:
        largest = i
        
    if r <= H and A[r] > A[largest]:
        largest = r
    if largest != i:
        A[i], A[largest] = A[largest], A[i]
        maxHeapify(A, largest)
        
def buildMaxHeap(A):
    for i in xrange(H/2,0,-1):
        maxHeapify(A,i)

H = int(raw_input())
A = map(int, [0]+raw_input().split())
buildMaxHeap(A)
print " " + " ".join(map(str,A[1:]))
