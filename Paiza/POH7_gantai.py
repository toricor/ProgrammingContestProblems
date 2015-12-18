# coding: utf-8
# AC
def main():
    n   = int(raw_input())
    m1  = int(raw_input())
    ls1 = map(int, raw_input().split())
    m2  = int(raw_input())
    ls2 = map(int, raw_input().split())
    ans = []
    flag = False
    for sold in ls2:
        if sold not in ls1:
            ans.append(sold)
            flag = True
    ans = sorted(ans)
    if flag:
        print " ".join(map(str, ans))
    else:
        print "None"

main()
