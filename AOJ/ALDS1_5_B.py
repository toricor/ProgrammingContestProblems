# coding: utf-8
# Here your code !
count = 0

def merge(A, left, mid, right):
    global count
    n1 = mid - left
    n2 = right - mid
    L = [0 for i in xrange(n1 + 1)]
    R = [0 for i in xrange(n2 + 1)]
    for i in xrange(n1):
        L[i] = A[left + i]
    for i in xrange(n2):
        R[i] = A[mid + i]
    L[n1] = 1<<32 - 1
    R[n2] = 1<<32 - 1
    i = 0
    j = 0
    for k in xrange(left, right):
        count += 1
        if L[i] <= R[j]:
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j]
            j += 1

def mergeSort(A, left, right):
    if left + 1 < right:
        mid = (left + right) / 2
        mergeSort(A, left, mid)
        mergeSort(A, mid, right)
        merge(A, left, mid, right)
        
if __name__ == "__main__":
    n = int(raw_input())
    refA = map(int, raw_input().split())
    A = list(refA)
    mergeSort(A, 0, n)
    print " ".join(map(str,A))
    print count 
