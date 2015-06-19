# coding: utf-8
s = raw_input()
n = len(s)
flag_AB = False
flag_BA = False
if n < 4:
    print "NO"
else:
    for i in range(n-1):
        if s[i:i+2] =="AB":
            flag_AB = True
            if s[i+1:i+3] == "BA":
                flag_AB = False
        if s[i:i+2] =="BA":
            flag_BA = True
            if s[i+1:i+3] == "AB":
                flag_BA = False
    if flag_AB and flag_BA:
        print "YES"
    else:
        print "NO"
